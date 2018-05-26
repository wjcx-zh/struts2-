package com.wjcx.hbn.bean;

public class Student {
	/*
	 * CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

	 * */
	private Integer id;
	private String stuname;
	private int age;
	private double score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuname=" + stuname + ", age=" + age + ", score=" + score + "]";
	}
	
}
