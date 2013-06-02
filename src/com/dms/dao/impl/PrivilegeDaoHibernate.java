package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.PrivilegeDao;
import com.dms.dao.RoleDao;
import com.dms.dao.UserDao;
import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;

public class PrivilegeDaoHibernate
	extends MyHibernateDaoSupport implements PrivilegeDao
{
	
	public Privilege get(Integer id)
	{
		return getHibernateTemplate()
			.get(Privilege.class, id); 
	}
   
	public Integer save(Privilege privilege)
	{
		return (Integer)getHibernateTemplate()
			.save(privilege);
	}
	
	public void update(Privilege privilege)
	{
		getHibernateTemplate().update(privilege);
	}
	

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	public void delete(Privilege privilege)
	{
		getHibernateTemplate().delete(privilege);
	}

	public List<Privilege> findByRole(Role role) {
		
		return (List<Privilege>)getHibernateTemplate()
				.find("from Privilege p join p.role r where r.id=?"
						, role.getId());
	}

}