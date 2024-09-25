package com.tuorsdude.amazon;

import java.util.Scanner;

import com.tuorsdude.amazon.dto.User;
import com.tuorsdude.amazon.service.AmazonService;
import com.tuorsdude.amazon.service.AmazonServiceImpl;

import lombok.Data;

@Data
public class AmazonManagement {
	
	AmazonService service = new AmazonServiceImpl();

	public static void main(String[] args) {

		AmazonManagement amazonManagement = new AmazonManagement();
		amazonManagement.welcome();
		

	}

	public boolean welcome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome To Amazon");
		System.out.println("1.Register");
		System.out.println("2.Login");
		int id = scanner.nextInt();
		if (id == 1) {
			registration();
			return true;
		}
		if (id == 2) {
			logIn();
			return true;
		}
		System.out.println("You Enterd invalid option");
		return false;
	}

	public void registration() {
		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Complete the Registration Form :");
		System.out.println("Enter Name :");
		String name = scanner.nextLine();
		System.out.println("Enter Address : ");
		String address = scanner.nextLine();
		System.out.println("Enter Phone Number : ");
		long phoneNumber = scanner.nextLong();
		System.out.println("Enter Email : ");
		String email = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		User user = new User(name,address,phoneNumber,email,password);
		boolean saveUser = service.save(user);
		System.out.println(saveUser);
		
	}
	

	public  void logIn() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Complete the Login Form");
		System.out.println("Enter Email : ");
		String email = scanner.nextLine();
		System.out.println("Enter Password :");
		String password = scanner.nextLine();
		User loginUser = new User(email,password);
		
		User result = service.findUserByEmail(email,password);
		System.out.println(result);

	}

	public  void registerdDetails(String name, String address, long phoneNumber,String email, String password) {
		System.out.println("Name : " + name);
		System.out.println("Address : " + address);
		System.out.println("Phone Number : " + phoneNumber);
		System.out.println("Email : " + email);
		System.out.println("Password : " + password);
	}

	public  void logInDetails(String email, String password) {
		System.out.println("Email : " + email);
		System.out.println("Password : " + password);
	}

}
