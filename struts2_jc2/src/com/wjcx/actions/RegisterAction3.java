package com.wjcx.actions;

import java.util.List;

import com.wjcx.bean.User;

public class RegisterAction3 {
	private List<User> users;
	
	
	

	public List<User> getUsers() {
		return users;
	}




	public void setUsers(List<User> users) {
		this.users = users;
	}




	public String execute(){
		/*System.out.println("����:"+user.getName());
		System.out.println("����:"+user.getAge());*/
		return "success";
	}
}
