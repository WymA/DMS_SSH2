package com.dms.dao;

import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;

public interface BranchDao 
{
	Branch get(Integer id);

	Integer save(Branch branch);

	void update(Branch branch);

	void delete(Integer id);
	
	void delete(Branch branch);
	
	List<Branch> findByName(Integer id);
	
	public List<Branch> findAll();
	
	public List<Branch> findAllByPage( int pageNow, int pageSize ) ;
	
	public int getRowCount() ;
	
	public Branch getByName(Branch branch ) ;

	List<Branch> findAllByOrg(Org org);

	Branch getByUser(User user);
}