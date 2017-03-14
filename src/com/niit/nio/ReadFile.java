package com.niit.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {

	public static void main(String[] args) {
		//创建文件输入流
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("log_network.txt");
			//创建一个FileChannel
			FileChannel fcin = fis.getChannel();
			//定义一个ByteBuffer对象，用于重复取水
			ByteBuffer bbuff = ByteBuffer.allocate(256);
			//将FileChannel中的数据放入ByteBuffer中
			while(fcin.read(bbuff) !=-1) {
				//锁定Buffer的空白区
				bbuff.flip();
				//创建Charset对象
				Charset charset = Charset.forName("GBK");
				//创建解码器(CharsetDecoder)对象
				CharsetDecoder decoder = charset.newDecoder();
				//将ByteBuffer的内容转码
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.println(cbuff);
				//将Buff初始化，为下一次读数据做准备
				bbuff.clear();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{				
				if(fis!=null){
					fis.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
