import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;


public class Close_count {
	 
 
	 Object compare(String word,String str)
		{
			
			ArrayList<Integer> arry= new ArrayList<Integer>();
			for(int i=0;i<word.length()-str.length();i++)
			{
				String str2 = word.substring(i, i+str.length());
				if(str2.equals(str)) arry.add(i);
			}
		
			
			return arry;
			
		}
	 
	 int close_count  (String nam1,String nam2)throws Exception
	 {
		 
		 String word = new File_open().file_in();
		 
		 ArrayList<Integer> arry1 = (ArrayList<Integer>)compare(word,nam1);
		 ArrayList<Integer> arry2 = (ArrayList<Integer>)compare(word,nam2);
		 int lenth1 = arry1.size();
		 int lenth2 = arry2.size();
		 
		 int sorce=0;
		 
		 for(int i=0;i<lenth1;i++)
			 for(int j=0;j<lenth2;j++)
			 {
				 int c = arry1.get(i)-arry2.get(j);
				 int cc = Math.abs(c);
				 if(cc<=20){sorce+=5;}
				 else if(cc<=50){sorce+=3;}
				 else if(cc<=100){sorce+=1;}
			 }

		 return sorce;
		 
		 
	 }
	
	 
	 Object mapbuiled(String nam1,String[] nam2)throws Exception{
		 
	 
	 HashMap< String, Integer> ship = new HashMap<String,Integer>();
	 
	 for(int i=0;i<10;i++)
	 {
	  int num =  close_count(nam1,nam2[i]);
	  
	  ship.put(nam2[i], num);
	 }
	
	 
	 return ship;
	 
	 }
 
	 //传入人名即可得到其余人与该人亲密度关系
	 LinkedHashMap<String, Integer> friendship (String nam1)throws Exception
	 {
		 
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
		 
		 HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		 
				 hm1 = (HashMap<String, Integer>)mapbuiled(nam1, nam2);
				 hm1.remove(nam1);
				
				 
				 LinkedHashMap<String, Integer> lhm =  new Sort().sort(hm1);
					
					/*Set<String> set = lhm.keySet();
					double sum=0;
					for(String str:set)
					{
						sum+=lhm.get(str);
					}
					
					for(String str:set)
					{
						lhm.put(str,(int)Math.ceil(100*lhm.get(str)/sum));
					}*/
					
					return lhm;
		        
		 
		 
	 }
	 
 }
 