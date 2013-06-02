package com.dms.domain;

import java.util.HashSet;
import java.util.Set;

public class Privilege {

	private int id ;
	private String priName ;
	private Set<Role> role = new HashSet<Role>() ;
	private Set<Org> org = new HashSet<Org>() ;
	private Set<Branch> branch = new HashSet<Branch>() ;
	private int version ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriName() {
		return priName;
	}
	public void setPriName(String priName) {
		this.priName = priName;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public Set<Org> getOrg() {
		return org;
	}
	public void setOrg(Set<Org> org) {
		this.org = org;
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
}
