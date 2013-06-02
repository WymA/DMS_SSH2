package com.dms.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.*;

import com.common.hsupport.MyHibernateDaoSupport;
import com.dms.dao.BranchDao;
import com.dms.dao.OrgDao;
import com.dms.dao.UserDao;
import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;

public class BranchDaoHibernate
	extends MyHibernateDaoSupport implements BranchDao
{
	
	public Branch get(Integer id)
	{
		return getHibernateTemplate()
			.get(Branch.class, id); 
	}
	
	public Integer save(Branch branch)
	{
		return (Integer)getHibernateTemplate()
			.save(branch);
	}
	
	public void update(Branch branch)
	{
		getHibernateTemplate().update(branch);
	}

	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(Branch branch)
	{
		getHibernateTemplate().delete(branch);
	}
	
	public List<Branch> findByName(Integer id)
	{
		return (List<Branch>)getHibernateTemplate()
			.find("from Branch u where u.id like ?" , id);
	}
	
	public List<Branch> findAll()
	{
		return (List<Branch>)getHibernateTemplate()
			.find("from Branch");
	}

	public List<Branch> findAllByPage( int pageNow, int pageSize ) {
		
		if ( pageNow < 1 ){
			return null ;
		}
		
		int offset = (pageNow-1)*pageSize ;
		return findByPage("from Branch", offset, pageSize ) ;

	}

	public int getRowCount() {

		return findAll().size() ;
	}

	@Override
	public Branch getByName(Branch branch) {
		
		return (Branch) getHibernateTemplate()
				.find("select b from Branch b where b.branchName=?"
						, branch.getBranchName() )
				.get(0);
	}

	@Override
	public List<Branch> findAllByOrg(Org org) {
		
		return (List<Branch>)getHibernateTemplate()
				.find("select b from Branch b join b.org o where o.id=?"
						, org.getId() );
	}

	@Override
	public Branch getByUser(User user) {
		
		return (Branch)getHibernateTemplate()
				.find("select b from Branch b join b.users u where u.id=?"
						, user.getId() )
				.get(0);
	}

}