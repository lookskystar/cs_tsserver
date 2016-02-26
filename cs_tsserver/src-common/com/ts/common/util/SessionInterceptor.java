package com.ts.common.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ts.common.pojo.Users;

public class SessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4756613723246123058L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext=invocation.getInvocationContext();
		Class clazz=invocation.getAction().getClass();
		String clazzName=clazz.getName();
		Users user=(Users)actionContext.getSession().get("session_user");
		if(clazzName.equals("com.ts.server.action.LoginAction")||user!=null){
			return invocation.invoke();
		}
		return "redirect_login";
	}

}
