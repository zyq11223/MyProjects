package GrabbingPacketsFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.util.TableOrder;

import HandleJpcap.AllPackages;
import HandleJpcap.Packages;
import Util.JDBC;

public class PackagesTable extends JPanel {

	JTable table;
	DefaultTableModel tableModel;
	String[] columnNames = { "编号","数据包标识", "协议", "源IP地址", "目的IP地址", "版本", "数据包长度", "" };

	public PackagesTable() {
		// 创建表头
		super(new BorderLayout());

		// 创建显示数据
		Object[][] data = new Object[AllPackages.allpackages.size()][];
		
		for (int i = 0; i < AllPackages.allpackages.size(); i++) {

			Packages p = AllPackages.allpackages.get(i);

			data[i] = new Object[] {p.ID,p.ident, p.protocol, p.srcIP, p.dstIP, p.version, p.total_length, null };

		}
		/*
		 * JTable还提供了一个重载的构造方法,传入两个Vector JTable(Vector rowData, Vector columnNames)
		 * 
		 */

		tableModel = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 7)
					return false;
				else
					return true;
			}
		};

		table = new JTable(tableModel);

		table.setBackground(new Color(248, 248, 255));

		// Create the scroll pane and add the table to it.
		// 这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示
		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);
		initColumnSize(table);
		TableRender render = new TableRender();
		TableEditor editor = new TableEditor(new JTextField());
		table.getColumnModel().getColumn(7).setCellRenderer(render);
		table.getColumnModel().getColumn(7).setCellEditor(editor);

		// table.setSize(1200,800);
		// this.setSize(1200,800);
		table.setRowHeight(40);
	}

	public void InsertRow(Packages p) {

		String[] items = new String[8];
		items[0] = String.valueOf(p.ID);
		items[1] = p.ident;
		items[2] = p.protocol;
		items[3] = p.srcIP;
		items[4] = p.dstIP;
		items[5] = p.version;
		items[6] = p.total_length;


		
		tableModel.addRow(items);
		tableModel.fireTableDataChanged();
	}

	
	private void initColumnSize(JTable table) {
		// 表格的每一列也是一个组件
		TableColumn tc = null;

		tc = table.getColumnModel().getColumn(0);
		tc.setPreferredWidth(20);

		tc = table.getColumnModel().getColumn(1);
		tc.setPreferredWidth(30);

		tc = table.getColumnModel().getColumn(2);
		tc.setPreferredWidth(20);

		tc = table.getColumnModel().getColumn(3);
		tc.setPreferredWidth(100);

		tc = table.getColumnModel().getColumn(4);
		tc.setPreferredWidth(100);

		tc = table.getColumnModel().getColumn(5);
		tc.setPreferredWidth(20);
		
		tc = table.getColumnModel().getColumn(6);
		tc.setPreferredWidth(20);

	}

	class TableRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (column != 7)
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			else {
				JButton label = new JButton("查看");
				label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(), 20));
				return label;
			}
		}
	}

	class TableEditor extends DefaultCellEditor {
		public TableEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public TableEditor(JComboBox comboBox) {
			super(comboBox);
		}

		public TableEditor(JTextField textField) {
			super(textField);
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (column != 7)
				return super.getTableCellEditorComponent(table, value, isSelected, row, column);
			else {
				JButton label = new JButton("查看");
				label.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						

						Packages p = AllPackages.allpackages.get(row);
						if(p.version.equals("ARP"))
							new ARPPackageFrame(p);
						else
						new IPPackageFrame(p);
						

					}
				});
				label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(), 20));
				return label;
			}
		}
	}

	
}
