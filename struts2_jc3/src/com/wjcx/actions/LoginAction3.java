package com.wjcx.actions;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;



public class LoginAction3 implements RequestAware,SessionAware,ApplicationAware{
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//通过实现特定接口来获取Servlet API(map)
	public String execute(){
		request.put("req_name", username);
		session.put("ses_name", username);
		application.put("app_name", username);
		System.out.println("通过实现特定接口来获取Servlet API(map)");
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}
}
