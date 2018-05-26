package com.wjcx.actions;

public class RegisterAction {
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
	
	public String execute(){
		System.out.println("ĞÕÃû:"+name);
		System.out.println("ÄêÁä:"+age);
		return "success";
	}
}
