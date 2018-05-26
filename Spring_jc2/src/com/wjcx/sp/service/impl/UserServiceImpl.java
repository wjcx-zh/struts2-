package com.wjcx.sp.service.impl;

import com.wjcx.sp.service.UserService;

public class UserServiceImpl implements UserService{
	public void sayHello(){
		System.out.println("Hello Spring!");
	}
	
	public void init(){
		System.out.println("initialize.....");
		
	}
	
	public void destroy(){
		System.out.println("destroy.....");
	}
}
