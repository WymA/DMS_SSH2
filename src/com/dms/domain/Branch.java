package com.dms.domain;

import java.util.HashSet;
import java.util.Set;

public class Branch {

	private int id ;
	private String branchName ;
	private Org org ;
	private Set<Privilege> privilege = new HashSet<Privilege>() ;
	private Set<User> users = new HashSet<User>() ;
	public int version;

	public int getId() {
		return id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Set<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
