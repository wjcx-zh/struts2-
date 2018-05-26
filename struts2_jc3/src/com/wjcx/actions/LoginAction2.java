package com.wjcx.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



public class LoginAction2 {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//通过ServletActionContext获取Servlet API(真正的Servlet API对象)
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("req_name", username);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("ses_name", username);
		ServletContext application=ServletActionContext.getServletContext();
		application.setAttribute("app_name", username);
		return "success";
	}
}
