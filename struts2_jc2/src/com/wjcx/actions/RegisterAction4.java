package com.wjcx.actions;

import com.opensymphony.xwork2.ModelDriven;
import com.wjcx.bean.User;

public class RegisterAction4 implements ModelDriven<User>{
	private User user;
	
	/*
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

*/
	public String execute(){
		/*System.out.println("ĞÕÃû:"+name);
		System.out.println("ÄêÁä:"+age);*/
		return "success";
	}


	@Override
	public User getModel() {
		if(user==null){
			user=new User();
		}
		return user;
	}
}
