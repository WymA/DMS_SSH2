package com.dms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.domain.Org;
import com.dms.domain.Role;
import com.opensymphony.xwork2.ActionContext;

public class OrgAction extends UserActionBase {

	private List<Org> orgList ;
	
	public String execute() 
			throws Exception{
				
		setOrgList( mgr.getAllOrg() );
					
		return SUCCESS ;
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}
}
