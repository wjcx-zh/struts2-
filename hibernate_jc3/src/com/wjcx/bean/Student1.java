package com.wjcx.bean;

import java.util.HashSet;
import java.util.Set;

public class Student1 {
	private Integer sid;
	private String sname;
	private Set<Course> courses;
	
	public Student1(){
		courses=new HashSet<Course>();
	}
	
	public Student1(String sname){
		this();
		this.sname=sname;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student1 [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}
	
}
