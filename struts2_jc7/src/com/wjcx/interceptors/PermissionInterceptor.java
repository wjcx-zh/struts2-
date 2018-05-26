package com.wjcx.interceptors;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	@Override
	public void destroy() {
		

	}

	@Override
	public void init() {
		

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String user=(String)ActionContext.getContext().getSession().get("user");
		if("beijing".equals(user)){
			//ִ��Action����,����Action�������ص�ֵ
			return invocation.invoke();
		}
		ActionContext.getContext().getSession().put("message", "��δ��¼");
		return "message";
	}

}
