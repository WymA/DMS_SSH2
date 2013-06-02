package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.UserDao;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;

public class UserDaoHibernate
	extends MyHibernateDaoSupport implements UserDao
{
	
	public User get(Integer id)
	{
		return getHibernateTemplate()
			.get(User.class, id); 
	}
	
	public Integer save(User user)
	{
		return (Integer)getHibernateTemplate()
			.save(user);
	}
	
	public void update(User user)
	{
		getHibernateTemplate().update(user);
	}

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(User user)
	{
		getHibernateTemplate().delete(user);
	}
	
	public List<User> findByName(Integer id)
	{
		return (List<User>)getHibernateTemplate()
			.find("from User u where u.id like ?" , id);
	}
	
	public List<User> findAll()
	{
		return (List<User>)getHibernateTemplate()
			.find("from User where id<>1");
	}

	public List<User> findAllByPage( int pageNow, int pageSize ) {
		
		if ( pageNow < 1 ){
			return null ;
		}
		
		int offset = (pageNow-1)*pageSize ;
		return findByPage("from User", offset, pageSize ) ;

	}

	public int getRowCount() {

		return findAll().size() ;
	}

	public List<User> getByNameAndPass(User user) {
		
		return ( List<User>) getHibernateTemplate()
				.find("select u from User u where u.username=? and u.password=?"
						, user.getUsername(), user.getPassword() ) ;
	}

	@Override
	public List<User> findByRole(Role role) {
		
		List<User> listUser = new ArrayList<User>() ;
		
		List<Org> listOrg = (List<Org>)getHibernateTemplate()
		.find("select distinct o from Org o join o.privilege p join p.role r " +
				"where r.id=?"
				, role.getId() );

		for( Org o : listOrg ){
			
			listUser.addAll(
						(List<User>)getHibernateTemplate()
						.find("select distinct u from User u join u.role r join r.privilege " +
								"p join p.org o where o.id=? and u.id<>1"
								, o.getId() )
					) ;
		}
	
		return  listUser ;
	}

	public List<User> getOrgMgr(Org org) {
		
		return (List<User>)getHibernateTemplate()
				.find("select u from User u join u.role r join r.privilege p " +
						"join p.org o where o.id=? and u.id<>1"
						, org.getId()) ;
	}

	@Override
	public User getByName(User user) {
		
		return (User)getHibernateTemplate()
				.find("select u from User u where u.username=?"
						,user.getUsername() )
				.get(0);
	}

	@Override
	public List<User> findUnassignedUsers() {
	
		return (List<User>)getHibernateTemplate()
				.find("select u from User u join u.role r where r.id=6" ) ;
	}

	@Override
	public List<User> findAssignedUsers() {
		
		return (List<User>)getHibernateTemplate()
				.find("select u from User u join u.role r where r.id<>6" ) ;
	}

	@Override
	public User getByName(String username) {
		
		return  (User)getHibernateTemplate()
				.find("select u from User u where u.username=?"
						, username )
				.get(0);
	}

}