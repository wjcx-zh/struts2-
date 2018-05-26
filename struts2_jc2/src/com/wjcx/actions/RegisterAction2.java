package com.wjcx.actions;

import com.wjcx.bean.User;

public class RegisterAction2 {
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String execute(){
		System.out.println("ĞÕÃû:"+user.getName());
		System.out.println("ÄêÁä:"+user.getAge());
		return "success";
	}
}
