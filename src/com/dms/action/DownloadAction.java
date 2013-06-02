package com.dms.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.*;

public class DownloadAction
	extends MgrActionBase {
	
	private String fileName;
	
    public String execute() 
    		throws Exception {  
    	
        return SUCCESS;  
    }  
  
    public InputStream getDownloadFile() { 
    	
        InputStream is = null;  
        try {  
        	
        	System.out.println(getSavePath() + fileName) ;
            is = new FileInputStream(getSavePath() +"\\" + fileName);  
        } catch (FileNotFoundException e) {  
        	
            e.printStackTrace();  
        }  
        return is;  
    }  
  
    public void setFileName(String fileName) {  
    	
        try {
        	
            this.fileName = new String(fileName.getBytes("ISO-8859-1"), "GBK");  
            
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public String getFileName() {  
    	
        String name = "";  
        
        try {
            name = new String(fileName.getBytes("GBK"), "ISO8859-1");  
            
        } catch (UnsupportedEncodingException e) {  
        	
            e.printStackTrace();  
        }  
        return name;  
    }

}
