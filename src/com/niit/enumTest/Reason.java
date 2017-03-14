package com.niit.enumTest;

public enum Reason {
	
	Spring("春"),Summer("夏"),Autumn("秋"),Winter("冬");
	
	private String desc;

	Reason(String desc){
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}
		
}
