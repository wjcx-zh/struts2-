package com.wjcx.sp.bean;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("student1")
public class Student {
	private int age;
	private String sname;
	private Map<String,String> map;
	
	private List<Course> courses;

	@Override
	public String toString() {
		return "Student [age=" + age + ", sname=" + sname + ", map=" + map + ", courses=" + courses + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
