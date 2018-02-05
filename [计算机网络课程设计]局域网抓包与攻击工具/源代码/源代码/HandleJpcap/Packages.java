package HandleJpcap;

public class Packages {

	public int ID;
	public String version; 					//版本
	public String priority;					//优先权
	public String header_length;		//头长度
	public String rsv_tos;					//服务类型
	public String TF;							//区分服务：最大的吞吐量
	public String RF;							//区分服务：最高的可靠性
	public String total_length;			//数据包总长度
	public String ident;						//数据包标识
	public String DF;						//Don't Fragment
	public String MF;						//More Fragment
	public String offset;					//分段偏移量
	public String TTL;						//生存时间
	public String protocol;				//上层协议类型
	public String srcIP;						//源IP地址
	public String dstIP;						//目的IP地址
	public String srcMAC;						//源MAC地址
	public String dstMAC;						//目的MAC地址
	public String srcHost;						//源主机名
	public String dstHost;						//目的主机名
	public String srcPort;						//源端口号
	public String dstPort;						//目的端口号
	public String checksum;					//校验和
	public String ICMP_code;				//ICMP 报文代码
	public String ICMP_type;				//ICMP 报文类型
	public String info="";							//包内容
	
	public Packages(String version,String priority,String header_length,String rsv_tos,
								String TF,String RF,String total_length,String ident,String DF,String MF,
								String offset,String TTL,String protocol,String srcMAC,String dstMAC,
								String srcIP,String dstIP,String srcHost,String dstHost,String srcPort,
								String dstPort,String checksum,String ICMP_code,String ICMP_type,String info) {
			
		this.version = version;
		this.priority = priority;
		this.header_length = header_length;
		this.rsv_tos = rsv_tos;
		this.TF = TF;
		this.RF = RF;
		this.total_length = total_length;
		this.ident = ident;
		this.DF = DF;
		this.MF = MF;
		this.offset = offset;
		this.TTL = TTL;
		this.protocol = protocol;
		this.srcMAC = srcMAC;
		this.dstMAC = dstMAC;
		this.srcIP = srcIP;
		this.dstIP = dstIP;
		this.srcHost = srcHost;
		this.dstHost = dstHost;
		this.srcPort = srcPort;
		this.dstPort = dstPort;
		this.checksum = checksum;
		this.ICMP_code = ICMP_code;
		this.ICMP_type = ICMP_type;
		this.info = info;

		
		
	}
	
	
	public void steID(int id) {
		ID = id;
	}

	
	
	
	
	
	
	
	
}
