package com.niit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import com.niit.code.base64.Season;
import com.niit.code.base64.User;

public class Test {
	
	public void describe(Season s) {
		switch (s){
			case Summer:
				System.out.println(Season.Spring +" is very hot");
				break;
			case Winter:
				System.out.println(Season.Winter +" is very cold");
				break;
		} 
	}
	
	public static void main(String[] args) {
		
//		int[][] n = new int[][]{
//				{10,19},
//				{20,29},
//				{30,39},
//				{40,49},
//				{50,59},
//				{60,69},
//				{70,79},
//				{80,100},				
//		};
//		double[] m = {7,6,4.6,4.1,3.6,3.2,3.0,2.7};
//				
//		for(int i=0;i<n.length;i++){
//			System.out.println(n[i][0]+"-"+n[i][1]+":" +n[i][0]*m[i]*29+"-"+n[i][1]*m[i]*29);
//		}
		
		
/*		int n = 19;
		double k = 7.0;
		double down = k*10*29;
		double up = k*n*29;
		int[][] array = new int[100][2];
		double[] array2 = new double[100];
		while(k>2.7){
			k = k-0.2;
			n++;
			if(n*k*29>down)
			
		}
		*/
		
		
//		int k = (int)Math.random()*10;
//		StringBuilder builder = new StringBuilder();
		
		
//		Integer[] data = {3,2,5,7,2,3,5};
//		List<Integer> dataList = Arrays.asList(data);
//		TreeSet<Integer> ts = new TreeSet<>(dataList);
//		
//		for(Integer in : ts){
//			System.out.println(in);
//		}
		
//		List<Integer> initData = Collections.nCopies(30, 0);		
//		List<Integer> list = new ArrayList<>(initData);
//		for(int i=0;i<list.size();i++){
//			System.out.print(list.get(i)+" ");	
//		}
//		list.subList(10, 20).clear();
//		System.out.println();
//		for(int i=0;i<list.size();i++){
//			System.out.print(list.get(i)+" ");	
//		}
		
//		User user1 = new User();
//		user1.setId(12);
//		
//		User user2 = new User();
//		user2.setId(123);
//		
//		User user3 = new User();
//		user3.setId(4);
//		
//		List<User> list = new ArrayList<>();
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
//		
//		Collections.sort(list);
//		for(User user : list){
//			System.out.println(user.getId() + " ");
//		}
//		
//		for(Season s:Season.values()) {
//			System.out.println(s.hashCode());
//		}
//		System.out.println("89048f19b72e7367b7faacfe659a8de0".length());
//		System.out.println(Season.Summer.getDesc());
		
		System.out.println(System.currentTimeMillis());
		
		System.out.println(new Random().nextInt(10));
		
	}
}
