package com.wjcx.actions;

import com.opensymphony.xwork2.ActionContext;

public class SomeAction {
	public String execute(){
		ActionContext.getContext().getSession().put("message", "»¶Ó­µÇÂ½");
		return "success";
	}
}
