import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.swing.JOptionPane;

public class Decrypt {
public static byte[] decrypt(byte[] encrypt,String filename) throws Exception{
		
		
		
		
      //读取私钥	
    	File file_key = new File("Key#"+filename);
    	if(!file_key.exists())
    		{
    		new JOptionPane().showMessageDialog(null, "无法解密!");
    		return encrypt;//无法解密
    		}
    	
    	FileInputStream fis =new FileInputStream(file_key);
    	ObjectInputStream ois = new ObjectInputStream(fis);
    	PrivateKey privateKey = (PrivateKey)ois.readObject();//获取私钥
    	fis.close();
    	ois.close();
    	
		
		
		
    	Cipher cipher = Cipher.getInstance("RSA");//指定RSA算法
		cipher.init(Cipher.DECRYPT_MODE, privateKey);//传入私钥
		
		int inputLen = encrypt.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        
        for(int i = 0; inputLen - offSet > 0; offSet = i * 128) {
            byte[] cache;
            
            if(inputLen - offSet > 128) {
                cache = cipher.doFinal(encrypt, offSet, 128);
            } else {
                cache = cipher.doFinal(encrypt, offSet, inputLen - offSet);
                
            }
            
            out.write(cache, 0, cache.length);
            ++i;
        }
      
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
		
		
		
		
	}


}
