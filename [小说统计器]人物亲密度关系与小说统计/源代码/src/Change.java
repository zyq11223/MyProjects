

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import org.w3c.dom.DocumentType;









public class Change {

	public File file = null;
	public Change(File file) {
		// TODO Auto-generated constructor stub
		this.file = file;
	}
	public String DocumentType(){
		try
		{
			BufferedInputStream stream = new BufferedInputStream(new FileInputStream(this.file));
			switch((stream.read() << 8) + stream.read())
			{
			case 0xefbb:  
	           return "UTF-8";  
	        case 0xfffe:  
	            return "Unicode";    
	        case 0xfeff:  
	           return "UTF-16BE";  
	        default:  
	            return "GBK";  
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "GBK";
	}
	
}

