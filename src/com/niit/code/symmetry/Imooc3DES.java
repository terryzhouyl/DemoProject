package com.niit.code.symmetry;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Imooc3DES {

	private static String src = "imooc security des";
	
	public static void main(String[] args) {
		jdk3DES();
	}
	
	private static void jdk3DES() {
		KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("DESede");
			keyGenerator.init(168);			
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//Key转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk desc encrypt:"+Hex.encodeHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk des decrypt:"+new String(result));		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
