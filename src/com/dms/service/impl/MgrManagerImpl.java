package com.dms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dms.inter.*;
import com.dms.dao.BranchDao;
import com.dms.dao.FileDao;
import com.dms.dao.OrgDao;
import com.dms.dao.PrivilegeDao;
import com.dms.dao.RoleDao;
import com.dms.dao.UserDao;
import com.dms.domain.Branch;
import com.dms.domain.Files;
import com.dms.domain.Org;
import com.dms.domain.Privilege;
import com.dms.domain.Role;
import com.dms.domain.User;
import com.dms.service.MgrManager;

public class MgrManagerImpl implements MgrManager{

	BranchDao branchDao ;
	OrgDao orgDao ;
	PrivilegeDao privilegeDao ;
	RoleDao roleDao ;
	UserDao userDao ;
	FileDao fileDao ;
	
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
	
	public List<Role> validLogin(User user) {
		
		List<User> lu = userDao.getByNameAndPass(user) ;
		User u = null ;
		
		if ( lu.size() >= 1 ){
			
			u = lu.get(0) ;
			
		}else {
			
			return null ;
		}
		
								
		if ( u != null ){
			
			return roleDao.findByUser(u) ; 
		}
		
		return null ;
	}
	
	@Override
	public List<Org> getOrgs( ) {
		
		List<Org> lo = orgDao.findAll() ;
				
		return lo ;
	}

	public List<User> getUsers(List<Role> lr) {
		
		System.out.println(lr.size()) ;
		
		List<User> lu = new ArrayList<User>() ;
		
		for( Role role : lr ) {
			
			lu.addAll(userDao.findByRole(role)) ;
		}
		
		return lu ;
	}
	@Override
	public boolean uploadFile(String fileName, Org org ) {
		
		org = orgDao.get(org.getId()) ;
				
		Files file = new Files() ;
		file.setFileName(fileName) ;
		
		file.setOrg(org) ;
				
		fileDao.save(file) ;
		
		return true ;
	}

	public Org getOrgDetail(int id) {
		
		return orgDao.get(id) ;
	}

	public List<User> getOrgMgr(Org org) {
		
		return userDao.getOrgMgr(org) ;
	}

	
	public boolean deleteOrg(Org org) {
		
		org = orgDao.get(org.getId()) ;
		orgDao.delete(org) ;
		return true ;
	}
	@Override
	public List<User> getAllUsers() {
		
		return userDao.findAll();
	}
	@Override
	public List<Org> getAllOrgs() {
		
		return orgDao.findAll() ;
	}
	
	@Override
	public boolean mgrOfOrg(Org org, User mgr) {
		
		roleDao.addMgr(org, mgr) ;
		
		return false;
	}
	
	@Override
	public List<Branch> getAllBranch() {
				
		return branchDao.findAll();
	}
	@Override
	public void userOfOrg(Branch branch, User user) {
		
		Branch b = branchDao.getByName(branch) ;
		User u = userDao.getByName(user) ;
		
		Set<Role> lr = u.getRole() ;
		u.setBranch(b) ;
		Org o = b.getOrg() ;
		
		u.setOrg(o) ;
		
		//Role rUnassigned = null ;
		Role rAssigned = roleDao.get(WebConst.COMMON_ROLE) ;
		for ( Role tmpRole : lr ){
			
			if ( tmpRole.getId() == WebConst.UNASSIGNED_ROLE )
				lr.remove(tmpRole)  ;
		}
		
		lr.add(rAssigned) ;
		u.setRole(lr) ;

		userDao.update(u) ;
		
		return ;
	}
	@Override
	public List<Branch> getBranch( Org org ) {
		
		return branchDao.findAllByOrg(org) ;
	}
	
	@Override
	public void childOrg(Org parent, Org org) {

		parent = orgDao.get(parent.getId()) ;		
		parent.getChildOrgs().add(org) ;
		orgDao.update(parent) ;

		org.setParentOrg(parent) ;
		orgDao.save(org) ;
		
/////////////////////////////////////////////////////////////////////////			
		
		Privilege pri = new Privilege() ;
		pri.setPriName(org.getOrgName()+"管理权限") ;		
		pri.getOrg().add(org) ;	
		privilegeDao.save(pri) ;
	
/////////////////////////////////////////////////////////////////////////		
		Role role = new Role() ;
		role.setRolename(org.getOrgName()+"管理员") ;
		role.getPrivilege().add(pri) ;

		roleDao.save(role) ;

		return ;
	}
	@Override
	public void branchOfOrg(Org parent, Branch branch) {
		
		parent = orgDao.get(parent.getId()) ;
		branch.setOrg(parent) ;
		branchDao.save(branch) ;

		////////////////////////////////////////////////////////
		Privilege pri = new Privilege() ;
		pri.setPriName(branch.getBranchName()+"管理权限") ;	
		pri.getBranch().add(branch) ;
		privilegeDao.save(pri) ;
		
		////////////////////////////////////////////////////////
		Role role = new Role() ;
		role.setRolename(branch.getBranchName()+"管理员") ;
		role.getPrivilege().add(pri) ;
		roleDao.save(role) ;
		
		return ;	
	}
	
	@Override
	public List<Role> getUsersRole(List<User> userList) {

		List<Role> lr = new ArrayList<Role>() ;
		
		for ( User u : userList){
			
			lr.add( roleDao.findByUser(u).get(0) );
		}
		
		return lr;
	}
	
	@Override
	public List<User> getUnassignedUsers() {
		
		
		return userDao.findUnassignedUsers();
	}
	@Override
	public List<User> getAssignedUsers() {
		
		return userDao.findAssignedUsers();
	}
	@Override
	public void assignUser(Branch branch, User user) {

		branch = branchDao.get(branch.getId()) ;
		Set<User> users = new HashSet<User>() ;
		users.add(user) ;
		branch.setUsers(users) ;
		branchDao.update(branch) ;
		
		Role role = roleDao.get(5) ;
		Set<Role> roles = new HashSet<Role>() ;
		roles.add(role) ;
		user.setRole(roles) ;
		userDao.update(user) ;
		
		return ;
	}
	@Override
	public void deleteUser(User user) {

		userDao.delete(user) ;
		
		return ;
	}
	@Override
	public void lockUser(User user) {
		
		return ;
	}
	@Override
	public List<Files> getFilesByOrg(Org org) {
				
		return fileDao.findByOrg(org);
	}
	
	
	public FileDao getFileDao() {
		return fileDao;
	}
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
}
