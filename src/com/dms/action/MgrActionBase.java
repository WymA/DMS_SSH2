package com.dms.action;

import org.apache.struts2.ServletActionContext;

import com.dms.service.MgrManager;
import com.opensymphony.xwork2.ActionSupport;

public class MgrActionBase extends ActionSupport {
	
	protected String savePath ;
	protected MgrManager mgr ;
	
	public void setMgrManager(MgrManager mgr) {
		this.mgr = mgr;
	}
	
	public String getSavePath() {
		
		return ServletActionContext.getServletContext()
				.getRealPath("/WEB-INF/files" );
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
