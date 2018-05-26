package com.wjcx.actions;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 手工编写代码实现数据验证
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
	//对Action所有方法执行验证
	@Override
	public void validate() {
		if(username==null||username.trim().equals("")){
			this.addFieldError("username", "用户名不能为空");
		}
		
		if(mobile==null||mobile.trim().equals("")){
			this.addFieldError("mobile", "手机号不能为空");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "手机号格式不正确");
		}
	}
	*/
	
	//对Action指定方法执行验证
	
	public void validateDoOther() {
		System.out.println("指定方法");
		if(username==null||username.trim().equals("")){
			this.addFieldError("username", "用户名不能为空");
		}
		
		if(mobile==null||mobile.trim().equals("")){
			this.addFieldError("mobile", "手机号不能为空");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "手机号格式不正确");
		}
	}
}
