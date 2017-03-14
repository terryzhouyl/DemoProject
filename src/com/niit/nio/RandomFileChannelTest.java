package com.niit.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 对文件内容进行复制，追加在该文件后面
 * @author zyl65
 *
 */
public class RandomFileChannelTest {
	
	public static void main(String[] args) {
		File f = new File("d:/test.txt");
		RandomAccessFile raf = null;
		try {
			//创建一个RandomAccessFile对象
			raf = new RandomAccessFile(f, "rw");
			//获取RandomAccessFile对应的Channel
			FileChannel randomChannel = raf.getChannel();
			
			//将Channel中的所有数据映射成ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY,0,randomChannel.size());
			//把Channel的记录指针移动到最后
			randomChannel.position(f.length());
			//将buffer中的所有数据输出
			randomChannel.write(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
