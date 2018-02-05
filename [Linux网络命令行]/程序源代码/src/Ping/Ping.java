package Ping;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.nio.Buffer;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;



public class Ping {
	static JSONObject global1 = new JSONObject();
	static JSONObject global2 = new JSONObject();
	
	public static void run_ping(String hostnames, int num_packets) throws Exception {
		
		double[] RTT = new double[num_packets];
		int index = 0;
		PrintStream ps = new PrintStream(new FileOutputStream("Ping.txt", true));
		PrintStream ps2 = new PrintStream(new FileOutputStream("tem.txt", false));
		Runtime rt = Runtime.getRuntime();
		Process pro = rt.exec("Ping -c " + num_packets + " " + hostnames);
		BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String line;
		while ((line = buf.readLine()) != null) {
			ps.println(line);
			ps2.println(line);
		}

		BufferedReader br = new BufferedReader(new FileReader("tem.txt"));
		String drop_rate = null;
		String max_rtt = null;
		String median_rtt = null;
		String next = null;
		String nextnext = null;
		String[] allstring = new String[num_packets+4];
		String result = br.readLine();
		while ((result = br.readLine()) != null) {

			if (index < num_packets) {
				if (result.split("time=").length < 2)
				{
					allstring[index] = result;
					RTT[index++] = -1;
				}
					
				else {
					allstring[index] = result;
					String Rtt = result.split("time=")[1].split(" ms")[0];
					RTT[index++] = Double.parseDouble(Rtt);
				}
			} else {
				allstring[index] = result;
				index++;
			}

		}
		
		for(int index2 = num_packets+3;index2>=0;index2--)
		{
			if(allstring[index2]!=null)
			{
				next = allstring[index2];
				nextnext = allstring[index2-1];
				break;
			}
		}
		br.close();
		ps.close();
		ps2.close();
		try{
			drop_rate = nextnext.split("received, ")[1].split(" packet loss")[0];
			String info = next.split(" = ")[1];
			max_rtt = info.split("/")[2];
			median_rtt = info.split("/")[1];
		}catch (Exception e) {
			drop_rate = "100.0%";
			max_rtt="-1";
			median_rtt = "-1";
		}
		
	
		
		JSONArray jsonArray = JSONArray.fromObject(RTT);
		JSONObject jo1 = new JSONObject();
		jo1.put(hostnames, jsonArray);
		global1.put(hostnames, jsonArray);
		PrintStream ps3 = new PrintStream(new FileOutputStream("Ping_original.txt", true));
		ps3.println(jo1);
		ps3.close();

		if (drop_rate == null || drop_rate.equals("100.0%")) {
			drop_rate = "100.0%";
			max_rtt = "-1.0";
			median_rtt = "-1.0";
		}

		String str = "{drop_rate:" + drop_rate + ",max_rtt:" + max_rtt + ",median_rtt:" + median_rtt + "}" ;  // 一个未转化的字符串		 
		JSONObject Statistics = JSONObject.fromObject(str ); // 首先把字符串转成 JSONArray 对象
		global2.put(hostnames, str);
		JSONObject jo2 = new JSONObject();
		jo2.put(hostnames, str);
		PrintStream ps4 = new PrintStream(new FileOutputStream("Ping_statistics.txt", true));
		ps4.println(jo2);
		ps4.close();
	}


	
	public static void main(String[] args) throws Exception {

		BufferedReader bReader = new BufferedReader(new FileReader("Website.txt"));
		String string;
		while((string=bReader.readLine())!=null)
		{
			Ping.run_ping(string, 500);
		}
		
		PrintStream pStream1 = new PrintStream(new FileOutputStream("Ping_original.json",false));
		PrintStream pStream2 = new PrintStream(new FileOutputStream("Ping_statistics.json",false));
		pStream1.println(global1);
		pStream2.print(global2);

	

		

		
		
		
	
	}
}
