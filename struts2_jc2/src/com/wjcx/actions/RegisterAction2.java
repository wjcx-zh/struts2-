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
		System.out.println("����:"+user.getName());
		System.out.println("����:"+user.getAge());
		return "success";
	}
}
