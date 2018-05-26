package com.wjcx.sp.service.impl;

import org.springframework.stereotype.Service;

import com.wjcx.sp.service.UserService;

@Service("userService")
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
