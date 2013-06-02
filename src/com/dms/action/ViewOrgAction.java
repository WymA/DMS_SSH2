package com.dms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.domain.Org;
import com.dms.domain.Role;
import com.opensymphony.xwork2.ActionContext;

public class ViewOrgAction
extends MgrActionBase {

	private List<Org> orgList ;
	
	public String execute() 
			throws Exception{
		
//		ActionContext ctx = ActionContext.getContext() ;
//		List<Role> lr = (ArrayList<Role>)ctx.getSession().get("rolelist") ;
		
		setOrgList( mgr.getOrgs() );
					
		return SUCCESS ;
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
}
