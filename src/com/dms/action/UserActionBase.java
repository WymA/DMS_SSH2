package com.dms.action;

import org.apache.struts2.ServletActionContext;

import com.dms.service.MgrManager;
import com.dms.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class UserActionBase extends ActionSupport {
	
	protected UserManager mgr ;

	public void setUserManager(UserManager mgr) {
		this.mgr = mgr;
	}
	
}
