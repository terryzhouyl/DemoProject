package com.niit.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import org.junit.Test;

public class NIODemo {
	
	/**
	 * 使用缓冲来读取文件内容
	 * @param filePath
	 */
	public void readFile(String filePath) {
		//创建文件输入流
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			//创建一个FileChannel
			FileChannel fcin = fis.getChannel();
			//定义一个ByteBuffer对象，用于重复取水
			ByteBuffer bbuff = ByteBuffer.allocate(256);
			//将FileChannel中的数据放入ByteBuffer中
			while(fcin.read(bbuff) !=-1) {
				//锁定Buffer的空白区
				bbuff.flip();
				//创建Charset对象
				Charset charset = Charset.forName("utf-8");
				//创建解码器(CharsetDecoder)对象
				CharsetDecoder decoder = charset.newDecoder();
				//将ByteBuffer的内容转码
				CharBuffer cbuff = decoder.decode(bbuff);
				System.out.println(cbuff);
				//将Buff初始化，为下一次读数据做准备
				bbuff.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	
	/**
	 * 使用map来读取文件内容
	 */
	public void readFileByMap(String filePath) {
		File f = new File(filePath);
		System.out.println(System.getProperty("file.encoding"));
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			FileChannel channel = fis.getChannel();
			//一次性将文件全都读入
			MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0,f.length());
			Charset charset = Charset.forName("utf-8");
			CharsetDecoder decorder = charset.newDecoder();
			CharBuffer charBuffer =	decorder.decode(mapBuffer);
			System.out.println(charBuffer.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile() {
		
	}
	
	/**
	 * 下载文件
	 */
	@Test
	public void downLoad() {
		File file = new File("d:/imooc.mp4");
		FileOutputStream os = null;
		InputStream is = null;
		try {
			os = new FileOutputStream(file);
			URL url = new URL("http://v2.mukewang.com/d17b9f48-e4c8-4a25-afc3-7ebd79a19f4a/L.mp4?auth_key=1482745083-0-0-dff0c1f86ac9676c1030a6878f0a8e64");
			int c;
			//此处默认时http协议下载
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//conn.setRequestProperty("Accept","image/gif,image/jpeg,image/jpeg,image/png");
			int size = conn.getContentLength();
			is = conn.getInputStream();
			long start = System.currentTimeMillis();
			byte[] by = new byte[2048];
			int hasRead = 0;
			int length = 0;
			while((hasRead = is.read(by))!=-1){
				os.write(by, 0, hasRead);
				length+=hasRead;
				System.out.println(length*1.0/size);
			}
			os.flush();
			long end = System.currentTimeMillis();
			System.out.println("总共花费时间"+(end-start));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(os!=null)
					os.close();
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void downLoadForNIO() {
		File file = new File("D:/imooc.mp4");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			FileChannel ochannel = os.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(2048);
			byte[] by = new byte[2048];
			URL url = new URL("http://v2.mukewang.com/d17b9f48-e4c8-4a25-afc3-7ebd79a19f4a/L.mp4?auth_key=1482745083-0-0-dff0c1f86ac9676c1030a6878f0a8e64");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			InputStream is = conn.getInputStream();
			int size = conn.getContentLength();
			long start = System.currentTimeMillis();
			int length = 0;
			int hasRead;
			while((hasRead = is.read(by))!=-1){
				//buffer.put(by);
				buffer.put(by, 0, hasRead);
				buffer.flip();
				ochannel.write(buffer);
				buffer.clear();
				length+=hasRead;
				System.out.println(length*1.0/size);
			}
			long end = System.currentTimeMillis();
			System.out.println("总共花费时间"+(end-start));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(os!=null){				
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		NIODemo demo = new NIODemo();
		demo.readFileByMap("d:/test.txt");
	}
}
