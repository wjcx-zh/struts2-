package com.wjcx.actions;



import com.opensymphony.xwork2.ActionSupport;

/**
 * ���� XML ���÷�ʽʵ��������֤
 * */
public class LoginAction1 extends ActionSupport {
	private String username;
	private String mobile;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String doSome(){
		System.out.println("doSome");
		
		return "some";
	}
	
	public String doOther(){
		System.out.println("doOther");
		
		return "other";
	}
	
}
