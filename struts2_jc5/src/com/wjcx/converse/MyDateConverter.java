package com.wjcx.converse;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyDateConverter extends DefaultTypeConverter{

	@Override
	public Object convertValue(Object value, Class toType) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("test...");
		System.out.println(toType);
		try {
			//由页面到服务器方向,String-->Date
			if(toType==Date.class){
				System.out.println("页面到服务器");
				String[] params=(String[]) value;
				//确保日期格式不正确时依然能跳到input视图
				if(!Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", params[0])){
					throw new TypeConversionException();
				}
				//System.out.println(format.format(format.parse(params[0])));
				return format.parse(params[0]);
			//由服务器到页面方向,Date-->String	
			}else if(toType==String.class){
				System.out.println("服务器到页面");
				Date date=(Date)value;
				return format.format(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.convertValue(value, toType);
	}
	
}
