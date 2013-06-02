package com.dms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ViewUserInfoAction extends UserActionBase {
	
	private User user ;
	private Branch branch ;
	
	public String execute() 
			throws Exception{
		
		ActionContext ctx = ActionContext.getContext() ;
				
		setUser( mgr.getByName( ctx.getSession().get("user").toString() ) ) ;
		setBranch( mgr.getBranchByUser(user) ) ;
								
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
