package com.wjcx.sp.bean;

import java.util.Set;

public class Teacher {
	private String tname;
	private int age;
	private Set<Course> course;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	public Teacher(String tname, int age, Set<Course> course) {
		super();
		this.tname = tname;
		this.age = age;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Teacher [tname=" + tname + ", age=" + age + ", course=" + course + "]";
	}
	
}
