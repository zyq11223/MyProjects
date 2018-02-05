

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.InputStreamReader;

public class Read {
	JDialog jd1;
		public void show_read(Frame jf) throws Exception{
			
			jd1 = new JDialog(jf, "阅读小说", true);
	       jd1.setResizable(false); 
			jd1.setVisible(false);
			
			jd1.setSize(500, 700);
			
			JTextArea jta =new JTextArea(500,700);
			jta.setLineWrap(true);
			JScrollPane jsp1 = new JScrollPane(jta);
			jd1.add(jsp1);
			jta.setBackground(Color.PINK);
			File f= new File("word.txt");
			String type = new Change(f).DocumentType();
			BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(f),type));
			
			while(true)
			{
				String str = br.readLine();
				if(str==null)break;
				
				jta.append(str+"\n");
			}
			
		}
	
	}


