package com.dms.action;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dms.domain.Files;
import com.dms.domain.Org;
import com.opensymphony.xwork2.ActionContext;

public class FileListAction extends MgrActionBase {

	private List<Org> orgList ;
	private List<Files> fileList ;
	private Org org ;
	
	public String execute() throws Exception {  
		
		setOrgList( mgr.getAllOrgs() ) ;
		if ( org == null ){
			
			setFileList( mgr.getFilesByOrg( orgList.get(0) ) ) ;
		}else{
			
			setFileList( mgr.getFilesByOrg( org ) ) ;
		}
		
		return SUCCESS ;
    }  
 
	public List<Files> getFileList() {
		return fileList;
	}

	public void setFileList(List<Files> fileList) {
		this.fileList = fileList;
	}

	public List<Org> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Org> orgList) {
		this.orgList = orgList;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}  
    

}
