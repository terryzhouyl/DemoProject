package com.niit.net;

import java.io.IOException;

public class MultiThreadDown {

	public static void main(String[] args) throws IOException {
		//初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("http://v2.mukewang.com/d17b9f48-e4c8-4a25-afc3-7ebd79a19f4a/L.mp4?auth_key=1482745083-0-0-dff0c1f86ac9676c1030a6878f0a8e64","d:/imooc.mp4",3);
		//开始下载
		downUtil.download();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(downUtil.getCompleteRate() <1){
					//每隔0.1秒查询一次任务的完成进度
					//GUI程序中可根据该进度来绘制进度条
					System.out.println("已完成:"+downUtil.getCompleteRate());
					try{
						Thread.sleep(1000);
					}
					catch(Exception e){
						
					}
				}
			}
		}).start();
	}
}
