package HandleTraceRoute;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import HandleJpcap.Packages;

public class RouteFrame extends JFrame{

	
	
	public RouteFrame(String host,ArrayList<String> result) {
		

		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
	

		
		jta.append("      访问 "+host+" 经过的站点"+'\n'+'\n');
		int i = 1;
		for(String str:result)
		jta.append("         "+(i++)+".  "+str+'\n');
		

		Font font = new Font("Consolas", Font.BOLD | Font.ITALIC, 15);
		jta.setFont(font);
		jta.setForeground(Color.BLACK);
		jta.setEnabled(false);







		this.setResizable(false);
		this.add(jsp);
		this.setLocation(950, 130);
		this.setSize(300,475);
		this.setVisible(true);
	}
	
	
	
}
