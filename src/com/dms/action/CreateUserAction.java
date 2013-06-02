package com.dms.action;


import java.util.ArrayList;
import java.util.List;

import com.dms.domain.Role;
import com.dms.domain.User;
import com.dms.inter.WebConst;
import com.dms.service.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


public class CreateUserAction
	extends MgrActionBase
{	
	private User user = new User() ;
	private String tip;
	private String repassword ;
	
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
				
		if ( repassword.equals(user.getPassword()) ){
			
			//mgr.createUser(user) ;
			
			setTip("添加成功！") ;
			
		}else{
			
			setTip("两次输入不符") ;

		}
		
		return SUCCESS ;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
