package HandleJpcap;

import java.util.ArrayList;

public class AllPackages {

	public static ArrayList<Packages>  allpackages = new ArrayList<Packages>();
	public static int tag = 1;
	
	public static void Insert(Packages p) {
			allpackages.add(p);	
			p.steID(tag);
			tag++;
	}
	
	public static void RemoveAll() {

		for(int i=allpackages.size()-1;i>=0;i--)
		allpackages.remove(i);//循环清空
		
		tag = 1;//指针重置
	}
	
	
}
