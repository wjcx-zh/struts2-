package com.wjcx.actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.wjcx.bean.Student;

public class SomeAction6 {
	
	//���ݼ���˳��
	//root���ݵļ���˳��
	public String execute(){
		
		ActionContext.getContext().put("some", "some_context");
		
		
		return "success";
	}
	
	//request���ݵļ���˳��
	public String execute_req(){
		
		ActionContext.getContext().put("some", "some_context");
		ActionContext.getContext().getValueStack().set("some", "some_root");
		ServletActionContext.getRequest().setAttribute("some", "some_req");
		return "success";
	}
}
