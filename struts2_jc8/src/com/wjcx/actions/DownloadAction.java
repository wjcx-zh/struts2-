package com.wjcx.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class DownloadAction {
	//服务器本地提供下载资源的输入流
	private InputStream is;
	//用户所提供的下载资源的文件名
	private String fileName;
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String execute() throws UnsupportedEncodingException{
		//指定要下载的文件名
		fileName="2017-12-28_124642.png";
		is=ServletActionContext.getServletContext()
					.getResourceAsStream("/imgs/"+fileName);
		fileName="ww.jpg";
		fileName=new String(fileName.getBytes("utf-8"),"ISO8859-1");
		return "success";
	}
}
