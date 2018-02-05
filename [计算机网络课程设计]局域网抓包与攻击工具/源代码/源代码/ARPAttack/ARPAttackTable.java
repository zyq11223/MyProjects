package ARPAttack;

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

public class ARPAttackTable extends JPanel {

	JTable table;
	DefaultTableModel tableModel;
	String[] columnNames = { "                                                                                                                                                        " };

	public ARPAttackTable() {
		// 创建表头
		super(new BorderLayout());
		tableModel = new DefaultTableModel(null,columnNames);
		table = new JTable(tableModel);
		table.setBackground(new Color(248, 248, 255));

		// Create the scroll pane and add the table to it.
		// 这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示
		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);

		table.setRowHeight(40);
	}

	public void InsertRow(String info) {

		String[] items = new String[1];
		items[0] = "－－－－－>                                                                             "+info;



		
		tableModel.addRow(items);
		tableModel.fireTableDataChanged();
	}



	public void DeleteRow(int row) {//删除某一列

		tableModel.removeRow(row);
		tableModel.fireTableDataChanged();
	}
	
	public void DeleteAll() {//刷新列表
		for(int i=tableModel.getRowCount()-1;i>=0;i--)
		{
			tableModel.removeRow(i);
		}

	}
}
