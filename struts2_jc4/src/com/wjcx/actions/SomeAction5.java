package com.wjcx.actions;

import com.opensymphony.xwork2.ActionContext;
import com.wjcx.bean.Student;

public class SomeAction5 {
	
	//向context中显示的放入数据
	public String execute(){
		
		Student stu=new Student("哈瓦那",32);
		Student stu1=new Student("哈那",26);
		Student stu2=new Student("林肯",26);
		//A.向context中直接放入数据
		ActionContext.getContext().put("stu", stu);
		
		//B.向context中的session放入数据
		ActionContext.getContext().getSession().put("stu1", stu1);
		
		//C.向context的application中放入数据
		ActionContext.getContext().getApplication().put("stu2", stu2);
		
		return "success";
	}
}
