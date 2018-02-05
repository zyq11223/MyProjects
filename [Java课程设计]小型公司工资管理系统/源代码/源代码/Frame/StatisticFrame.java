package Frame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import JFreeChart.CategoryChart;
import JFreeChart.PieChart;
import Util.HandleDate;
import Util.JDBC;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StatisticFrame extends JFrame implements ActionListener,WindowListener{
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JTabbedPane KindTable = new JTabbedPane(JTabbedPane.LEFT);

	JPanel AgePanel = new JPanel();
	JPanel SexPanel = new JPanel();
	JPanel KindPanel = new JPanel();
	JPanel SalaryPanel = new JPanel();

	JComboBox ageDep_selected = new JComboBox();
	JComboBox ageKind_selected = new JComboBox();
	JComboBox sexDep_selected = new JComboBox();
	JComboBox sexKind_selected = new JComboBox();
	JComboBox salaryDep_selected = new JComboBox();
	JComboBox salaryKind_selected = new JComboBox();

	JButton ageButton = new JButton("统计");
	JButton sexButton = new JButton("统计");
	JButton salaryButton = new JButton("统计");

	JPanel ageChart = new JPanel();
	JPanel sexChart = new JPanel();
	JPanel salaryChart = new JPanel();

	
	JPanel ALL = new JPanel();
	 JPanel kind_ALL = new JPanel();
	 JPanel department_ALL = new JPanel();
	
	JPanel TP = new JPanel();
	JPanel TP1 = new JPanel();
	JPanel TP2 = new JPanel();
	JPanel TP3 = new JPanel();

	JPanel SP = new JPanel();
	JPanel SP1 = new JPanel();
	JPanel SP4 = new JPanel();
	JPanel SP2 = new JPanel();

	JPanel CP = new JPanel();
	JPanel CP1 = new JPanel();
	JPanel CP2 = new JPanel();
	JPanel CP3 = new JPanel();

	JPanel DP = new JPanel();
	JPanel DP1 = new JPanel();
	JPanel DP2 = new JPanel();
	JPanel DP3 = new JPanel();

	JPanel XP = new JPanel();
	JPanel XP1 = new JPanel();
	JPanel XP2 = new JPanel();
	JPanel XP3 = new JPanel();
	JPanel TP4 = new JPanel();
	JPanel SP3 = new JPanel();
	JPanel CP4 = new JPanel();
	JPanel DP4 = new JPanel();
	JPanel XP4 = new JPanel();

	
	JFreeChart departmentALLchart = PieChart.createChart("公司部门人数分布", HandleDate.Countstatistic(1));
	JFreeChart kindALLchart = PieChart.createChart("公司岗位人数分布", HandleDate.Countstatistic(2));

	JFreeChart TP1chart = PieChart.createChart("技术部男女比例", HandleDate.Sexstatistic("技术部", 0));
	JFreeChart TP2chart = PieChart.createChart("技术部成员比例", HandleDate.Kindstatistic("技术部", 0));
	JFreeChart TP3chart = CategoryChart.createChart("技术部年龄统计", HandleDate.Agestatistic("技术部", 0),Color.RED);
	JFreeChart TP4chart = CategoryChart.createChart("技术部工资统计", HandleDate.Salarystatistic("技术部", 0),Color.blue);

	JFreeChart SP1chart = PieChart.createChart("销售部男女比例", HandleDate.Sexstatistic("销售部", 0));
	JFreeChart SP2chart = PieChart.createChart("销售部成员比例", HandleDate.Kindstatistic("销售部", 0));
	JFreeChart SP3chart = CategoryChart.createChart("销售部年龄统计", HandleDate.Agestatistic("销售部", 0),Color.RED);
	JFreeChart SP4chart = CategoryChart.createChart("销售部工资统计", HandleDate.Salarystatistic("销售部", 0),Color.blue);
	
	JFreeChart CP1chart = PieChart.createChart("运营部男女比例", HandleDate.Sexstatistic("运营部", 0));
	JFreeChart CP2chart = PieChart.createChart("运营部成员比例", HandleDate.Kindstatistic("运营部", 0));
	JFreeChart CP3chart = CategoryChart.createChart("运营部年龄统计", HandleDate.Agestatistic("运营部", 0),Color.RED);
	JFreeChart CP4chart = CategoryChart.createChart("运营部工资统计", HandleDate.Salarystatistic("运营部", 0),Color.blue);
	
	JFreeChart DP1chart = PieChart.createChart("美工部男女比例", HandleDate.Sexstatistic("美工部", 0));
	JFreeChart DP2chart = PieChart.createChart("美工部成员比例", HandleDate.Kindstatistic("美工部", 0));
	JFreeChart DP3chart = CategoryChart.createChart("美工部年龄统计", HandleDate.Agestatistic("美工部", 0),Color.RED);
	JFreeChart DP4chart = CategoryChart.createChart("美工部工资统计", HandleDate.Salarystatistic("美工部", 0),Color.blue);
	
	JFreeChart XP1chart = PieChart.createChart("宣传部男女比例", HandleDate.Sexstatistic("宣传部", 0));
	JFreeChart XP2chart = PieChart.createChart("宣传部成员比例", HandleDate.Kindstatistic("宣传部", 0));
	JFreeChart XP3chart = CategoryChart.createChart("宣传部年龄统计", HandleDate.Agestatistic("宣传部", 0),Color.RED);
	JFreeChart XP4chart = CategoryChart.createChart("宣传部工资统计", HandleDate.Salarystatistic("宣传部", 0),Color.blue);
	
	JFreeChart agechart = CategoryChart.createChart("年龄统计", HandleDate.Agestatistic("0", 0),Color.RED);
	JFreeChart sexchart = PieChart.createChart("性别统计", HandleDate.Sexstatistic("0", 0));
	JFreeChart salarychart = CategoryChart.createChart("工资统计", HandleDate.Salarystatistic("0", 0),Color.blue);

	public StatisticFrame() {
		this.setSize(1000, 800);

		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		tabbedPane.addTab("部门与级别", null, KindPanel, null);
		KindPanel.setLayout(null);

		KindTable.setBounds(6, 5, 967, 721);
		KindPanel.add(KindTable);
		
		KindTable.addTab("公司", null, ALL, null);
		ALL.setLayout(new GridLayout(2, 2, 0, 0));
		
		ALL.add(department_ALL);
		department_ALL.setLayout(new BorderLayout(0, 0));
		ChartPanel departmentALLframe = new ChartPanel(departmentALLchart);
		department_ALL.add(departmentALLframe);
		
		ALL.add(kind_ALL);
		kind_ALL.setLayout(new BorderLayout(0, 0));
		ChartPanel kindALLframe = new ChartPanel(kindALLchart);
		kind_ALL.add(kindALLframe);

		KindTable.addTab("技术部", null, TP, null);
		TP.setLayout(new GridLayout(0, 2, 0, 0));
		TP.add(TP1);
		TP1.setLayout(new BorderLayout(0, 0));
		ChartPanel TP1frame = new ChartPanel(TP1chart);
		TP1.add(TP1frame);

		TP.add(TP2);
		TP2.setLayout(new BorderLayout(0, 0));
		ChartPanel TP2frame = new ChartPanel(TP2chart);
		TP2.add(TP2frame);
		TP.add(TP3);
		TP3.setLayout(new BorderLayout(0, 0));
		ChartPanel TP3frame = new ChartPanel(TP3chart);
		TP3.add(TP3frame);

		TP.add(TP4);
		TP4.setLayout(new BorderLayout(0, 0));
		ChartPanel TP4frame = new ChartPanel(TP4chart);
		TP4.add(TP4frame);
		
		KindTable.addTab("销售部", null, SP, null);
		SP.setLayout(new GridLayout(0, 2, 0, 0));
		SP.add(SP1);
		SP1.setLayout(new BorderLayout(0, 0));
		ChartPanel SP1frame = new ChartPanel(SP1chart);
		SP1.add(SP1frame);
		SP.add(SP2);
		SP2.setLayout(new BorderLayout(0, 0));
		ChartPanel SP2frame = new ChartPanel(SP2chart);
		SP2.add(SP2frame);

		SP.add(SP3);
		SP3.setLayout(new BorderLayout(0, 0));
		ChartPanel SP3frame = new ChartPanel(SP3chart);
		SP3.add(SP3frame);
		SP.add(SP4);
		SP4.setLayout(new BorderLayout(0, 0));
		ChartPanel SP4frame = new ChartPanel(SP4chart);
		SP4.add(SP4frame);


		KindTable.addTab("运营部", null, CP, null);
		CP.setLayout(new GridLayout(0, 2, 0, 0));
		CP.add(CP1);
		CP1.setLayout(new BorderLayout(0, 0));
		ChartPanel CP1frame = new ChartPanel(CP1chart);
		CP1.add(CP1frame);
		CP.add(CP2);
		CP2.setLayout(new BorderLayout(0, 0));
		ChartPanel CP2frame = new ChartPanel(CP2chart);
		CP2.add(CP2frame);
		CP.add(CP3);
		CP3.setLayout(new BorderLayout(0, 0));
		ChartPanel CP3frame = new ChartPanel(CP3chart);
		CP3.add(CP3frame);
		CP.add(CP4);
		CP4.setLayout(new BorderLayout(0, 0));
		ChartPanel CP4frame = new ChartPanel(CP4chart);
		CP4.add(CP4frame);

		KindTable.addTab("美工部", null, DP, null);
		DP.setLayout(new GridLayout(0, 2, 0, 0));
		DP.add(DP1);
		DP1.setLayout(new BorderLayout(0, 0));
		ChartPanel DP1frame = new ChartPanel(DP1chart);
		DP1.add(DP1frame);
		DP.add(DP2);
		DP2.setLayout(new BorderLayout(0, 0));
		ChartPanel DP2frame = new ChartPanel(DP2chart);
		DP2.add(DP2frame);
		DP.add(DP3);
		DP3.setLayout(new BorderLayout(0, 0));
		ChartPanel DP3frame = new ChartPanel(DP3chart);
		DP3.add(DP3frame);
		DP.add(DP4);
		DP4.setLayout(new BorderLayout(0, 0));
		ChartPanel DP4frame = new ChartPanel(DP4chart);
		DP4.add(DP4frame);

		KindTable.addTab("宣传部", null, XP, null);
		XP.setLayout(new GridLayout(0, 2, 0, 0));
		XP.add(XP1);
		XP1.setLayout(new BorderLayout(0, 0));
		ChartPanel XP1frame = new ChartPanel(XP1chart);
		XP1.add(XP1frame);
		XP.add(XP2);
		XP2.setLayout(new BorderLayout(0, 0));
		ChartPanel XP2frame = new ChartPanel(XP2chart);
		XP2.add(XP2frame);
		XP.add(XP3);
		XP3.setLayout(new BorderLayout(0, 0));
		ChartPanel XP3frame = new ChartPanel(XP3chart);
		XP3.add(XP3frame);
		XP.add(XP4);
		XP4.setLayout(new BorderLayout(0, 0));
		ChartPanel XP4frame = new ChartPanel(XP4chart);
		XP4.add(XP4frame);

		tabbedPane.addTab("年龄统计", null, AgePanel, null);
		AgePanel.setLayout(null);

		ageDep_selected.setBounds(165, 30, 206, 46);
		AgePanel.add(ageDep_selected);
		ageDep_selected.addItem("------");
		ageDep_selected.addItem("技术部");
		ageDep_selected.addItem("销售部");
		ageDep_selected.addItem("运营部");
		ageDep_selected.addItem("美工部");
		ageDep_selected.addItem("宣传部");

		JLabel ageDep = new JLabel("部门：");
		ageDep.setBounds(131, 36, 41, 32);
		AgePanel.add(ageDep);

		JLabel ageKind = new JLabel("级别：");
		ageKind.setBounds(434, 36, 41, 32);
		AgePanel.add(ageKind);

		ageKind_selected.setBounds(468, 30, 183, 46);
		AgePanel.add(ageKind_selected);
		ageKind_selected.addItem("------");
		ageKind_selected.addItem("经理");
		ageKind_selected.addItem("技术人员");
		ageKind_selected.addItem("销售人员");
		ageKind_selected.addItem("销售经理");

		ageButton.setBounds(710, 39, 69, 29);
		AgePanel.add(ageButton);

		ageChart.setBounds(63, 102, 822, 522);
		AgePanel.add(ageChart);
		ChartPanel ageframe = new ChartPanel(agechart);
		ageChart.add(ageframe);

		SexPanel.setLayout(null);
		tabbedPane.addTab("性别统计", null, SexPanel, null);

		sexDep_selected.setBounds(165, 30, 206, 46);
		SexPanel.add(sexDep_selected);
		sexDep_selected.addItem("------");
		sexDep_selected.addItem("技术部");
		sexDep_selected.addItem("销售部");
		sexDep_selected.addItem("运营部");
		sexDep_selected.addItem("美工部");
		sexDep_selected.addItem("宣传部");

		JLabel sexDep = new JLabel("部门：");
		sexDep.setBounds(131, 36, 41, 32);
		SexPanel.add(sexDep);

		JLabel sexKind = new JLabel("级别：");
		sexKind.setBounds(434, 36, 41, 32);
		SexPanel.add(sexKind);

		sexKind_selected.setBounds(468, 30, 183, 46);
		SexPanel.add(sexKind_selected);
		sexKind_selected.addItem("------");
		sexKind_selected.addItem("经理");
		sexKind_selected.addItem("技术人员");
		sexKind_selected.addItem("销售人员");
		sexKind_selected.addItem("销售经理");

		sexButton.setBounds(710, 39, 69, 29);
		SexPanel.add(sexButton);

		sexChart.setBounds(63, 102, 822, 522);
		SexPanel.add(sexChart);
	
		ChartPanel sexframe = new ChartPanel(sexchart);
		sexChart.add(sexframe);

		tabbedPane.addTab("工资统计", null, SalaryPanel, null);
		SalaryPanel.setLayout(null);

		salaryDep_selected.setBounds(145, 46, 206, 46);
		SalaryPanel.add(salaryDep_selected);
		salaryDep_selected.addItem("------");
		salaryDep_selected.addItem("技术部");
		salaryDep_selected.addItem("销售部");
		salaryDep_selected.addItem("运营部");
		salaryDep_selected.addItem("美工部");
		salaryDep_selected.addItem("宣传部");

		JLabel salaryDepth = new JLabel("部门：");
		salaryDepth.setBounds(110, 52, 41, 32);
		SalaryPanel.add(salaryDepth);

		JLabel salaryKind = new JLabel("级别：");
		salaryKind.setBounds(427, 52, 41, 32);
		SalaryPanel.add(salaryKind);

		salaryKind_selected.setBounds(463, 46, 183, 46);
		SalaryPanel.add(salaryKind_selected);
		salaryKind_selected.addItem("------");
		salaryKind_selected.addItem("经理");
		salaryKind_selected.addItem("技术人员");
		salaryKind_selected.addItem("销售人员");
		salaryKind_selected.addItem("销售经理");

		salaryButton.setBounds(698, 55, 69, 29);
		SalaryPanel.add(salaryButton);

		salaryChart.setBounds(30, 110, 836, 522);
		SalaryPanel.add(salaryChart);
	
		ChartPanel salaryframe = new ChartPanel(salarychart);
		salaryChart.add(salaryframe);
		
		this.setLocation(200, 130);
		this.setVisible(true);

		ageButton.addActionListener(this);
		sexButton.addActionListener(this);
		salaryButton.addActionListener(this);
		this.setTitle("统计结果");
		this.addWindowListener(this);

	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ageButton)
		{
			String option1 = ageDep_selected.getSelectedItem().toString();
			String option2 = ageKind_selected.getSelectedItem().toString();
			int kind;
			if(option1.equals("------"))
				option1 = "0";
			
			
			 if(option2.equals("------"))
				kind = 0;	
			else if(option2.equals("经理"))
				kind = 1;
			else if(option2.equals("技术人员"))
				kind = 2;
				else if(option2.equals("销售人员"))
					kind = 3;
					else 
						kind = 4;

			
			CategoryPlot plot = (CategoryPlot)agechart.getPlot();
			plot.setDataset(HandleDate.Agestatistic(option1, kind));

		}
		if(e.getSource()==sexButton)
		{
			String option1 = sexDep_selected.getSelectedItem().toString();
			String option2 = sexKind_selected.getSelectedItem().toString();
			int kind;
			if(option1.equals("------"))
				option1 = "0";
			
			
			 if(option2.equals("------"))
				kind = 0;	
			else if(option2.equals("经理"))
				kind = 1;
			else if(option2.equals("技术人员"))
				kind = 2;
				else if(option2.equals("销售人员"))
					kind = 3;
					else 
						kind = 4;

			
			 PiePlot3D plot = (PiePlot3D)sexchart.getPlot();
			plot.setDataset(HandleDate.Sexstatistic(option1, kind));


		}
		if(e.getSource()==salaryButton)
		{
			String option1 = salaryDep_selected.getSelectedItem().toString();
			String option2 = salaryKind_selected.getSelectedItem().toString();
			int kind;
			if(option1.equals("------"))
				option1 = "0";
			
			
			 if(option2.equals("------"))
				kind = 0;	
			else if(option2.equals("经理"))
				kind = 1;
			else if(option2.equals("技术人员"))
				kind = 2;
				else if(option2.equals("销售人员"))
					kind = 3;
					else 
						kind = 4;

			
			CategoryPlot plot = (CategoryPlot)salarychart.getPlot();
			plot.setDataset(HandleDate.Salarystatistic(option1, kind));

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
