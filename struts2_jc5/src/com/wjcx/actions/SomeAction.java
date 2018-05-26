package com.wjcx.actions;

import java.util.Date;

public class SomeAction {
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String execute(){
		System.out.println(birthday);
		return "success";
	}
}
