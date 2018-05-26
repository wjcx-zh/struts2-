package com.wjcx.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File img;
	private String imgFileName;
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	public String execute(){
		if(img!=null){
			String path=ServletActionContext.getServletContext().getRealPath("/imgs");
			System.out.println(path);
			File file=new File(path,imgFileName);
			try {
				FileUtils.copyFile(img, file);
				return "success";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "fail";
			}
			
		}
		return "fail";
	}
}
