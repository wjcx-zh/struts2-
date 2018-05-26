package com.wjcx.actions;



public class SomeAction4 {
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	//向root中隐示的放入数据
	public String execute(){
		
		
		
		return "success";
	}
}
