package com.niit.guavaTest;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.niit.bean.User;

public class BasicTool {

	public static void main(String[] args) {
		
		//常见Object方法
		Objects.equal("a", "a"); //return true
		int hashCode = Objects.hashCode("abc","123","jkl");
		
		Objects.toStringHelper("MyObject").add("x",1).toString();
		System.out.println(hashCode);
		
		
	}
	
}
