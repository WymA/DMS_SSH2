package com.dms.domain;

import java.util.HashSet;
import java.util.Set;

public class Org {

	private int id ;
	private String orgName ;
	private Org parentOrg ;
	private Set<Org> childOrgs = new HashSet<Org>() ;
	private Set<Privilege> privilege = new HashSet<Privilege>() ;
	private Set<Branch> branch = new HashSet<Branch>() ;
	private Set<User> users = new HashSet<User>() ;
	private Set<Files> files = new HashSet<Files>() ;
	private int version ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Set<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
	public Set<Branch> getBranch() {
		return branch;
	}
	public void setBranch(Set<Branch> branch) {
		this.branch = branch;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

	public Org getParentOrg() {
		return parentOrg;
	}
	public void setParentOrg(Org parentOrg) {
		this.parentOrg = parentOrg;
	}
	public Set<Org> getChildOrgs() {
		return childOrgs;
	}
	public void setChildOrgs(Set<Org> childOrgs) {
		this.childOrgs = childOrgs;
	}
	public Set<Files> getFiles() {
		return files;
	}
	public void setFiles(Set<Files> files) {
		this.files = files;
	}

}
