package com.wjcx.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SomeAction extends ActionSupport {
	
	public String execute(){
		//从HttpServletRequest中获取值栈
		HttpServletRequest request=ServletActionContext.getRequest();
		ValueStack valueStack=(ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		
		//从ActionContext中获取值栈对象
		ValueStack valueStack2=ActionContext.getContext().getValueStack();
		
		System.out.println(valueStack);
		System.out.println(valueStack2);
		
		return NONE;
	}
}
