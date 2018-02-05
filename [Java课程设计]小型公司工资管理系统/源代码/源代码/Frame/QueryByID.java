package Frame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Person.Person;
import Util.JDBC;
import Util.Parameter;

import java.awt.*;
import java.awt.event.*;

public class QueryByID extends JFrame implements ActionListener{
	
	DefaultTableModel tableModel;
	int row;
	boolean debug = false;
	String[] items = new String[6];
	
	// 界面有关变量
		JPanel jpl = new JPanel();
		JPanel jpl1 = new JPanel();
		JPanel jpl2 = new JPanel();
		ImageIcon background = new ImageIcon("Insertbackground.jpg");
		JLabel Insertbackground = new JLabel(background);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = (int) screensize.getWidth();
		int h = (int) screensize.getHeight();
		JLabel jlb_no = new JLabel("编号：");
		JLabel jlb_name = new JLabel("姓名：");
		JLabel jlb_sex = new JLabel("性别：");
		JLabel jlb_age = new JLabel("年龄：");
		JLabel jlb_phone = new JLabel("电话：");
		JLabel jlb_department = new JLabel("部门：");
		JLabel jlb_kind = new JLabel("级别：");		
		JLabel jlb_hours = new JLabel("工作时间：");
		JLabel jlb_sells = new JLabel("月销售额：");
		JLabel jlb_salary = new JLabel("工资总额：");
		
		JTextField jtf_no = new JTextField();
		JTextField jtf_name = new JTextField();
		JTextField jtf_age = new JTextField();
		JTextField jtf_phone = new JTextField();
		//JTextField jtf_department = new JTextField();
		//JTextField jtf_kind = new JTextField();
		JTextField jtf_hours = new JTextField();
		JTextField jtf_sells = new JTextField();
		JTextField jtf_salary = new JTextField();
		
		Font jlb_ = new Font("consolas", Font.BOLD, 30);
		
		JComboBox jcb_kind = new JComboBox();
		JComboBox jcb_department  = new JComboBox();
		
		
		ButtonGroup SexGroup = new ButtonGroup();
		JRadioButton jrb_M = new JRadioButton("男",true);
		JRadioButton jrb_F = new JRadioButton("女",false);
		
		JButton jbt_update = new JButton("修 改");
		JButton jbt_delete = new JButton("删 除");
		JButton jbt_cancel = new JButton("确 定");
		Font buttonFont = new Font("consolas",  Font.BOLD | Font.ITALIC, 15);
		
		String choose = "男";
		String oldID;
		
		
		
		Person oldP;

		
		public QueryByID(DefaultTableModel table,int row,String result){
			
			
			String[] item =  result.split("@");
			this.row = row;
			this.tableModel = table;
			
			
			
			this.setTitle("按员工编号查找结果");
			this.setResizable(false); // 大小不可改变
			// 设置边界大小
			Insertbackground.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			jpl= (JPanel) this.getContentPane();
			jpl.setOpaque(false);
			this.getLayeredPane().setLayout(null);
			this.getLayeredPane().add(Insertbackground, new Integer(Integer.MIN_VALUE));
			// 适应图片大小
			this.setSize(background.getIconWidth(), background.getIconHeight());


			jpl.setLayout(null);
			JLabel main_tittle = new JLabel("查 找 结 果");
			// 改变字体，下同
			Font main_font = new Font("宋体", Font.BOLD | Font.ITALIC, 50);
			main_tittle.setFont(main_font);

			
			
			//jpl.add(main_tittle);
			main_tittle.setForeground(Color.WHITE);
			main_tittle.setSize(500, 50);
			main_tittle.setLocation(70, 50);
		
			jpl.add(jlb_no);
			jlb_no.setFont(jlb_);
			jlb_no.setForeground(Color.WHITE);
			jlb_no.setSize(150,100);
			jlb_no.setLocation(50, 130);
			jpl.add(jtf_no);
			jtf_no.setSize(200,30);
			jtf_no.setLocation(200, 167);
			jtf_no.setText(item[0]);
			jtf_no.setForeground(new Color(105,105,105));
			oldID = item[0];

		
			jpl.add(jlb_name);
			jlb_name.setForeground(Color.WHITE);
			jlb_name.setFont(jlb_);
			jlb_name.setSize(150, 100);
			jlb_name.setLocation(50, 180);
			jpl.add(jtf_name);
			jtf_name.setSize(200,30);
			jtf_name.setLocation(200, 217);
			jtf_name.setText(item[1]);
			jtf_name.setForeground(new Color(105,105,105));


			
			jrb_M.setFont(jlb_);
			jrb_M.setForeground(Color.PINK);
			jrb_F.setFont(jlb_);
			jrb_F.setForeground(Color.WHITE);
			jpl.add(jlb_sex);
			jlb_sex.setForeground(Color.WHITE);
			jlb_sex.setFont(jlb_);
			jlb_sex.setSize(150, 100);
			jlb_sex.setLocation(50, 230);
			SexGroup.add(jrb_M);
			SexGroup.add(jrb_F);
			jpl.add(jrb_M);
			jpl.add(jrb_F);
			jrb_F.setOpaque(false);
			jrb_M.setOpaque(false);
			jrb_M.setSize(100,50);
			jrb_M.setLocation(200, 257);
			jrb_F.setSize(100,50);
			jrb_F.setLocation(300, 257);
			jrb_M.addActionListener(this);
			jrb_F.addActionListener(this);
			if(item[2].equals("男")) {
				jrb_M.setSelected(true);
			}else {
				jrb_F.setSelected(true);
			}
		
			jpl.add(jlb_age);
			jlb_age.setForeground(Color.WHITE);
			jlb_age.setFont(jlb_);
			jlb_age.setSize(150, 100);
			jlb_age.setLocation(50, 280);
			jpl.add(jtf_age);
			jtf_age.setSize(200,30);
			jtf_age.setLocation(200, 317);
			jtf_age.setText(item[3]);
			jtf_age.setForeground(new Color(105,105,105));
			
			
			jpl.add(jlb_phone);
			jlb_phone.setForeground(Color.WHITE);
			jlb_phone.setFont(jlb_);
			jlb_phone.setSize(150, 100);
			jlb_phone.setLocation(50, 330);
			jpl.add(jtf_phone);
			jtf_phone.setSize(200,30);
			jtf_phone.setLocation(200, 367);
			jtf_phone.setText(item[4]);
			jtf_phone.setForeground(new Color(105,105,105));
			
			
			jpl.add(jlb_department);
			jlb_department.setForeground(Color.WHITE);
			jlb_department.setFont(jlb_);
			jlb_department.setSize(150, 100);
			jlb_department.setLocation(50, 380);
			jpl.add(jcb_department);
			jcb_department.setSize(200,30);
			jcb_department.setLocation(200, 417);
			jcb_department.setForeground(new Color(105,105,105));
			jcb_department.addItem("技术部");
			jcb_department.addItem("美工部");
			jcb_department.addItem("销售部");
			jcb_department.addItem("运营部");
			jcb_department.addItem("宣传部");
			jcb_department.setSelectedItem(item[5].toString());
			
			jpl.add(jlb_kind);
			jlb_kind.setForeground(Color.WHITE);
			jlb_kind.setFont(jlb_);
			jlb_kind.setSize(150, 100);
			jlb_kind.setLocation(50, 430);
			jpl.add(jcb_kind);
			jcb_kind.addItem("经理");
			jcb_kind.addItem("技术人员");
			jcb_kind.addItem("销售人员");
			jcb_kind.addItem("销售经理");
			jcb_kind.addActionListener(this);
			jcb_kind.setSize(200,30);
			jcb_kind.setLocation(200, 467);
			int kind_seleted = Integer.parseInt(item[6]);
			if(kind_seleted==1) {
				jcb_kind.setSelectedItem("经理");
			}else if(kind_seleted==2) {
				jcb_kind.setSelectedItem("技术人员");
			}else if(kind_seleted==3) {
				jcb_kind.setSelectedItem("销售人员");
			}else {
				jcb_kind.setSelectedItem("销售经理");
			}
			
			
			jpl.add(jlb_hours);
			jlb_hours.setForeground(Color.WHITE);
			jlb_hours.setFont(jlb_);
			jlb_hours.setSize(150, 100);
			jlb_hours.setLocation(50, 480);
			jpl.add(jtf_hours);
			jtf_hours.setSize(200,30);
			jtf_hours.setLocation(200, 517);
			jtf_hours.setText(item[7]);
			jtf_hours.setForeground(new Color(105,105,105));
		

			
			jpl.add(jlb_sells);
			jlb_sells.setForeground(Color.WHITE);
			jlb_sells.setFont(jlb_);
			jlb_sells.setSize(150, 100);
			jlb_sells.setLocation(50, 530);
			jpl.add(jtf_sells);
			jtf_sells.setSize(200,30);
			jtf_sells.setLocation(200, 567);
			jtf_sells.setText(item[8]);
			jtf_sells.setForeground(new Color(105,105,105));
			
			jpl.add(jlb_salary);
			jlb_salary.setForeground(Color.WHITE);
			jlb_salary.setFont(jlb_);
			jlb_salary.setSize(150, 100);
			jlb_salary.setLocation(50, 580);
			jpl.add(jtf_salary);
			jtf_salary.setSize(200,30);
			jtf_salary.setLocation(200, 617);
			jtf_salary.setText(item[9]);
			jtf_salary.setForeground(new Color(105,105,105));
			jtf_salary.setEditable(false);
			

			
			
			jpl.add(jbt_update);
			jpl.add(jbt_delete);
			jpl.add(jbt_cancel);
			jbt_cancel.setFont(buttonFont);
			jbt_delete.setFont(buttonFont);
			jbt_update.setFont(buttonFont);
			jbt_update.setSize(80,40);
			jbt_update.setLocation(100, 700);
			jbt_delete.setSize(80,40);
			jbt_delete.setLocation(190, 700);
			jbt_cancel.setSize(80,40);
			jbt_cancel.setLocation(280, 700);
			jbt_update.addActionListener(this);
			jbt_cancel.addActionListener(this);
			jbt_delete.addActionListener(this);
			
			oldP = new Person(item[0], item[1], item[2], Integer.parseInt(item[3]), item[4], item[5], Integer.parseInt(item[6]), Integer.parseInt(item[7]), Double.parseDouble(item[8]));
			this.setLocation(500, 20);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()==jbt_cancel)
			{
				if(debug==true)
				{
					tableModel.removeRow(row);
					tableModel.addRow(items);
					tableModel.fireTableDataChanged();	
				}
				this.dispose();

			}
			
			if(e.getSource()==jrb_M)
			{
				jrb_M.setForeground(Color.PINK);
				jrb_F.setForeground(Color.WHITE);
				choose = "男";
			}
			if(e.getSource()==jrb_F)
			{
				jrb_F.setForeground(Color.PINK);
				jrb_M.setForeground(Color.WHITE);
				choose = "女";
			}
			
			if(e.getSource()==jbt_delete)
			{
				int flag = JDBC.deleteFromsql(oldID);
				if(flag==1) {
					JOptionPane.showMessageDialog(this, "旧信息已不存在！");
					this.dispose();

				}
				else if(flag==2) {
					JOptionPane.showMessageDialog(this, "数据库连接失败！");
					return;
				}
				else {
					JOptionPane.showMessageDialog(this, "删除成功！");
					tableModel.removeRow(row);
					tableModel.fireTableDataChanged();	
					this.dispose();

				}
			}
			
			if(e.getSource()==jbt_update)
			{
				 String ID = jtf_no.getText();
				 String name = jtf_name.getText();
				 String sex;
				 if(jrb_M.isSelected()==true)
				  sex ="男";
				 else sex = "女";
				 String age = jtf_age.getText();
				 String phone = jtf_phone.getText();
				// String department = jtf_department.getText();
				 String hours = jtf_hours.getText();
				 //String kind = jtf_kind.getText();
				 String sells = jtf_sells.getText();

				 
				 //判断是否有空项
				 if(ID.equals(null)||name.equals(null)||sex.equals(null)||age.equals(null)||phone.equals(null)||
						 hours.equals(null)||sells.equals(null)
					||ID.equals("")||name.equals("")||sex.equals("")||age.equals("")||phone.equals("")||
					hours.equals("")||sells.equals(""))
				 {
					 JOptionPane.showMessageDialog(this, "记录不能有空项");
					 return;
				 }
				 
				 
				 //判断格式是否正确
				 try{
					  Integer.parseInt(age);
				 }catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "[年龄] 格式错误");
					return;
				 }
				 try{
					  Integer.parseInt(hours);
				 }catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "[工作时间] 格式错误");
					return;
				 }
				 try{
					  Double.parseDouble(sells);
				 }catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "[月销售额] 格式错误");
					return;
				 }
				 
				
				 
				 		int kinds=1;		
						Object selected = jcb_kind.getSelectedItem();
						if(selected.equals("经理"))
						{
							 kinds = 1;
						}else if(selected.equals("技术人员")) {
							 kinds = 2;
						 }else if(selected.equals("销售人员")) {
							 kinds = 3;
						 }else {
							 kinds = 4;
						 }
					
				 
				 
				
					 
				 int n = JOptionPane.showConfirmDialog(this, "确认修改？","确认",JOptionPane.OK_CANCEL_OPTION );
				 if(n!=0)return;
				 Person newP = new Person(ID, name, sex, Integer.parseInt(age), phone, jcb_department.getSelectedItem().toString(), kinds,Integer.parseInt(hours),Double.parseDouble(sells));
			
				int flag = JDBC.UpdateFromsql(newP, oldP);
				if(flag==1)
				{
					JOptionPane.showMessageDialog(this, "旧信息已不存在！");
					this.dispose();
					new MainFrame();
				}
				else if(flag==2)
				{
					JOptionPane.showMessageDialog(this, "编号已存在！添加失败");
					return;
				}
				else if(flag==3||flag==4)
				{
					this.dispose();

				}
				else 
				{
					JOptionPane.showMessageDialog(this, "修改成功");
					oldP = new Person(ID, name, sex, Integer.parseInt(age), phone, jcb_department.getSelectedItem().toString(), kinds,Integer.parseInt(hours),Double.parseDouble(sells));
					double newSalary;
					switch (kinds) {
					case 1:
						newSalary = Parameter.BASE;
					break;

					case 2:
						newSalary = Parameter.HOUR*Integer.parseInt(hours);
					break;

					case 3:
						newSalary = Parameter.Parameter*Double.parseDouble(sells);
					break;

					case 4:
						newSalary = Parameter.BASE + Parameter.Parameter*Double.parseDouble(sells);
					break;

							default:
								return;
							}
					java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
					df.format(newSalary);
					jtf_salary.setText(String.valueOf(newSalary));
					oldID = ID;
					debug = true;
					items[0] = ID;
					items[1] = name;
					items[2] = sex;
					items[3] = jcb_department.getSelectedItem().toString();
					items[4] = selected.toString();
					items[5] = String.valueOf(newSalary);
				}
				
				
				
				 
			}
			
			
		}



		

		


}
