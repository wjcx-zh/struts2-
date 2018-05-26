package com.wjcx.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SomeAction2 extends ActionSupport {
	
	public String execute(){
		//向ActionContext中放入数据
		ActionContext.getContext().put("some","shanghai");
		//向值栈放入数据
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.getContext().put("some", "beijing");
		
		return SUCCESS;
	}
}
