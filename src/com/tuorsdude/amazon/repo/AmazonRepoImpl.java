package com.tuorsdude.amazon.repo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.tuorsdude.amazon.dto.User;
import com.tuorsdude.amazon.utils.DbUtils;

public class AmazonRepoImpl implements AmazonRepo{
	
	@Override
	public boolean save(User user) {
		
		Connection connection = DbUtils.getConnection();
		
		String insertQuery = "insert into user(name,address,phone_Number,email,password,created_by,created_on) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			LocalDate date = LocalDate.now();
			
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2, user.getAddress());
			preparedStatement.setLong(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5,user.getPassword());
			preparedStatement.setString(6,user.getEmail());
			preparedStatement.setObject(7, date);
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			System.out.println(rowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User findUserByEmail(String email) {
		Connection connection = DbUtils.getConnection();
		
		String findQuery = "select * from user where email = ?;";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
			
			preparedStatement.setString(1, email);
			
			ResultSet rset = preparedStatement.executeQuery();
			
			User user = new User();
			
			if(rset.next()) {
				user.setName(rset.getString("Name"));
				user.setAddress(rset.getString("Address"));
				user.setPhoneNumber(rset.getLong("Phone_Number"));
				user.setEmail(rset.getString("Email"));
				user.setPassword(rset.getString("Password"));
				
			}
			return user;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}



}
