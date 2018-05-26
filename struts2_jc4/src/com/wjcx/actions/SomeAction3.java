package com.wjcx.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.wjcx.bean.Student;

public class SomeAction3 extends ActionSupport {
	//向root中显示的放入数据
	public String execute(){
		
		Student stu=new Student("张大牛",21);
		Student stu1=new Student("赵子墨",21);
		Student stu2=new Student("江修仁",23);
		Student stu3=new Student("乔瑾夏",21);
		Student stu4=new Student("傅辰烨",28);
		//A.通过操作值栈来添加无名称对象
		
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.push(stu);;
		//B.通过操作root来添加无名称对象
		valueStack.getRoot().push(stu1);
		
		//C.添加map对象
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("studentMap", stu2);
		valueStack.push(map);
		
		//D.直接添加有名称对象
		valueStack.set("studentSet", stu3);
		
		//E.将root作为arraylist来添加对象
		valueStack.getRoot().add(stu4);
		
		return SUCCESS;
	}
}
