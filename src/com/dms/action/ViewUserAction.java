package com.dms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ViewUserAction extends MgrActionBase {
	
	private List<User> userList ;
	private List<User> user2List ;
	private List<Role> roleList ;
	private List<Branch> branchList ;
	
	public String execute() 
			throws Exception{
				
		ActionContext ctx = ActionContext.getContext() ;
		
		setUserList( mgr.getAssignedUsers() );
		setRoleList( mgr.getUsersRole(userList) ) ;
		setBranchList( mgr.getAllBranch() ) ;
		setUser2List( mgr.getUnassignedUsers() ) ;
								
		return SUCCESS ;
	}
		
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}

	public List<User> getUser2List() {
		return user2List;
	}

	public void setUser2List(List<User> user2List) {
		this.user2List = user2List;
	}

}
