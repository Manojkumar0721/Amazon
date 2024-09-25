package com.tuorsdude.amazon.service;

import com.tuorsdude.amazon.dto.User;
import com.tuorsdude.amazon.repo.AmazonRepoImpl;

public class AmazonServiceImpl implements AmazonService{
	
	AmazonRepoImpl repo = new AmazonRepoImpl();
	User user = new User();

	@Override
	public boolean validateUser(User user) {
		if(user!=null) {
			if(user.getName()!=null) {
				System.out.println("Name is valid");
				if(user.getPassword().length()<8) {
					System.out.println("Password is accepted");
					if(user.getEmail().contains("@") && user.getEmail().contains(".")){
						System.out.println("Email valid");
						if(user.getPhoneNumber()>5999999999l) {
							System.out.println("phone Number is valid");
							return true;
						}
						System.out.println("Phone number is invalid");
						return false;
					}
					System.out.println("Email is invalid becuse it not contail @");
					return false;
				}
				System.out.println("Password is not accepted, its length should be less than 8 charecter");
				return false;
			}
			System.out.println("Name is invalid,null values cannot be taken");
		}
		return false;
	}
	
	@Override
	public boolean validateLoginUser(String email, String password) {
		if(email!=null) {
			if(email.contains("@")&&email.contains(".")) {
				if(password.length()<8) {
					System.out.println("Serching user");
					return true;
				}
				System.out.println("Password invalid");
				return false;
			}
			System.out.println("Email invalid");
			return false;
		}
		System.out.println("You are tring to enter null value");
		return false;
	}
	
	@Override
	public boolean save(User user) {
		if(validateUser(user)) {
			repo.save(user);
			System.out.println("User saved");
			return true;
		}
		System.out.println("User not saved");
		return false;
	}

	@Override
	public User findUserByEmail(String email,String password) {
		if(validateLoginUser(email,password)) {
			User user = repo.findUserByEmail(email);
			if(password.equals(user.getPassword())) {
				System.out.println("Login Successful");
				return user;
			}
			System.out.println("Login faild");
		}
		return null;
	}

	

	

	



	
	
	

}
