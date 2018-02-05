import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class File_open{
//文件打开以及所有字符的读入，通过函数返回
	String file_in() throws Exception	
	{
				String word = "";
		//读文件操作
		File file = new File("word.txt");
		String type = new Change(file).DocumentType();
		
		
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),type));
		
		
		while(true)
		{
			 String str = bReader.readLine();
			 if(str ==null)break;
			 word = word+str;
			
		}
		
		String word2 = word.replace("大史", "史强");
		
		return word2;
	
}

}