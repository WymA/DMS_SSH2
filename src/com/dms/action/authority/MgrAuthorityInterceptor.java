package com.dms.action.authority;

import com.opensymphony.xwork2.*;

import com.opensymphony.xwork2.interceptor.*;

public class MgrAuthorityInterceptor
	extends AbstractInterceptor{
	
	private String tip ;
	
	public String intercept(ActionInvocation invocation) 
		throws Exception	{
		
		
//		ActionContext ctx = ActionContext.getContext();
//		int role = Integer.parseInt( ctx.getSession()
//			.get("role").toString());

		return invocation.invoke();

	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}