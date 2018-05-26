package com.wjcx.actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wjcx.bean.Student;

public class SomeAction6 {
	
	//数据加载顺序
	//root数据的加在顺序
	public String execute(){
		
		ActionContext.getContext().put("some", "some_context");
		
		
		return "success";
	}
	
	//request数据的加在顺序
	public String execute_req(){
		
		ActionContext.getContext().put("some", "some_context");
		ActionContext.getContext().getValueStack().set("some", "some_root");
		ServletActionContext.getRequest().setAttribute("some", "some_req");
		return "success";
	}
}
