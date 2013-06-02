package com.dms.action;

import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ViewOrgInfoAction 
	extends UserActionBase{

	private Org org ;
	private User user ;
	
	public String execute()
			throws Exception{

		setOrg( mgr.getOrgDetail(org.getId()) ) ;
		setUser( mgr.getOrgMgr(org)) ;
		
		return SUCCESS ;
	}
	
	public Org getOrg() {
		return org;
	}


	public void setOrg(Org org) {
		this.org = org;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
