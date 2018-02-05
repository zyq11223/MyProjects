import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Close_frame extends JFrame{
	JTabbedPane jtp = new JTabbedPane(JTabbedPane.NORTH);
	JPanel[] jpl = new JPanel[10];
	JPanel jp0 = new JPanel();
	
	
	void additeams() throws Exception{
		
		
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
		 for(int i=0;i<10;i++)
			 jpl[i] = new JPanel();
		 
		 for(int i=0;i<10;i++)
		 {
			 jtp.add(jpl[i],name[i]);
		 }
		 
			
		 
		 this.setResizable(false); 
		jp0.add(new JLabel("人物亲密度统计"));
		this.add(jp0,BorderLayout.NORTH);
		this.add(jtp,BorderLayout.CENTER);
		this.setSize(800,700);
		
		this.setVisible(false);
		
		for(int j=0;j<10;j++)
		{
		jpl[j].setLayout(new GridLayout(10, 1,5,5));
		LinkedHashMap<String, Integer> lhm = new Close_count().friendship(name[j]);
		JLabel[] jlb = new JLabel[9];
		
		Iterator<String> it4 = lhm.keySet().iterator();
		String[] str = new String[9];
		int k=0;
		while(it4.hasNext())
		{
			str[k++] = it4.next();
			
		}
		for(int i=0;i<9;i++)
		{ String string = str[i]+lhm.get(str[i]);
		
			jlb[i] = new JLabel(string);
		}
		
		for(int i=0;i<9;i++)
		{
			jpl[j].add(jlb[i]);
		}
		}
	}
	
	
	
}
