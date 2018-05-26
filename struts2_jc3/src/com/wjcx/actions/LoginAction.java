package com.wjcx.actions;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//通过ActionContext获取Servlet API
	public String execute(){
		ActionContext.getContext().put("req_name", username);
		ActionContext.getContext().getSession().put("ses_name", username);
		ActionContext.getContext().getApplication().put("app_name", username);
		return "success";
	}
}
