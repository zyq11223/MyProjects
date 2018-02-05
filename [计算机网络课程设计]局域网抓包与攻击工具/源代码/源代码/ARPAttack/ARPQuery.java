package ARPAttack;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.net.InetAddress;
import java.nio.Buffer;
import java.util.ArrayList;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;

public class ARPQuery {	
	public static ArrayList<String> ARPQuery() throws Exception {
		
		ArrayList<String> IPList = new ArrayList<String>();
		PrintStream ps = new PrintStream(new FileOutputStream("ARPList.txt", false));
		Runtime rt = Runtime.getRuntime();
		Process pro = rt.exec("arp -a ");
		BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String line;
		while ((line = buf.readLine()) != null) {
			ps.println(line);
		}

		BufferedReader br = new BufferedReader(new FileReader("ARPList.txt"));
		String result;
		while ((result = br.readLine()) != null) {
			
			try {
			IPList.add(result.split("\\(")[1].split("\\)")[0]+"#"+result.split("at ")[1].split(" on")[0]);
			}catch (Exception e) {
				continue;
			}

		}
		br.close();
		ps.close();

		return IPList;

	}
	
	
	
	
	
	public static void ARPRequest(String ip) throws Exception{
		
		Runtime rt = Runtime.getRuntime();
		Process pro = rt.exec("Ping -c " + 1 + " " + ip);
		BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String line = buf.readLine();
		buf.close();
		
	}
	
	
	
	
}
