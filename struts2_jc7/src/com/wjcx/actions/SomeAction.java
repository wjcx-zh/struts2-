package com.wjcx.actions;

import com.opensymphony.xwork2.ActionContext;

public class SomeAction {
	public String execute(){
		ActionContext.getContext().getSession().put("message", "��ӭ��½");
		return "success";
	}
}
