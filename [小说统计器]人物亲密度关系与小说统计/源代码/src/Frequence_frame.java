import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frequence_frame extends JFrame{
	
	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	JLabel jl =new JLabel("人物出现频率统计");
	
	
		
		void additeams() throws Exception
		{
		LinkedHashMap<String, Integer> lhm= new Frequence_count().frequence_fun();
		
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jpl2,BorderLayout.CENTER);
		Font f = new Font("宋体", Font.BOLD, 20);
		jl.setFont(f);
		this.setResizable(false); 
		jpl1.add(jl);
		this.setSize(200,500);
		
		jpl2.setLayout(new GridLayout(10, 1,5,5));
		JLabel[] jlbs = new JLabel[10];
		//JLabel[] jlbs2 = new JLabel[10];
		int j=0;
		Set<String> set = lhm.keySet();
		String[] string = new String[10];
		for(String str:set)
		{
			string[j++] = "            "+str+": "+lhm.get(str);
			
		}
		for(int i=0;i<10;i++){
		jlbs[i]=new JLabel(string[i]);	
		
		
		jpl2.add(jlbs[i]);
		}
		
		this.setVisible(false);
	}
	
	
	
		//new Frequence_frame().additeams();
	

}
