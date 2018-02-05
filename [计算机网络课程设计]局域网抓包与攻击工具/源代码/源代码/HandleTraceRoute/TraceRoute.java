package HandleTraceRoute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class TraceRoute {

public static ArrayList<String> parse_traceroute()throws Exception{

	 ArrayList<String> arrayList = new ArrayList<String>();
	
	String fileName1="Traceroute.txt";

	
	BufferedReader br = new BufferedReader(new FileReader(fileName1));
	String line;
	while ((line = br.readLine()) != null) {
		if(line.startsWith("traceroute"))continue;
		String ip = null;
		try {//切割出访问的站点名称
			ip = line.split("\\(")[1].split("\\)")[0];
			
		} catch (Exception e) {//如果为＊，说明没有回应，站点不可见
			ip = "No Answer";
		}
		arrayList.add(ip);		
	}
	br.close();

	return arrayList;

}



}
