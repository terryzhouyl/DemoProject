package com.niit.test;

import java.util.HashMap;
import java.util.Map;

public class CalFoodFee {
	
	public static void main(String[] args) {
		
		
		Map<String,Double> map = new HashMap<>();
		map.put("奚",16.0);
		map.put("亮",16.0);
		map.put("朱",18.0);
		map.put("良",22.0);
		
		double deduce = 59;
		
		double total = 0.0;
		for(String s:map.keySet()){
			total+=map.get(s);
		}
		double p = (total-deduce)/total;
		for(String s:map.keySet()){
			System.out.println(s + " : " + (map.get(s)- map.get(s)*p));
		}
	}
}
