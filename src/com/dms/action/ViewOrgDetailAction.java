package com.dms.action;

import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;
import com.opensymphony.xwork2.ActionContext;

public class ViewOrgDetailAction 
	extends MgrActionBase{

	ActionContext ctx = ActionContext.getContext() ; 
	private Org org, childOrg ;
	private User user ;
	private Branch branch ;
	private List<User> users , mgrs ;
	private List<Org> orgs ;
	private List<Branch> branches ;
	
	public String execute()
			throws Exception{
			
		setOrg( mgr.getOrgDetail(org.getId()) ) ;
		setMgrs( mgr.getOrgMgr(org)) ;
		setUsers(mgr.getAllUsers()) ;
		setOrgs(mgr.getAllOrgs()) ;
		setBranches( mgr.getBranch(org)) ;
				
		return SUCCESS ;
	}
	
	public String deleteOrg(){

		mgr.deleteOrg(org) ;
		
		return SUCCESS ;
	}
	
	public String lockOrg(){
				
		return SUCCESS ;
	}
	
	public String mgrOfOrg(){
		
		mgr.mgrOfOrg(org, user) ;
		ctx.put("msg", "操作成功") ;
		
		return SUCCESS ;
	}
	
	public String userOfOrg(){
		
		mgr.userOfOrg( branch, user ) ;		
		ctx.put("msg", "操作成功") ;
		
		return SUCCESS ;
	}
	
	public String childOfOrg(){
			
		mgr.childOrg( org ,childOrg ) ;
		ctx.put("msg", "操作成功") ;
		
		return SUCCESS ;
	}
	
	public String branchOfOrg(){
				
		mgr.branchOfOrg( org ,branch ) ;
		ctx.put("msg", "操作成功") ;
		
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Org> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}
	
	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<User> getMgrs() {
		return mgrs;
	}

	public void setMgrs(List<User> mgrs) {
		this.mgrs = mgrs;
	}

	public Org getChildOrg() {
		return childOrg;
	}

	public void setChildOrg(Org childOrg) {
		this.childOrg = childOrg;
	}

}
