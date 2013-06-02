package com.dms.dao;

import java.util.List;

import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;

public interface RoleDao {

	Role get(Integer id);

	Integer save(Role role);

	void update(Role role);

	void delete(Integer id);
	
	void delete(Role role);
	
	List<Role> findByUser(User user) ;
	
	Integer addMgr(Org org, User mgr ) ;

	Role getByName(Role role);
}
