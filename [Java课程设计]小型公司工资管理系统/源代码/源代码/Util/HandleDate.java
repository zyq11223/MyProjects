package Util;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class HandleDate {
	public static DefaultPieDataset Countstatistic(int kind) {
		DefaultPieDataset pd = new DefaultPieDataset(); // 建立一个默认的饼图
		String option1,option2,option3,option4,option5;
		if (kind==1)
		{
			option1 = " where department=\"技术部\"";
			option2 = " where department=\"美工部\"";
			option3 = " where department=\"销售部\"";
			option4 = " where department=\"运营部\"";
			option5 = " where department=\"宣传部\"";
			int TP = JDBC.statisticCount(option1);
			int DP = JDBC.statisticCount(option2);
			int SP = JDBC.statisticCount(option3);
			int CP = JDBC.statisticCount(option4);
			int XP = JDBC.statisticCount(option5);
			
			pd.setValue("技术部", TP); // 输入数据
			pd.setValue("美工部", DP);
			pd.setValue("销售部", SP);
			pd.setValue("运营部", CP);
			pd.setValue("宣传部", XP);
		}
			
		else
		{
			option1 = " where kind=1";
			option2 = " where kind=2";
			option3 = " where kind=3";
			option4 = " where kind=4";
			int M = JDBC.statisticCount(option1);
			int T = JDBC.statisticCount(option2);
			int S = JDBC.statisticCount(option3);
			int SM = JDBC.statisticCount(option4);

			pd.setValue("经理", M); // 输入数据
			pd.setValue("技术人员", T);
			pd.setValue("销售人员", S);
			pd.setValue("销售经理", SM);
		}

		
		return pd;
	}
	
	public static DefaultPieDataset Sexstatistic(String dep, int kind) {
		DefaultPieDataset pd = new DefaultPieDataset(); // 建立一个默认的饼图
		String option1;
		String option2;
		if (dep.equals("0"))
			option1 = "";

		else
			option1 = " and department=\"" + dep + "\"";

		if (kind == 0)
			option2 = "";
		else
			option2 = " and kind=" + kind;
		int man = JDBC.statisticSexCount("男", option1, option2);
		int woman = JDBC.statisticSexCount("女", option1, option2);
		pd.setValue("男", man); // 输入数据
		pd.setValue("女", woman);
		return pd;
	}

	public static DefaultPieDataset Kindstatistic(String dep, int kind) {
		DefaultPieDataset pd = new DefaultPieDataset(); // 建立一个默认的饼图
		String option1;
		String option2;
		if (dep.equals("0"))
			option1 = "";

		else
			option1 = " and department=\"" + dep + "\"";

		if (kind == 0)
			option2 = "";
		else
			option2 = " and kind=" + kind;

		int manager = JDBC.statisticKindCount(1, option1, option2);
		int technologe = JDBC.statisticKindCount(2, option1, option2);
		int sellor = JDBC.statisticKindCount(3, option1, option2);
		int smanager = JDBC.statisticKindCount(4, option1, option2);
		pd.setValue("经理", manager); // 输入数据
		pd.setValue("技术人员", technologe);
		pd.setValue("销售人员", sellor);
		pd.setValue("销售经理", smanager);
		return pd;
	}

	public static DefaultCategoryDataset Agestatistic(String dep, int kind) {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图
		String option1;
		String option2;
		if (dep.equals("0"))
			option1 = "";

		else
			option1 = "department=\"" + dep + "\"";

		if (kind == 0)
			option2 = "";
		else
			option2 = "kind=" + kind;
		

		int max = JDBC.statisticMaxAge(option1,option2);
		int min = JDBC.statisticMinAge(option1,option2);
		double avg = JDBC.statisticAvgAge(option1,option2);
		pd.setValue(max,"年龄","最大年龄"); // 输入数据
		pd.setValue(avg,"年龄","平均年龄");
		pd.setValue(min,"年龄","最小年龄");

		return pd;
	}
	
	public static DefaultCategoryDataset Salarystatistic(String dep, int kind) {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图
		String option1;
		String option2;
		if (dep.equals("0"))
			option1 = "";

		else
			option1 = "department=\"" + dep + "\"";

		if (kind == 0)
			option2 = "";
		else
			option2 = "kind=" + kind;

		double max = JDBC.statisticMaxSalary(option1,option2);
		double min = JDBC.statisticMinSalary(option1,option2);
		double avg = JDBC.statisticAvgSalary(option1,option2);
		pd.setValue(max,"工资","最高工资"); // 输入数据
		pd.setValue(avg,"工资","平均工资");
		pd.setValue(min,"工资","最低工资");

		return pd;
	}

}
