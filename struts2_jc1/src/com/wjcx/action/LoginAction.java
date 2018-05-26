package com.wjcx.action;

public class LoginAction {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doM1(){
		System.out.println("你好!"+username);
		System.out.println("你好!"+password);
		return "success";
	}
	
	public String doTest(){
		System.out.println("你好!"+username);
		System.out.println("你好!"+password);
		System.out.println("你好!doTest");
		return "success";
	}
	
}
