package com.wjcx.converse;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class MyDateConverter1 extends DefaultTypeConverter{

	@Override
	public Object convertValue(Object value, Class toType) {
		//SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("test...");
		System.out.println(toType);
		try {
			//��ҳ�浽����������,String-->Date
			if(toType==Date.class){
				System.out.println("ҳ�浽������");
				String[] params=(String[]) value;
				SimpleDateFormat format=getDateFormat(params[0]);
				ActionContext.getContext().put("dateFormat", format);
				//ȷ�����ڸ�ʽ����ȷʱ��Ȼ������input��ͼ
				
				//System.out.println(format.format(format.parse(params[0])));
				return format.parse(params[0]);
			//�ɷ�������ҳ�淽��,Date-->String	
			}else if(toType==String.class){
				System.out.println("��������ҳ��");
				SimpleDateFormat format=(SimpleDateFormat)ActionContext.getContext().get("dateFormat");
				Date date=(Date)value;
				return format.format(date);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.convertValue(value, toType);
	}
	
	//��ȡ���ڸ�ʽ
	private SimpleDateFormat getDateFormat(String source){
		SimpleDateFormat sdf=null;
		if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", source)){
			sdf=new SimpleDateFormat("yyyy-MM-dd");
		}else if(Pattern.matches("^\\d{4}\\d{2}\\d{2}$", source)){
			sdf=new SimpleDateFormat("yyyyMMdd");
		}else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$", source)){
			sdf=new SimpleDateFormat("yyyy/MM/dd");
		}else if(Pattern.matches("^\\d{4}.\\d{2}.\\d{2}$", source)){
			sdf=new SimpleDateFormat("yyyy.MM.dd");
		}else{
			throw new TypeConversionException();
		}
		return sdf;
	}
}
