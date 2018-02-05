package HandlePing;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

import org.jfree.chart.JFreeChart;

import JFreeChart.Draw_RTT;



public class Ping {

	String drop_rate = null;
	String max_rtt = null;
	String median_rtt = null;
	String min_rtt = null;
	
	public  ArrayList<Double>  run_ping(int num_packets) throws Exception {
		
		ArrayList<Double> rtt = new ArrayList<Double>();
		int index = 0;
		BufferedReader br = new BufferedReader(new FileReader("Ping.txt"));

		String next = null;
		String nextnext = null;
		ArrayList<String> allstring = new ArrayList<String>();
		String result = br.readLine();
		while ((result = br.readLine()) != null) {

			if (index < num_packets) {
				if (result.split("time=").length < 2)//RTT超时
				{
					allstring.add(result);
					rtt.add(-1.00);
					index++;
				}
					
				else {//摘取每个字符串里的RTT
					allstring.add(result);
					String Rtt = result.split("time=")[1].split(" ms")[0];
					rtt.add(Double.parseDouble(Rtt));
					index++;
				}
			} else {
				allstring.add(result);
			}

		}
		
		//找到返回的round-trip min/avg/max/stddev和丢包率
		for(int index2 = allstring.size()-1;index2>=0;index2--)
		{
			if(allstring.get(index2)!=null)
			{
				next = allstring.get(index2);
				nextnext =allstring.get(index2-1);
				break;
			}
		}

		
		br.close();
		try{
			drop_rate = nextnext.split("received, ")[1].split(" packet loss")[0];//丢包率
			String info = next.split(" = ")[1];
			max_rtt = info.split("/")[2];//最大RTT
			median_rtt = info.split("/")[1];//均值RTT
			min_rtt = info.split("/")[0];//最小RTT
		}catch (Exception e) {
			drop_rate = "100.0%";
			max_rtt="-1";
			median_rtt = "-1";
			min_rtt = "-1.0";
		}
		

		if (drop_rate == null || drop_rate.equals("100.0%")) {
			drop_rate = "100.0%";
			max_rtt = "-1.0";
			median_rtt = "-1.0";
			min_rtt = "-1.0";
		}
		
		
		
		return rtt;

		

	}


	

}
