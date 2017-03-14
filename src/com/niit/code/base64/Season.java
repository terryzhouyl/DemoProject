package com.niit.code.base64;

public enum Season {
	
	Spring("春"),Summer("夏"),Autumn("秋"),Winter("冬");
	
	private String desc;
	Season(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return desc;
	}		
}
