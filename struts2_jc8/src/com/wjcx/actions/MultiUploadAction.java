package com.wjcx.actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class MultiUploadAction {
	private File[] img;
	private String[] imgFileName;
	public File[] getImg() {
		return img;
	}
	public void setImg(File[] img) {
		this.img = img;
	}
	public String[] getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String[] imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	public String execute(){
		String path=ServletActionContext.getServletContext().getRealPath("/imgs");
		if(img!=null){
			
			System.out.println(path);
			for(int i=0;i<img.length;i++){
				File file=new File(path,imgFileName[i]);
				try {
					System.out.println(img[i].getName());
					FileUtils.copyFile(img[i], file);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "fail";
				}
				
			}
			return "success";
			
		}
		return "fail";
	}
}
