package com.dms.dao;

import java.util.Collection;
import java.util.List;

import com.dms.domain.Files;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;

public interface FileDao 
{
	Files get(Integer id);

	Integer save(Files files);

	void update(Files files);

	void delete(Integer id);
	
	void delete(Files files) ;
	
	List<Files> findByOrg(Org org) ;
}