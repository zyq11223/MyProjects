import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Introduce  {
JDialog jd1;
	public void show_introduce(Frame jf) throws Exception{
		
		 jd1 = new JDialog(jf, "小说简介", true);
		
		 jd1.setResizable(false); 
		
		jd1.setVisible(false);
		
		jd1.setSize(500, 700);
		
		JTextArea jta =new JTextArea(500,700);
		jta.setLineWrap(true);
		JScrollPane jsp1 = new JScrollPane(jta);
		jd1.add(jsp1);
		jta.setBackground(Color.PINK);
		File f= new File("word2.txt");
String type = new Change(f).DocumentType();
		BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream("word2.txt"),type));
		
		while(true)
		{
			String str = br.readLine();
			if(str==null)break;
			
			jta.append(str+"\n");
		}
		
	}
	
	
}
