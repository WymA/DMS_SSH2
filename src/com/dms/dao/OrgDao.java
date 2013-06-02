package com.dms.dao;

import java.util.List;

import com.dms.domain.Org;
import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;

public interface OrgDao 
{
	Org get(Integer id);

	Integer save(Org org);

	void update(Org org);

	void delete(Integer id);
	
	void delete(Org org);
	
	List<Org> findByName(Integer id);
	
	public List<Org> findAll();
	
	public List<Org> findAllByPage( int pageNow, int pageSize ) ;
	
	public int getRowCount() ;
	
	public List<Org> findByRole(Role role) ;
}