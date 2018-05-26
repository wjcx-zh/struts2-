package com.wjcx.sp.bean;

public class Course {
	
	private String cname;
	private String info;
	
	@Override
	public String toString() {
		return "Course [cname=" + cname + ", info=" + info + "]";
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
