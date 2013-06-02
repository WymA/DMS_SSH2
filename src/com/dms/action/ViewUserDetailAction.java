package com.dms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ViewUserDetailAction
extends MgrActionBase {
	
	private User user ;
	private Branch branch ;

	
	public String assignUser(){
		
		mgr.assignUser( branch, user ) ;
		
		return SUCCESS ;
	}
	
	public String deleteUser(){
		
		mgr.deleteUser( user ) ;
		
		return SUCCESS ;
	}
	
	public String lockUser(){
		
		ActionContext ctx = ActionContext.getContext() ;
		
		mgr.lockUser( user ) ;
		ctx.put("msg", "²Ù×÷³É¹¦") ;
	
		
		return SUCCESS ;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
