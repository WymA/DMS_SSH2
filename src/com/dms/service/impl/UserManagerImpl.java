package com.dms.service.impl;

import java.util.List;

import com.dms.dao.BranchDao;
import com.dms.dao.FileDao;
import com.dms.dao.OrgDao;
import com.dms.dao.PrivilegeDao;
import com.dms.dao.RoleDao;
import com.dms.dao.UserDao;
import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;
import com.dms.service.UserManager;

public class UserManagerImpl implements UserManager {

	BranchDao branchDao ;
	OrgDao orgDao ;
	PrivilegeDao privilegeDao ;
	RoleDao roleDao ;
	UserDao userDao ;
	FileDao fileDao ;
	
	public FileDao getFileDao() {
		return fileDao;
	}
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	public BranchDao getBranchDao() {
		return branchDao;
	}
	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}
	public OrgDao getOrgDao() {
		return orgDao;
	}
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}
	public PrivilegeDao getPrivilegeDao() {
		return privilegeDao;
	}
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User getByName(String username) {
	
		return userDao.getByName(username);
	}
	@Override
	public Org getOrgDetail(int id) {
		
		return orgDao.get(id);
	}
	@Override
	public User getOrgMgr(Org org) {
		
		List<User> lu = userDao.getOrgMgr(org) ;
		return lu.get(lu.size()-1);
	}
	@Override
	public List<Org> getAllOrg() {
		
		return orgDao.findAll();
	}
	@Override
	public Branch getBranchByUser(User user) {
		
		return branchDao.getByUser(user) ;
	}
}
