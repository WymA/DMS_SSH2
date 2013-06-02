package com.dms.action;


import java.util.ArrayList;
import java.util.List;

import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;
import com.dms.service.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


public class LoginAction
	extends MgrActionBase
{	
	private User user = new User() ;
	private String tip;
	private String vercode ;
	
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	public User getModel() {
		return user;
	}

	public void setUserBean(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		
		ActionContext ctx = ActionContext.getContext() ;
		String ver = (String)ctx.getSession().get("rand") ;
				
		if ( vercode.equalsIgnoreCase(ver) || true ){
			
			List<Role> lr = mgr.validLogin(user) ;

			if ( lr != null ){
				
				ctx.getSession().put("rolelist", lr ) ;
				ctx.getSession().put("user", user.getUsername()) ;
				
				return SUCCESS ;
				
			}else{
				
				setTip("用户名或密码错误") ;
				return ERROR ;
			}
			
		}else{
			
			setTip("验证码错误，请重新输入") ;
			return ERROR ;
			
		}
		
	}
}
