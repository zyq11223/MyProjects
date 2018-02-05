package TraceRoute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import Ping.Ping;
import net.sf.json.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;

import net.sf.json.JSONObject;

public class TraceRoute {
	 static JSONObject global = new JSONObject();
	
public static void run_traceroute(String hostnames,int num_packets,String output_filename)throws Exception{
	
	String fileName = output_filename+"/Traceroute.txt";
	String fileName2 = output_filename+"/Traceroute_original.txt";
	PrintStream ps = new PrintStream(new FileOutputStream(fileName, false));
	PrintStream ps2 = new PrintStream(new FileOutputStream(fileName2, true));
	Runtime rt = Runtime.getRuntime();
	Process pro = rt.exec("traceroute -I -q " + num_packets + " " + hostnames);
	BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
	String line;
	while ((line = buf.readLine()) != null) {
		ps.println(line);
		ps2.println(line);
	}
	ps.close();
}

public static void parse_traceroute(String hostnames,String raw_traceroute_filename,String output_filename)throws Exception{

	 ArrayList<String> arrayList = new ArrayList<String>();
	
	String fileName1= raw_traceroute_filename+"/Traceroute.txt";

	
	BufferedReader br = new BufferedReader(new FileReader(fileName1));
	


	String line;
	while ((line = br.readLine()) != null) {
		if(line.startsWith("traceroute"))continue;
		String ip = null;
		try {
			ip = line.split("\\(")[1].split("\\)")[0];
			
		} catch (Exception e) {
			ip = "No Answer";
		}
				
		arrayList.add(ip);		
	
		
	}
	
	JSONArray jArray = JSONArray.fromObject(arrayList);
	System.out.println(jArray);

	global.put(hostnames, jArray);
	

}


public static void main(String[] args) throws Exception{
	System.out.println("Start");
	BufferedReader br = new BufferedReader(new FileReader("Website.txt"));
	String string;
	while((string=br.readLine())!=null)
	{
		System.out.println(string);
		TraceRoute.run_traceroute(string, 10, "/Users/apple/Desktop/Traceroute结果");
		TraceRoute.parse_traceroute(string,"/Users/apple/Desktop/Traceroute结果", "/Users/apple/Desktop/Traceroute结果");
	}
	PrintStream pStream = new PrintStream("/Users/apple/Desktop/Traceroute结果/Traceroute.json");
	pStream.print(global);
	System.out.println("End");
	
	
}
}
