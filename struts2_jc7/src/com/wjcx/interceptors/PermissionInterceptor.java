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
			//执行Action方法,返回Action方法返回的值
			return invocation.invoke();
		}
		ActionContext.getContext().getSession().put("message", "您未登录");
		return "message";
	}

}
