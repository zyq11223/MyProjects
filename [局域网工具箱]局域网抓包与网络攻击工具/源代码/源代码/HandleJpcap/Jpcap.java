package HandleJpcap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import GrabbingPacketsFrame.StartGrabbingFrame;
import Util.Statistic;
import jpcap.*;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class Jpcap {
	
	
	
public  static void  bindNetworkInterface() {
	
	 /*--------------	绑定网络设备       --------------*/ 
	NetworkInterface[] devices = JpcapCaptor.getDeviceList();
	//获得所有网卡列表
}

public void openDevice(boolean promiscCheck,NetworkInterface device) {	
	try{

		JpcapCaptor jpcap = JpcapCaptor.openDevice(device, 65535, promiscCheck, 50);
		//需要监听的网卡
		// 每次捕获的数据包最大长度
		//过滤（Mac地址不是当前网卡的IP数据包）
		//超时时间

	}catch(IOException e)
	{
		e.printStackTrace();
	}
}

	public static Packages getPackets(JpcapCaptor jpcap) throws UnsupportedEncodingException
	{
       
		
		/*----------抓包-----------------*/
		
			
			String version=""; 					//版本
			String priority="";					//优先权
			String header_length="";		//头长度
			String rsv_tos="";					//服务类型
			String TF="";							//区分服务：最大的吞吐量
			String RF="";							//区分服务：最高的可靠性
			String total_length="";			//数据包总长度
			String ident="";						//数据包标识
			String DF="";						//Don't Fragment
			String MF="";						//More Fragment
			String offset="";					//分段偏移量
			String TTL="";						//生存时间
			String protocol="";				//上层协议类型
			String srcMAC="";						//源MAC地址
			String dstMAC="";						//目的MAC地址
			String srcIP="";						//源IP地址
			String dstIP="";						//目的IP地址
			String srcHost="";						//源主机名
			String dstHost="";						//目的主机名
			String srcPort="";						//源端口号
			String dstPort="";						//目的端口号
			String checksum="";					//校验和
			String ICMP_code="";				//ICMP 报文代码
			String ICMP_type="";				//ICMP 报文类型
			String info="";							//包内容

			
			Packet packet  = jpcap.getPacket();


			if(packet instanceof IPPacket)
			{
				IPPacket ip = (IPPacket)packet;//强转
				
				if(ip.version==4)Statistic.IPv4++;
				else if(ip.version==6)Statistic.IPv6++;
				else Statistic.OtherVersion++;
			

				switch(new Integer(ip.protocol))
				{
				case 1:{
					protocol = "ICMP";
					ICMPPacket icmp = (ICMPPacket)ip;
					checksum = String.valueOf(icmp.checksum);
					ICMP_code = String.valueOf(icmp.code);
					ICMP_type = String.valueOf(icmp.type);
					
					Statistic.ICMP++;
					
					Statistic.ICMP_avgLen+=ip.length;
					if(Statistic.ICMP_maxLen<ip.length)Statistic.ICMP_maxLen = ip.length;
					if(Statistic.ICMP_minLen>ip.length)Statistic.ICMP_minLen = ip.length;
							
					Statistic.ICMP_avgTTL+=ip.hop_limit;
					if(Statistic.ICMP_maxTTL<ip.hop_limit)Statistic.ICMP_maxTTL = ip.hop_limit;
					if(Statistic.ICMP_minTTL>ip.hop_limit)Statistic.ICMP_minTTL = ip.hop_limit;

					break;
				}
				
				case 2:protocol = "IGMP";Statistic.IGMP++;break;
				case 6:{
					protocol = "TCP";
					TCPPacket tcp = (TCPPacket)ip;
					srcPort = String.valueOf(tcp.src_port);
					dstPort = String.valueOf(tcp.dst_port);
					
					Statistic.TCP++;
					
					Statistic.TCP_avgLen+=ip.length;
					if(Statistic.TCP_maxLen<ip.length)Statistic.TCP_maxLen = ip.length;
					if(Statistic.TCP_minLen>ip.length)Statistic.TCP_minLen = ip.length;
							
					Statistic.TCP_avgTTL+=ip.hop_limit;
					if(Statistic.TCP_maxTTL<ip.hop_limit)Statistic.TCP_maxTTL = ip.hop_limit;
					if(Statistic.TCP_minTTL>ip.hop_limit)Statistic.TCP_minTTL = ip.hop_limit;

					break;
				}
				case 8:protocol = "EGP";Statistic.Others++;break;
				case 9:protocol = "IGP";Statistic.Others++;break;
				case 17:{
					protocol = "UDP";
					UDPPacket udp = (UDPPacket)ip;
					srcPort = String.valueOf(udp.src_port);
					dstPort = String.valueOf(udp.dst_port);

					
					Statistic.UDP++;
					
					Statistic.UDP_avgLen+=ip.length;
					if(Statistic.UDP_maxLen<ip.length)Statistic.UDP_maxLen = ip.length;
					if(Statistic.UDP_minLen>ip.length)Statistic.UDP_minLen = ip.length;
							
					Statistic.UDP_avgTTL+=ip.hop_limit;
					if(Statistic.UDP_maxTTL<ip.hop_limit)Statistic.UDP_maxTTL = ip.hop_limit;
					if(Statistic.UDP_minTTL>ip.hop_limit)Statistic.UDP_minTTL = ip.hop_limit;
					break;
				}
				case 41:protocol = "IPv6";Statistic.Others++;break;
				case 58:{
					protocol = "IPv6-ICMP";
					
					Statistic.ICMP++;
					
					Statistic.ICMP_avgLen+=ip.length;
					if(Statistic.ICMP_maxLen<ip.length)Statistic.ICMP_maxLen = ip.length;
					if(Statistic.ICMP_minLen>ip.length)Statistic.ICMP_minLen = ip.length;
							
					Statistic.ICMP_avgTTL+=ip.hop_limit;
					if(Statistic.ICMP_maxTTL<ip.hop_limit)Statistic.ICMP_maxTTL = ip.hop_limit;
					if(Statistic.ICMP_minTTL>ip.hop_limit)Statistic.ICMP_minTTL = ip.hop_limit;
					
					break;
				}
				case 89:protocol = "OSPF";Statistic.Others++;break;
				default : protocol = String.valueOf(ip.protocol);Statistic.Others++;break;
				}
				
				version = "IPv"+ip.version;
				priority = String.valueOf(ip.priority);
				header_length =  String.valueOf(ip.header.length);
				rsv_tos = String.valueOf(ip.rsv_tos);
				TF = String.valueOf(ip.t_flag);
				RF = String.valueOf(ip.r_flag);
				total_length = String.valueOf(ip.length);
				ident = String.valueOf(ip.ident);
				DF = String.valueOf(ip.dont_frag);
				MF = String.valueOf(ip.more_frag);
				offset = String.valueOf(ip.offset);
				TTL = String.valueOf(ip.hop_limit);
				protocol = String.valueOf(protocol);
				EthernetPacket ethernetPacket = (EthernetPacket)packet.datalink;
				srcMAC = ethernetPacket.getSourceAddress();
				dstMAC = ethernetPacket.getDestinationAddress();
				srcIP = ip.src_ip.getHostAddress();
				dstIP = ip.dst_ip.getHostAddress();
				srcHost = ip.src_ip.getHostName();
				dstHost = ip.dst_ip.getHostName();
				for(int i=0;i<ip.data.length;i++)
				{
					info+=(char)ip.data[i];
				}
				
				
				
				Packages p = new Packages(version, priority, header_length, rsv_tos, TF, RF, total_length, ident, DF, MF, offset, TTL, protocol, srcMAC, dstMAC,srcIP, dstIP, srcHost, dstHost, srcPort, dstPort, checksum, ICMP_code, ICMP_type, info); 
				AllPackages.Insert(p);
				return p;


			}
			
			else if(packet instanceof ARPPacket)
			{
				ARPPacket arp = (ARPPacket)packet;//强转
				
				Statistic.ARP++;
				

				
				
				version = "ARP";

				header_length =  String.valueOf(arp.header.length);
				
				short hardtype = arp.hardtype;
				if(hardtype==1) TF = "以太网";//硬件类型
				else if(hardtype==6)TF = "令牌环";
				else TF = "帧中继";

				if(arp.prototype==2048)RF = "IP";//协议类型：
				else RF =String.valueOf(arp.prototype);
				
				
				DF = String.valueOf(arp.hlen);//硬件地址长度
				MF = String.valueOf(arp.plen);//协议地址长度
				ident = " ？";
				rsv_tos = String.valueOf(arp.operation);//操作字段
				
				total_length = String.valueOf(arp.len);

				protocol = "ARP";

				srcMAC = ""+arp.getSenderHardwareAddress();
				dstMAC = ""+arp.getTargetHardwareAddress();
				String srcIP0 = ""+arp.getSenderProtocolAddress();
				String dstIP0 = ""+arp.getTargetProtocolAddress();
				srcIP = srcIP0.split("/")[1];
				dstIP = dstIP0.split("/")[1];
				for(int i=0;i<arp.data.length;i++)
				{
					info+=(char)arp.data[i];
				}
				
				
				
				Packages p = new Packages(version, priority, header_length, rsv_tos, TF, RF, total_length, ident, DF, MF, offset, TTL, protocol, srcMAC, dstMAC,srcIP, dstIP, srcHost, dstHost, srcPort, dstPort, checksum, ICMP_code, ICMP_type, info); 
				AllPackages.Insert(p);
				return p;


			}
			
			else {
				if(packet!=null)
				System.err.println("Unknow"+packet.toString());
				
				
					return null;
			}
		

		
		
		}
		
	


	
	
}
