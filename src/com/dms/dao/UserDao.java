package com.dms.dao;

import java.util.Collection;
import java.util.List;

import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;

public interface UserDao 
{
	User get(Integer id);

	Integer save(User user);

	void update(User user);

	void delete(Integer id);
	
	void delete(User user);
	
	List<User> getByNameAndPass(User user) ;
	
	List<User> findByName(Integer id);
	
	public List<User> findAll();
	
	public List<User> findAllByPage( int pageNow, int pageSize ) ;
		
	public int getRowCount() ;

	public List<User> findByRole(Role role);
	
	public List<User> getOrgMgr(Org org) ;

	public User getByName(User user);

	List<User> findUnassignedUsers();

	List<User> findAssignedUsers();

	User getByName(String username);
}