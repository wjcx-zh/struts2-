package com.wjcx.actions;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ֹ���д����ʵ��������֤
 * */
public class LoginAction extends ActionSupport {
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
	/*
	//��Action���з���ִ����֤
	@Override
	public void validate() {
		if(username==null||username.trim().equals("")){
			this.addFieldError("username", "�û�������Ϊ��");
		}
		
		if(mobile==null||mobile.trim().equals("")){
			this.addFieldError("mobile", "�ֻ��Ų���Ϊ��");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "�ֻ��Ÿ�ʽ����ȷ");
		}
	}
	*/
	
	//��Actionָ������ִ����֤
	
	public void validateDoOther() {
		System.out.println("ָ������");
		if(username==null||username.trim().equals("")){
			this.addFieldError("username", "�û�������Ϊ��");
		}
		
		if(mobile==null||mobile.trim().equals("")){
			this.addFieldError("mobile", "�ֻ��Ų���Ϊ��");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "�ֻ��Ÿ�ʽ����ȷ");
		}
	}
}
