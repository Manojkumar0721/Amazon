package com.tuorsdude.amazon.service;

import com.tuorsdude.amazon.dto.User;

public interface AmazonService {

	public boolean validateUser(User user);

	public boolean save(User user);

	public User findUserByEmail(String email,String password);

	public boolean validateLoginUser(String email,String password);

}
