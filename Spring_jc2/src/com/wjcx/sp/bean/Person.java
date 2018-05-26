package com.wjcx.sp.bean;

import java.util.Set;

public class Person {
	private int age;
	private String perName;
	private Set<Student> students;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", perName=" + perName + ", students=" + students + "]";
	}
}
