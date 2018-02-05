package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import Util.JDBC;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;

public class QueryFrame extends JFrame implements ActionListener,WindowListener,FocusListener{

	
			int flag = 1;
	
			// 界面有关变量
			JPanel jpl1 = new JPanel();
			JPanel jpl2 = new JPanel();
			QueryByOthers table;

			
			
			String info = "请输入员工编号：";
			JComboBox jcb = new JComboBox();
			JTextField jtf = new JTextField();
			JButton jbt = new JButton("查询");
	
	
			public QueryFrame() {

				this.setTitle("按条件查询");
				this.setSize(1040, 476);
				getContentPane().setLayout(new BorderLayout(0, 0));
				getContentPane().add(jpl1, BorderLayout.NORTH);
							jpl1.setLayout(new GridLayout(0, 3, 50, 30));
							jpl1.add(jcb);
							jcb.addItem("按员工编号查找");
							jcb.addItem("按员工姓名查找");
							jcb.addItem("按员工性别查找");
							jcb.addItem("按员工部门查找");
							jcb.addItem("按员工级别查找");
							
							jcb.addActionListener(this);
							jpl1.add(jtf);
							jtf.addFocusListener(this);
							jtf.setText(info);
							jtf.setForeground(Color.gray);
							jpl1.add(jbt);
							
														jbt.addActionListener(this);
							getContentPane().add(jpl2, BorderLayout.CENTER);
							jpl2.setLayout(new BorderLayout(0, 0));
							String result = JDBC.searchAll();
							if(result==null||result.equals(null))
							{
								JOptionPane.showMessageDialog(this, "未查询到任何信息！");
								return;
							}else if(result.equals("Fail"))
							{
								JOptionPane.showMessageDialog(this, "查询失败");
								return;
							}else {
								table = new QueryByOthers(result);
								table.setOpaque(true);
								jpl2.add(table);

								
							}
							this.setLocation(200, 130);
							this.setVisible(true);	
				
				this.addWindowListener(this);
			
			}
	

	
	
			@Override
			public void actionPerformed(ActionEvent e) {
				

				
				if(e.getSource()==jcb) {
					Object seleted = jcb.getSelectedItem();
					if(seleted.equals("按员工编号查找")) {
						info =  "请输入员工编号：";
						jtf.setText(info);
						jtf.setForeground(Color.gray);
						flag=1;
					}else if(seleted.equals("按员工姓名查找")){
						info =  "请输入员工姓名：";
						jtf.setText(info);
						jtf.setForeground(Color.gray);
						flag=2;
					}else if(seleted.equals("按员工性别查找")){
						info =  "请输入员工性别：";
						jtf.setText(info);
						jtf.setForeground(Color.gray);
						flag=3;
					}else if(seleted.equals("按员工部门查找")){
						info =  "请输入员工部门：";
						jtf.setText(info);
						jtf.setForeground(Color.gray);
						flag=4;
					}else if(seleted.equals("按员工级别查找")){
						info =  "请输入员工级别：";
						jtf.setText(info);
						jtf.setForeground(Color.gray);
						flag=5;
					}
					
					
					
					
				}
				
				if(e.getSource()==jbt)
				{
					if(jtf.getText().equals(info))
					{
						JOptionPane.showMessageDialog(this, "请输入查询条件");
						return;
					}
				
				if(flag==1)
				{										
					String result = JDBC.searchByID(jtf.getText());
					if(result==null||result.equals(null))
					{
						JOptionPane.showMessageDialog(this, "未查询到相关信息！");
						return;
					}else if(result.equals("Fail"))
					{
						JOptionPane.showMessageDialog(this, "查询失败");
						return;
					}else {
						table.updaeALL(result);
						
					}
				}else if(flag==2){
					String result = JDBC.searchByOthers("name", jtf.getText());
					if(result==null||result.equals(null))
					{
						JOptionPane.showMessageDialog(this, "未查询到相关信息！");
						return;
					}else if(result.equals("Fail"))
					{
						JOptionPane.showMessageDialog(this, "查询失败");
						return;
					}else {
						table.updaeALL(result);
					}
				}else if(flag==3){
					String result = JDBC.searchByOthers("sex", jtf.getText());
					if(result==null||result.equals(null))
					{
						JOptionPane.showMessageDialog(this, "未查询到相关信息！");
						return;
					}else if(result.equals("Fail"))
					{
						JOptionPane.showMessageDialog(this, "查询失败");
						return;
					}else {
						table.updaeALL(result);
					}
				}else if(flag==4){
					String result = JDBC.searchByOthers("department", jtf.getText());
					if(result==null||result.equals(null))
					{
						JOptionPane.showMessageDialog(this, "未查询到相关信息！");
						return;
					}else if(result.equals("Fail"))
					{
						JOptionPane.showMessageDialog(this, "查询失败");
						return;
					}else {
						table.updaeALL(result);
					}
				}else if(flag==5){
					int kind;
					if( jtf.getText().equals("经理"))kind = 1;
					else if( jtf.getText().equals("技术人员"))kind = 2;
					else if( jtf.getText().equals("销售人员"))kind = 3;
					else if( jtf.getText().equals("销售经理"))kind = 4;
					else {
						JOptionPane.showMessageDialog(this, "请输入正确内容！");
						return;
					}
					String result = JDBC.searchByOthers("kind", String.valueOf(kind));
					if(result==null||result.equals(null))
					{
						JOptionPane.showMessageDialog(this, "未查询到相关信息！");
						return;
					}else if(result.equals("Fail"))
					{
						JOptionPane.showMessageDialog(this, "查询失败");
						return;
					}else {
						table.updaeALL(result);
					}
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



	@Override
	public void focusGained(FocusEvent e) {
		if(jtf.getText().equals(info))
		{
			jtf.setText("");
		}
		
		jtf.setForeground(Color.black);
	}



	@Override
	public void focusLost(FocusEvent e) {
		
		
		if(jtf.getText().equals(""))
			jtf.setText(info);
		
		jtf.setForeground(Color.gray);
		
	}

	


	
	
	
}
