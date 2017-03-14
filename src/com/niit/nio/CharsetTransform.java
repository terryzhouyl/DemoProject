package com.niit.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.junit.Test;

/**
 * 字符编码的转换
 * @author zyl65
 *
 */
public class CharsetTransform {
	
	//string转
	public void codeTest(){
		//创建简体中文对应的Charset
		Charset cn = Charset.forName("utf-8");
		//获取cn对象对应的编码器和解码器
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		//创建一个CharBuffer对象
		CharBuffer cbuff = CharBuffer.allocate(18);
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		cbuff.flip();
		//将CharBuffer中的字符串序列转换为字节序列
		ByteBuffer bbuff;
		try {
			bbuff = cnEncoder.encode(cbuff);
			//循环访问ByteBuffer中的每个字节
			for(int i=0;i<bbuff.capacity();i++){
				System.out.print(bbuff.get(i) + " ");
			}
			//将ByteBuffer的数据解码成字符序列
			System.out.println("\n"+cnDecoder.decode(bbuff));
		} catch (CharacterCodingException e) {
			e.printStackTrace();
		}
	}
	
	//char自定义编码 成byte
	public byte[] getBytes(char[] chars) {
		Charset cs = Charset.forName("utf-8");
		CharBuffer cb = CharBuffer.allocate(chars.length);
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = cs.encode(cb);
		return bb.array();
	}
	

	@Test
	public void getBytes() {
		char c = '我';
		ByteBuffer heapByteBuffer = ByteBuffer.allocate(2);
		ByteBuffer byteBuffer = heapByteBuffer.putChar(c);
		byteBuffer.flip();
		byte[] by = byteBuffer.array();
		for(int i=0;i<by.length;i++){
			System.out.println(by[i]);
		}
	}
	
	//byte转char
	public char[] getChars (byte[] bytes){
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.put(bytes);
		bb.flip();
		CharBuffer cb = cs.decode(bb);
		return cb.array();
	}
	
	@Test
	public void toHexChar() {
		String str = "我";
		char[] chars = str.toCharArray();
		for(int i=0;i<chars.length;i++){
			System.out.println(Integer.toHexString(chars[i])+" ");
		}
	}
	
	@Test
	public void charToByte() {  
		char c = '我';
        byte[] b = new byte[2];   
        b[0] = (byte) ((c & 0xFF00) >> 8);   
        b[1] = (byte) (c & 0xFF);   
        System.out.print(b[0]);
        System.out.print(b[1]);
    }  
}
