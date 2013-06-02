package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.OrgDao;
import com.dms.dao.UserDao;
import com.dms.domain.Org;
import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;

public class OrgDaoHibernate
	extends MyHibernateDaoSupport implements OrgDao
{
	
	public Org get(Integer id)
	{
		return getHibernateTemplate()
			.get(Org.class, id); 
	}
	
	public Integer save(Org org)
	{
		return (Integer)getHibernateTemplate()
			.save(org);
	}
	
	public void update(Org org)
	{
		getHibernateTemplate().update(org);
	}

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(Org org)
	{
		getHibernateTemplate().delete(org);
	}
	
	public List<Org> findByName(Integer id)
	{
		return (List<Org>)getHibernateTemplate()
			.find("from Org u where u.id like ?" , id);
	}
	
	public List<Org> findAll()
	{
		return (List<Org>)getHibernateTemplate()
			.find("from Org");
	}

	public List<Org> findAllByPage( int pageNow, int pageSize ) {
		
		if ( pageNow < 1 ){
			return null ;
		}
		
		int offset = (pageNow-1)*pageSize ;
		return findByPage("from Org", offset, pageSize ) ;

	}

	public int getRowCount() {

		return findAll().size() ;
	}
	
	public List<Org> findByRole(Role role) {

		return  (List<Org>)getHibernateTemplate()
				.find("select o from Org o join o.privilege p join p.role r where r.id=?"
						, role.getId() );
	}

}