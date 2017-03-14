package com.niit.code.base64;

public class User implements Comparable<User>{
	
	private int id;
	private String name;
	private String password;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(o.getId() > this.getId()){
			return 1;
		}
		else{			
			return -1;
		}
	}
	
	
}
