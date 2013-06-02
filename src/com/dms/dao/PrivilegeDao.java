package com.dms.dao;

import java.util.List;

import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;

public interface PrivilegeDao {

	Privilege get(Integer id);

	Integer save(Privilege privilege);

	void update(Privilege privilege);

	void delete(Integer id);
	
	void delete(Privilege privilege);
	
	List<Privilege> findByRole(Role role) ;
	
}
