package com.dms.service;

import java.io.File;
import java.util.List;

import com.dms.domain.Branch;
import com.dms.domain.Files;
import com.dms.domain.Org;
import com.dms.domain.Role;
import com.dms.domain.User;


public interface MgrManager {

	public List<Role> validLogin(User user) ;
	
	public List<Org> getOrgs( ) ;

	public List<User>getUsers(List<Role> lr);
	
	public boolean uploadFile(String fileName, Org org ) ;
	
	public Org getOrgDetail(int id ) ;
	
	public List<User> getOrgMgr(Org org) ;

	public boolean deleteOrg(Org org);

	public List<User> getAllUsers();

	public List<Org> getAllOrgs();
	
	public boolean mgrOfOrg(Org org, User mgr) ;

	public List<Branch> getAllBranch();

	public void userOfOrg(Branch branch, User user);

	public List<Branch> getBranch(Org org );

	public void childOrg(Org parent, Org org);

	public void branchOfOrg(Org parent, Branch branch);

	public List<Role> getUsersRole(List<User> userList);

	public List<User> getUnassignedUsers();

	public List<User> getAssignedUsers();

	public void assignUser(Branch branch, User user);

	public void deleteUser(User user);

	public void lockUser(User user);

	public List<Files> getFilesByOrg(Org org);
}
