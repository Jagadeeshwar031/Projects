package com.service;

import java.util.*;

import com.data.User;


public class UserService {
	private List<User> users;
	private Map<String, Integer> userInvalidLoginAttempt;
	
	public UserService(List<User> users, Map<String, Integer> userInvalidLoginAttempt) {
		this.users = users;
		this.userInvalidLoginAttempt = userInvalidLoginAttempt;
	}
	
	public void registerNewAdmin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n New Admin Registration");
		
		System.out.println("\n Enter your first name: ");
		String firstname = scanner.nextLine();
		
		System.out.println("\n Enter your last name: ");
		String lastname = scanner.nextLine();
		
		System.out.println("\n Enter your MobileNumber: ");
		String mobile = scanner.nextLine();
		
		System.out.println("\n Enter your gender: ");
		String gender = scanner.nextLine();
		
		System.out.println("\n Enter your Email_ID: ");
		String email = scanner.nextLine();
		
		System.out.println("\n Enter your password: ");
		String password = scanner.nextLine();
		
		if(UserExists(email)) {
			System.out.println("User with "+email+" exists");
		}
		
		User newuser = new User(firstname, lastname, mobile, gender, email, password, 0, "Active");
		users.add(newuser);
		System.out.println("\n Registration Successful....");
		
	}
	private boolean UserExists(String email) {
		for(User user : users) {
			if(user.getEmail().equals(email)) return true;
		}
		return false;
	}
	public User login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n User Login");
		
		System.out.println("\n Enter your Email_ID: ");
		String email = scanner.nextLine();
		
		System.out.println("\n Enter your password: ");
		String password = scanner.nextLine();
		
		for(User user: users) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				int existingcount = userInvalidLoginAttempt.getOrDefault(email, 0);
				if(existingcount >= 5) {
					System.out.println("Account locked due to multiple attempts..");
					return null;
				}
				if(user.getPassword().equals(password)) {
					System.out.println("\n Login Successfull...");
					userInvalidLoginAttempt.put(email, 0);
				}
				else {
					userInvalidLoginAttempt.put(email, existingcount+1);
					System.out.println("\n Invalid password. Attempt: "+existingcount+" for email "+email);
				}
				
			}
		}
		
		System.out.println("No user found");
		return null;
		
	}

}
