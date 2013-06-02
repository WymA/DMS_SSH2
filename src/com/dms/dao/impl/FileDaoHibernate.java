package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.FileDao;
import com.dms.dao.UserDao;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.Files;
import com.dms.domain.User;

public class FileDaoHibernate
	extends MyHibernateDaoSupport implements FileDao
{
	
	public Files get(Integer id)
	{
		return getHibernateTemplate()
			.get(Files.class, id); 
	}
	
	public Integer save(Files file)
	{
		return (Integer)getHibernateTemplate()
			.save(file);
	}
	
	public void update(Files file)
	{
		getHibernateTemplate().update(file);
	}

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(Files file)
	{
		getHibernateTemplate().delete(file);
	}
	
	public List<Files> findByName(Integer id)
	{
		return (List<Files>)getHibernateTemplate()
			.find("from Files u where u.id like ?" , id);
	}
	
	public List<Files> findAll()
	{
		return (List<Files>)getHibernateTemplate()
			.find("from Files");
	}

	public List<Files> findByOrg(Org org){
		
		return (List<Files>)getHibernateTemplate()
				.find("select f from Files f join f.org o where o.orgName=?"
						, org.getOrgName() ) ;
	}
}