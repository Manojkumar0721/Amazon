package com.tuorsdude.amazon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String name;
	private String address;
	private long phoneNumber;
	private String email;
	private String confirmPassword;

}
