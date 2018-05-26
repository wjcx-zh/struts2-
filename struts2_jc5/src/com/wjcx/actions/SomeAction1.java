package com.wjcx.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class SomeAction1 extends ActionSupport {
	private int age;
	private Date birthday;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String execute(){
		System.out.println(age);
		System.out.println(birthday);
		return "success";
	}
}
