package com.wjcx.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SomeAction2 extends ActionSupport {
	
	public String execute(){
		//��ActionContext�з�������
		ActionContext.getContext().put("some","shanghai");
		//��ֵջ��������
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.getContext().put("some", "beijing");
		
		return SUCCESS;
	}
}
