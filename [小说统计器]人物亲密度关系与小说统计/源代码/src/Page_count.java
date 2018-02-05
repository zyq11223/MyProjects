import java.util.HashMap;
import java.util.Set;

 public class Page_count{
	 
	 int first;
	 int last;
 
	
	 //统计第一次出现的位置
	 int search1(String str)throws Exception{

		   
		  
		  String text = new File_open().file_in();
		 
		  first = text.indexOf(str,0);
		  return first;
				 
	 }
	//统计最后一次出现的位置
	 int search2(String str)throws Exception{
		   
		  
		  String text = new File_open().file_in();
		 
		 
		  int location=0;
		 for(int i=0;i<text.length()-str.length();i++)
		 {
			 if(text.substring(i, i+str.length()).equals(str))
				 location = i;
		 }
		 last = location;
		
		 return last;
		 
	 }
	 
	 
	//哈希图统计每个人物第一次和最后一次出现的页数,直接调用即可
	 String[] page_fun()throws Exception{
		 String[] nam2 = new String[10];
		 nam2[0]="史强";
		 nam2[1]="章北海";
		 nam2[2]="丁仪";
		 nam2[3]="庄颜";
		 nam2[4]="东方延绪";
		 nam2[5]="泰勒";
		 nam2[6]="雷迪亚兹";
		 nam2[7]="希恩斯";
		 nam2[8]="惠子";
		 nam2[9]="罗辑";
		 
		 HashMap<String, Integer> first_location = new HashMap<String,Integer>();
		 HashMap<String, Integer> last_location = new HashMap<String,Integer>();
		 HashMap<String, Integer> location = new HashMap<String,Integer>();
		 String[] string = new String[10];
		 int k =0;
		 for(String str:nam2){
			 first_location.put(str, search1(str));
		 last_location.put(str, search2(str));
		 location.put(str, last_location.get(str)/1000-first_location.get(str)/1000);
		 }
		 
		 HashMap<String, Integer> location2 = new Sort().sort(location);
		 Set<String> set = location2.keySet();
		 	for(String str:set)
			 string[k++]="   "+str+"第一次出现在第"+first_location.get(str)/1000+"页 ,最后一次出现在第"+last_location.get(str)/1000+"页 ,篇幅跨度为"+location2.get(str)+"页";

		 

		 
	 return string;
	 
	 
	 }
 }
 
 