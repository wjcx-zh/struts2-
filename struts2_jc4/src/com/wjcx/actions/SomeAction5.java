package com.wjcx.actions;

import com.opensymphony.xwork2.ActionContext;
import com.wjcx.bean.Student;

public class SomeAction5 {
	
	//��context����ʾ�ķ�������
	public String execute(){
		
		Student stu=new Student("������",32);
		Student stu1=new Student("����",26);
		Student stu2=new Student("�ֿ�",26);
		//A.��context��ֱ�ӷ�������
		ActionContext.getContext().put("stu", stu);
		
		//B.��context�е�session��������
		ActionContext.getContext().getSession().put("stu1", stu1);
		
		//C.��context��application�з�������
		ActionContext.getContext().getApplication().put("stu2", stu2);
		
		return "success";
	}
}
