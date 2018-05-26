package com.wjcx.hb.bean;

import java.io.Serializable;

public class Animal implements Serializable{
	private static final long serialVersionUID = -2165585811525525179L;
	private String id;
	private String name;
	private int age;
	
	//解决丢失更新
	private int version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", age=" + age + ", version=" + version + "]";
	}
	
	
}
