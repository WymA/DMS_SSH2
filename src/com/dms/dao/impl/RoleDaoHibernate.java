package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.RoleDao;
import com.dms.dao.UserDao;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;

public class RoleDaoHibernate
	extends MyHibernateDaoSupport implements RoleDao
{
	
	public Role get(Integer id)
	{
		return getHibernateTemplate()
			.get(Role.class, id); 
	}
   
	public Integer save(Role role)
	{
		return (Integer)getHibernateTemplate()
			.save(role);
	}
	
	public void update(Role role)
	{
		getHibernateTemplate().update(role);
	}
	

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	public void delete(Role role)
	{
		getHibernateTemplate().delete(role);
	}

	public List<Role> findByUser(User user) {
		
		return (List<Role>)getHibernateTemplate()
				.find("select r from Role as r join r.user u where u.id=?"
						, user.getId() ) ;
	}
	
	public Integer addMgr(Org org, User mgr ){
		
		Role role = (Role)getHibernateTemplate()
				.find("select r from Role as r join r.privilege p join p.org o where o.id=?"
						, org.getId()) 
				.get(1);
		
		User user = (User)getHibernateTemplate()
				.find("select u from User as u where u.username=?"
						, mgr.getUsername() ) 
				.get(0);
		
		Set<User> su = new HashSet<User>() ;
		su = role.getUser() ;
		
		su.add(user) ;
		role.setUser(su) ;
		
		return (Integer)getHibernateTemplate().save(role) ;		
	}

	@Override
	public Role getByName( Role role ) {

		return (Role)getHibernateTemplate()
				.find("from Role where rolename=?"
						, role.getRolename() )
				.get(0) ;
	}

}