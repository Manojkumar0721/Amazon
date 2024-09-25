package com.tuorsdude.amazon.repo;

import com.tuorsdude.amazon.dto.User;
import com.tuorsdude.amazon.utils.DbUtils;

public interface AmazonRepo {
	
	DbUtils dbutils = new DbUtils();
	
	public boolean save(User user);
	
	public User findUserByEmail(String email);
		
	

}
