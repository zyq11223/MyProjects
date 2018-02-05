import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Page_frame extends JFrame{

	JPanel jpl1 = new JPanel();
	JPanel jpl2 = new JPanel();
	JLabel jl =new JLabel("人物篇幅跨度");
	
	
		
		void additeams() throws Exception
		{
		
			String[] string = new String[10];
			string = new Page_count().page_fun();
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jpl2,BorderLayout.CENTER);
		Font f = new Font("宋体", Font.BOLD, 20);
		jl.setFont(f);
		this.setResizable(false); 
		jpl1.add(jl);
		this.setSize(500,500);
		
		jpl2.setLayout(new GridLayout(10, 1,5,5));
		JLabel[] jlbs = new JLabel[10];
		
		
		for(int i=0;i<10;i++){
		jlbs[i]=new JLabel(string[i]);	
		
		
		jpl2.add(jlbs[i]);
		}
		
		this.setVisible(false);
	}
	
	
	
		//new Page_frame().additeams();
	
	
}
