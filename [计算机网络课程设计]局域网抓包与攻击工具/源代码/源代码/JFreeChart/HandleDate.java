package JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Util.Statistic;

public class HandleDate {
	public static DefaultPieDataset countVersion() {
		DefaultPieDataset pd = new DefaultPieDataset(); // 建立一个默认的饼图

			pd.setValue("IPv4",Statistic.IPv4); // 输入数据
			pd.setValue("IPv6", Statistic.IPv6);
			pd.setValue("其他", Statistic.OtherVersion);
	
	
		
		return pd;
	}
	
	public static DefaultPieDataset countProtocol() {
		DefaultPieDataset pd = new DefaultPieDataset(); // 建立一个默认的饼图

			pd.setValue("TCP", Statistic.TCP); // 输入数据
			pd.setValue("UDP", Statistic.UDP);
			pd.setValue("ICMP", Statistic.ICMP);
			pd.setValue("ARP",Statistic.ARP);
			pd.setValue("IGMP",Statistic.IGMP);
			pd.setValue("其他", Statistic.Others);
		

		
		return pd;
	}
	

	public static DefaultCategoryDataset TCPlen() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.TCP_maxLen,"数据包大小","最大数据包"); // 输入数据
		pd.setValue(Statistic.TCP_avgLen/Statistic.TCP,"数据包大小","平均大小");
		pd.setValue(Statistic.TCP_minLen,"数据包大小","最小数据包");

		return pd;
	}
	
	public static DefaultCategoryDataset TCPTTL() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.TCP_maxTTL,"生存期长短","最长生存期"); // 输入数据
		pd.setValue(Statistic.TCP_avgTTL/Statistic.TCP,"生存期长短","平均生存期");
		pd.setValue(Statistic.TCP_minTTL,"生存期长短","最短生存期");

		return pd;
	}
	
	public static DefaultCategoryDataset UDPlen() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.UDP_maxLen,"数据包大小","最大数据包"); // 输入数据
		pd.setValue(Statistic.UDP_avgLen/Statistic.UDP,"数据包大小","平均大小");
		pd.setValue(Statistic.UDP_minLen,"数据包大小","最小数据包");

		return pd;
	}
	
	public static DefaultCategoryDataset UDPTTL() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.UDP_maxTTL,"生存期长短","最长生存期"); // 输入数据
		pd.setValue(Statistic.UDP_avgTTL/Statistic.UDP,"生存期长短","平均生存期");
		pd.setValue(Statistic.UDP_minTTL,"生存期长短","最短生存期");

		return pd;
	}
	
	public static DefaultCategoryDataset ICMPlen() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.ICMP_maxLen,"数据包大小","最大数据包"); // 输入数据
		pd.setValue(Statistic.ICMP_avgLen/Statistic.ICMP,"数据包大小","平均大小");
		pd.setValue(Statistic.ICMP_minLen,"数据包大小","最小数据包");

		return pd;
	}
	
	public static DefaultCategoryDataset ICMPTTL() {
		DefaultCategoryDataset pd = new DefaultCategoryDataset(); // 建立一个默认的饼图

		pd.setValue(Statistic.ICMP_maxTTL,"生存期长短","最长生存期"); // 输入数据
		pd.setValue(Statistic.ICMP_avgTTL/Statistic.ICMP,"生存期长短","平均生存期");
		pd.setValue(Statistic.ICMP_minTTL,"生存期长短","最短生存期");

		return pd;
	}

	

	
	
	
	
}
