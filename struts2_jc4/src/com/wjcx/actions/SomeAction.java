package com.wjcx.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SomeAction extends ActionSupport {
	
	public String execute(){
		//��HttpServletRequest�л�ȡֵջ
		HttpServletRequest request=ServletActionContext.getRequest();
		ValueStack valueStack=(ValueStack)request.getAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY);
		
		//��ActionContext�л�ȡֵջ����
		ValueStack valueStack2=ActionContext.getContext().getValueStack();
		
		System.out.println(valueStack);
		System.out.println(valueStack2);
		
		return NONE;
	}
}
