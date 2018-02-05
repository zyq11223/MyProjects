
import javax.crypto.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;
import java.util.Random;


public class Encrypt implements Serializable{
    
	public static byte[] encrypt(byte[] data,String filename) throws Exception{
		
		Cipher cipher = Cipher.getInstance("RSA");//指定RSA算法
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		//生成一个密钥对
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();//私钥
		PublicKey publicKey = keyPair.getPublic();//公钥
		
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);//传入公钥
		int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;

        for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
            byte[] cache;
            if(inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            ++i;
        }

        byte[] encryptedData = out.toByteArray();
        out.close();
        
		//保存私钥
		 File file_key = new File("Key#"+filename);	      
     	FileOutputStream fos = new FileOutputStream(file_key);    	
     	ObjectOutputStream oos = new ObjectOutputStream(fos);
     	oos.writeObject(privateKey);     	
     	fos.close();
     	oos.close();
     	
    
		return encryptedData;
		
		
		
		
	}
	
	
}
