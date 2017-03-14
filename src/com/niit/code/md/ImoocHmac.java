package com.niit.code.md;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.encoders.Hex;


public class ImoocHmac {
	
	public static String src = "123456";
	
	public static void main(String[] args) {
		
	}
	public static void jdkHmacMD5() {
		
		KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("HmacMD5");
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] key = secretKey.getEncoded();
			
			SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			mac.init(restoreSecretKey);
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
			System.out.println("jdk hmacMD5:"+Hex.toHexString(hmacMD5Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}
