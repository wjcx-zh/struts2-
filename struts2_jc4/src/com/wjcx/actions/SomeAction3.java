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
	//��root����ʾ�ķ�������
	public String execute(){
		
		Student stu=new Student("�Ŵ�ţ",21);
		Student stu1=new Student("����ī",21);
		Student stu2=new Student("������",23);
		Student stu3=new Student("�����",21);
		Student stu4=new Student("������",28);
		//A.ͨ������ֵջ����������ƶ���
		
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.push(stu);;
		//B.ͨ������root����������ƶ���
		valueStack.getRoot().push(stu1);
		
		//C.���map����
		Map<String,Student> map=new HashMap<String,Student>();
		map.put("studentMap", stu2);
		valueStack.push(map);
		
		//D.ֱ����������ƶ���
		valueStack.set("studentSet", stu3);
		
		//E.��root��Ϊarraylist����Ӷ���
		valueStack.getRoot().add(stu4);
		
		return SUCCESS;
	}
}
