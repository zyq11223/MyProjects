import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;
import java.security.*;
import java.security.KeyStore.Entry;
public class Sort {
//将乱序的哈希表按照频率排为有序
	LinkedHashMap<String, Integer> sort(Map<String, Integer> map)
	{		
		
		
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());    
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()    
          {     
              public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)    
              {    
               if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())>0)
            	       return 1; 
               
             else    return -1;    
                  
                    
              }    
          });    
		
        
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        
        int size = list.size();
        for(int i=0;i<size;i++)
        	lhm.put(list.get(i).getKey(), list.get(i).getValue());
		/*
        Set< String> set = lhm.keySet();
        for(String str:set)
        	System.out.println(str+lhm.get(str));*/
	
			return lhm;
	}

	
}
