package com.wjcx.bean;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private Integer cid;
	private String cname;
	
	//单向关联时注掉次属性
	private Set<Student1> students;
	
	public Course(){
		students=new HashSet<Student1>();
		
	}
	public Course(String cname){
		this();
		this.cname=cname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student1> getStudents() {
		return students;
	}
	public void setStudents(Set<Student1> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
