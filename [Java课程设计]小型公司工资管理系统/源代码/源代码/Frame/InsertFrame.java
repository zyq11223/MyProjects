package Frame;
import javax.swing.*;

import Person.Person;
import Util.JDBC;

import java.awt.*;
import java.awt.event.*;

public class InsertFrame extends JFrame implements ActionListener,WindowListener{
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
		//JTextField jtf3 = new JTextField();
		JTextField jtf_age = new JTextField();
		JTextField jtf_phone = new JTextField();
		//JTextField jtf_department = new JTextField();
		//JTextField jtf_kind = new JTextField();
		JTextField jtf_hours = new JTextField();
		JTextField jtf_sells = new JTextField();
		JTextField jtf_salary = new JTextField();
		
		Font jlb_ = new Font("consolas", Font.BOLD, 30);
		
		JComboBox jcb_kind = new JComboBox();
		JComboBox jcb_department = new JComboBox();
		
		
		ButtonGroup SexGroup = new ButtonGroup();
		JRadioButton jrb_M = new JRadioButton("男",true);
		JRadioButton jrb_F = new JRadioButton("女",false);
		
		Font buttonFont = new Font("consolas",  Font.BOLD | Font.ITALIC, 20);
		JButton jbt_insert = new JButton("确 定");		
		JButton jbt_cancel = new JButton("取 消");
		
		String choose = "男";

		
		public InsertFrame(){

			this.addWindowListener(this);
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
			JLabel main_tittle = new JLabel("添 加 新 记 录");
			// 改变字体，下同
			Font main_font = new Font("consolas", Font.BOLD | Font.ITALIC, 40);
			main_tittle.setFont(main_font);

			
			
			//jpl.add(main_tittle);
			main_tittle.setForeground(Color.WHITE);
			main_tittle.setSize(500, 60);
			main_tittle.setLocation(70, 50);
		
			jpl.add(jlb_no);
			jlb_no.setFont(jlb_);
			jlb_no.setForeground(Color.WHITE);
			jlb_no.setSize(150,100);
			jlb_no.setLocation(50, 130);
			jpl.add(jtf_no);
			jtf_no.setSize(200,30);
			jtf_no.setLocation(200, 167);

		
			jpl.add(jlb_name);
			jlb_name.setForeground(Color.WHITE);
			jlb_name.setFont(jlb_);
			jlb_name.setSize(150, 100);
			jlb_name.setLocation(50, 180);
			jpl.add(jtf_name);
			jtf_name.setSize(200,30);
			jtf_name.setLocation(200, 217);


			
			jrb_M.setFont(jlb_);
			jrb_M.setForeground(Color.PINK);
			jrb_F.setFont(jlb_);
			jrb_F.setForeground(Color.white);
			jpl.add(jlb_sex);
			jlb_sex.setForeground(Color.white);
			jlb_sex.setFont(jlb_);
			jlb_sex.setSize(150, 100);
			jlb_sex.setLocation(50, 230);
			jrb_F.setOpaque(false);
			jrb_M.setOpaque(false);
			SexGroup.add(jrb_M);
			SexGroup.add(jrb_F);
			jpl.add(jrb_M);
			jpl.add(jrb_F);
			jrb_M.setSize(100,50);
			jrb_M.setLocation(200, 257);
			jrb_F.setSize(100,50);
			jrb_F.setLocation(300, 257);
			jrb_M.addActionListener(this);
			jrb_F.addActionListener(this);
		
			jpl.add(jlb_age);
			jlb_age.setForeground(Color.WHITE);
			jlb_age.setFont(jlb_);
			jlb_age.setSize(150, 100);
			jlb_age.setLocation(50, 280);
			jpl.add(jtf_age);
			jtf_age.setSize(200,30);
			jtf_age.setLocation(200, 317);
			
			
			jpl.add(jlb_phone);
			jlb_phone.setForeground(Color.WHITE);
			jlb_phone.setFont(jlb_);
			jlb_phone.setSize(150, 100);
			jlb_phone.setLocation(50, 330);
			jpl.add(jtf_phone);
			jtf_phone.setSize(200,30);
			jtf_phone.setLocation(200, 367);
			
			
			jpl.add(jlb_department);
			jlb_department.setForeground(Color.WHITE);
			jlb_department.setFont(jlb_);
			jlb_department.setSize(150, 100);
			jlb_department.setLocation(50, 380);
			jpl.add(jcb_department);
			jcb_department.setSize(200,30);
			jcb_department.setLocation(200, 417);
			jcb_department.addItem("技术部");
			jcb_department.addItem("美工部");
			jcb_department.addItem("销售部");
			jcb_department.addItem("运营部");
			jcb_department.addItem("宣传部");
			
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
			jcb_kind.setSize(200,30);
			jcb_kind.setLocation(200, 467);
			
			jpl.add(jlb_hours);
			jlb_hours.setForeground(Color.WHITE);
			jlb_hours.setFont(jlb_);
			jlb_hours.setSize(150, 100);
			jlb_hours.setLocation(50, 480);
			jpl.add(jtf_hours);
			jtf_hours.setSize(200,30);
			jtf_hours.setLocation(200, 517);
		

			
			jpl.add(jlb_sells);
			jlb_sells.setForeground(Color.WHITE);
			jlb_sells.setFont(jlb_);
			jlb_sells.setSize(150, 100);
			jlb_sells.setLocation(50, 530);
			jpl.add(jtf_sells);
			jtf_sells.setSize(200,30);
			jtf_sells.setLocation(200, 567);
			

			
			jbt_insert.setFont(buttonFont);
			jbt_cancel.setFont(buttonFont);
			jpl.add(jbt_insert);
			jpl.add(jbt_cancel);
			jbt_insert.setSize(100,50);
			jbt_insert.setLocation(80, 650);
			jbt_cancel.setSize(100,50);
			jbt_cancel.setLocation(260, 650);
			jbt_insert.addActionListener(this);
			jbt_cancel.addActionListener(this);
			this.setLocation(500, 20);
			this.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			
			if(e.getSource()==jbt_cancel)
			{
				this.dispose();
				new MainFrame();

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
				jrb_M.setForeground(Color.white);
				choose = "女";
			}
			
			if(e.getSource()==jbt_insert)
			{
				 String ID = jtf_no.getText();
				 String name = jtf_name.getText();
				 String sex =choose;
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
					
				 
				 
				
					 
				 int n = JOptionPane.showConfirmDialog(this, "确认添加？","确认",JOptionPane.OK_CANCEL_OPTION );
				 if(n!=0)return;
				 Person person = new Person(ID, name, sex, Integer.parseInt(age), phone, jcb_department.getSelectedItem().toString(), kinds,Integer.parseInt(hours),Double.parseDouble(sells));
			
				int flag = JDBC.insertIntoSql(person);
				if(flag==1)
				{
					JOptionPane.showMessageDialog(this, "编号重复！添加失败");
					return;
				}
				else if(flag==2)
				{
					JOptionPane.showMessageDialog(this, "数据库连接失败！");
					return;
				}
				
				
				
				 int m = JOptionPane.showConfirmDialog(this, "添加成功，是否继续添加？","确认",JOptionPane.OK_CANCEL_OPTION );
				 if(m!=0)
					 {
					 new MainFrame();
					 this.dispose();
					 
					 }
			}
			
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
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
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		


}
