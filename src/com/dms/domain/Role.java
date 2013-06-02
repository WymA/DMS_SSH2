package com.dms.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
	private int id ;
	private String rolename ;
	private Set<User> user = new HashSet<User>() ;
	private Set<Privilege> privilege = new HashSet<Privilege>() ;
	private int version ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Set<Privilege> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
}
