package Util;

public class Statistic {

	// 不同协议总数
	public static int IPv4 = 0;
	public static int IPv6 = 0;
	public static int OtherVersion = 0;

	// 不同类型数据包总数
	public static int TCP = 0;
	public static int UDP = 0;
	public static int ICMP = 0;
	public static int IGMP = 0;
	public static int ARP = 0;
	public static int Others = 0;

	// 数据包长度最大值、最小值、平均值
	public static int TCP_maxLen = 0;
	public static int UDP_maxLen = 0;
	public static int ICMP_maxLen = 0;

	public static int TCP_minLen = 99999;
	public static int UDP_minLen = 99999;
	public static int ICMP_minLen = 99999;

	public static double TCP_avgLen = 0;
	public static double UDP_avgLen = 0;
	public static double ICMP_avgLen = 0;

	// TTL最大值、最小值、平均值
	public static int TCP_maxTTL = 0;
	public static int UDP_maxTTL = 0;
	public static int ICMP_maxTTL = 0;

	public static int TCP_minTTL = 99999;
	public static int UDP_minTTL = 99999;
	public static int ICMP_minTTL = 99999;

	public static double TCP_avgTTL = 0;
	public static double UDP_avgTTL = 0;
	public static double ICMP_avgTTL = 0;

	public static void ClearAll() {

		// 不同协议总数
		IPv4 = 0;
		IPv6 = 0;
		OtherVersion = 0;

		// 不同类型数据包总数
		TCP = 0;
		UDP = 0;
		ICMP = 0;
		IGMP = 0;
		ARP = 0;
		Others = 0;

		// 数据包长度最大值、最小值、平均值
		TCP_maxLen = 0;
		UDP_maxLen = 0;
		ICMP_maxLen = 0;

		TCP_minLen = 99999;
		UDP_minLen = 99999;
		ICMP_minLen = 99999;

		TCP_avgLen = 0;
		UDP_avgLen = 0;
		ICMP_avgLen = 0;

		// TTL最大值、最小值、平均值
		TCP_maxTTL = 0;
		UDP_maxTTL = 0;
		ICMP_maxTTL = 0;

		TCP_minTTL = 99999;
		UDP_minTTL = 99999;
		ICMP_minTTL = 99999;

		TCP_avgTTL = 0;
		UDP_avgTTL = 0;
		ICMP_avgTTL = 0;

	}

}
