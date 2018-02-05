package Frame;

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
import javax.swing.table.TableModel;

import Util.JDBC;

public class DisplayFrame  extends JPanel{

	JTable table;
	DefaultTableModel tableModel;
	
	public DisplayFrame(String result) {
		super(new BorderLayout());
				String[] columnNames = { "编号", "姓名", "性别", "部门", "级别", "工资总额", "" };

				String[] item = result.split("#");
				int rows = item.length;

				// 创建显示数据
				Object[][] data = new Object[rows][];
				for (int i = 0; i < rows; i++) {
					String[] atom = item[i].split("@");
					if (Integer.parseInt(atom[6]) == 1) {
						atom[6] = "经理";
					} else if (Integer.parseInt(atom[6]) == 2) {
						atom[6] = "技术人员";
					} else if (Integer.parseInt(atom[6]) == 3) {
						atom[6] = "销售人员";
					} else if (Integer.parseInt(atom[6]) == 4) {
						atom[6] = "销售经理";
					}
					data[i] = new Object[] { atom[0], atom[1], atom[2], atom[5], atom[6], atom[9], null };
				}

				/*
				 * JTable还提供了一个重载的构造方法,传入两个Vector JTable(Vector rowData, Vector columnNames)
				 * 
				 */

					tableModel = new DefaultTableModel(data, columnNames) {
					@Override
					public boolean isCellEditable(int row, int column) {
						if(column!=6)
						return false;
						else return true;
					}
				};
				 table = new JTable(tableModel);
				table.setBackground(new Color(248, 248, 255));
				// Create the scroll pane and add the table to it.
				// 这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示
				JScrollPane scrollPane = new JScrollPane(table);
				TableRender render = new TableRender();
				TableEditor editor = new TableEditor(new JTextField());
				table.getColumnModel().getColumn(6).setCellRenderer(render);
				table.getColumnModel().getColumn(6).setCellEditor(editor);
				table.setRowHeight(40);
				initColumnSize(table);
				this.add(scrollPane);
	}
	





	public static void createAndShowGUI(String result) {
		// Create and set up the window.
		JFrame frame = new JFrame("查 询 结 果");
		// Create and set up the content pane.
		DisplayFrame newContentPane = new DisplayFrame(result);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.setLocation(200, 130);
		frame.setSize(1050, 600);
		// frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				new MainFrame();

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	 void initColumnSize(JTable table) {
		// 表格的每一列也是一个组件
		TableColumn tc = null;

		tc = table.getColumnModel().getColumn(0);
		tc.setPreferredWidth(60);

		tc = table.getColumnModel().getColumn(1);
		tc.setPreferredWidth(60);

		tc = table.getColumnModel().getColumn(2);
		tc.setPreferredWidth(40);

		tc = table.getColumnModel().getColumn(3);
		tc.setPreferredWidth(60);

		tc = table.getColumnModel().getColumn(4);
		tc.setPreferredWidth(50);

		tc = table.getColumnModel().getColumn(5);
		tc.setPreferredWidth(60);

	}

	class TableRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (column != 6)
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			else {
				JButton label = new JButton("选择");
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
			if (column != 6)
				return super.getTableCellEditorComponent(table, value, isSelected, row, column);
			else {
				JButton label = new JButton("选择");
				label.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String result = JDBC.searchByID(table.getValueAt(row, 0).toString());
						if (result == null || result.equals(null)) {
							JOptionPane.showMessageDialog(null, "信息已删除或不存在！");
							return;
						} else if (result.equals("Fail")) {
							JOptionPane.showMessageDialog(null, "查询失败");
							return;
						} else {
							new QueryByID(tableModel, row, result);

						}

					}
				});
				label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getPreferredWidth(), 20));
				return label;
			}
		}
	}

	

	
	
	
}
