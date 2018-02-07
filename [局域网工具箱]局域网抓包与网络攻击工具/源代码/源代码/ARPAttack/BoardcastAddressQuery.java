package ARPAttack;


import java.io.*;
import java.util.ArrayList;


public class BoardcastAddressQuery {	
	public static String BoardcastAddressQuery() throws Exception {
		/*--------------	获取当前局域网广播地址    --------------*/
		Runtime rt = Runtime.getRuntime();
		Process pro = rt.exec("ifconfig");
		BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
		String boardcastAddress = "";
		String line;
		while ((line = buf.readLine()) != null) {
			if(line.indexOf("broadcast ")!=-1)
				boardcastAddress = line.substring(line.indexOf("broadcast ")+10);
		}


		
	buf.close();

		return boardcastAddress;

	}
	
	
	
	
}
