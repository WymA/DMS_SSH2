package com.dms.action;

import com.dms.domain.Branch;
import com.dms.domain.Files;
import com.dms.domain.Org;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.*;

public class UploadAction extends MgrActionBase
{
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private Org org ;
	
	public void setTitle(String title) 
	{
		this.title = title; 
	}
	public String getTitle()
	{
		return (this.title); 
	}
	public void setUpload(File upload) 
	{
		this.upload = upload; 
	}
	public File getUpload() 
	{
		return (this.upload); 
	}
	public void setUploadContentType(String uploadContentType) 
	{
		this.uploadContentType = uploadContentType; 
	}
	public String getUploadContentType()
	{
		return (this.uploadContentType); 
	}
	public void setUploadFileName(String uploadFileName) 
	{
		this.uploadFileName = uploadFileName; 
	}
	public String getUploadFileName() 
	{
		return (this.uploadFileName); 
	}
	public String execute() throws Exception	{
		
	System.out.println(getSavePath()
					+ "\\" + uploadFileName );
		try{
			
			FileOutputStream fos = new FileOutputStream(getSavePath()
				+ "\\" + getUploadFileName() );

			
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			
			System.out.println("oh yes");
			
			while ((len = fis.read(buffer)) > 0){
				
				fos.write(buffer , 0 , len);
			}
			
			System.out.println("oh no");
			
			
			fos.close();
			fis.close() ;
			
		}catch(Exception e){
			
			e.printStackTrace() ;
		}
		
		mgr.uploadFile(getUploadFileName(), getOrg() ) ;
		
		return SUCCESS;
	}

	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	
}