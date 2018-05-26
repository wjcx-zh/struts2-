package com.wjcx.bean;

import java.util.HashSet;
import java.util.Set;

//自关联类
public class News {
	private Integer id;
	private String name;
	private String content;
	private News parentNews; //父栏目
	private Set<News> childrenNews; //子栏目
	
	public News(){
		childrenNews=new HashSet<News>();
	}
	
	public News(String name){
		this();
		this.name=name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public News getParentNews() {
		return parentNews;
	}

	public void setParentNews(News parentNews) {
		this.parentNews = parentNews;
	}

	public Set<News> getChildrenNews() {
		return childrenNews;
	}

	public void setChildrenNews(Set<News> childrenNews) {
		this.childrenNews = childrenNews;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", name=" + name + ", content=" + content 
				+ ", childrenNews=" + childrenNews + "]";
	}
	
	
}
