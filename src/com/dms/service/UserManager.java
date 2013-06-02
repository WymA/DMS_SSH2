package com.dms.service;

import java.util.List;

import com.dms.dao.*;
import com.dms.domain.Branch;
import com.dms.domain.Org;
import com.dms.domain.User;

public interface UserManager {

	User getByName( String username)  ;

	Org getOrgDetail(int id);

	User getOrgMgr(Org org);

	List<Org> getAllOrg();

	Branch getBranchByUser(User user);
	
	
}
