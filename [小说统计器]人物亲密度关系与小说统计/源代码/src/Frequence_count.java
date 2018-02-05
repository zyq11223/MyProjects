import java.util.*;

public class Frequence_count {

	//每个名字出现次数的统计
	int compare(String word,String str)
	{
		
		int start = 0;
		int count = 0;
		while(word.indexOf(str,start)>=0 && start<word.length())
		{
			count++;
			start = str.length() +word.indexOf(str,start);
		}
	
		
		return count;
		
	}
	
//哈希图统计字符串出现的次数
	LinkedHashMap<String, Integer> frequence_fun() throws Exception{

	HashMap<String, Integer> frequence = new HashMap<String, Integer>();
	
	String text = new File_open().file_in();
	 String[] name = new String[10];
	 name[0]="史强";
	 name[1]="章北海";
	 name[2]="丁仪";
	 name[3]="庄颜";
	 name[4]="东方延绪";
	 name[5]="泰勒";
	 name[6]="雷迪亚兹";
	 name[7]="希恩斯";
	 name[8]="惠子";
	 name[9]="罗辑";
	for(int i =0;i<10;i++)
	{
		
		frequence.put(name[i],0);
		frequence.put(name[i], compare(text, name[i]));	
		
		
	}
	
	
	
	
	
	return new Sort().sort(frequence);
}

}
 