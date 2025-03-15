package com.data;

public class User {
private String firstname;
private String lastname;
private String mobile;
private String gender;
private String email;
private String password;
private int failedcount;
private String accountstatus;

public User(String firstname, String lastname, String mobile, String gender, String email, String password,
		int failedcount, String accountstatus) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.mobile = mobile;
	this.gender = gender;
	this.email = email;
	this.password = password;
	this.failedcount = failedcount;
	this.accountstatus = accountstatus;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getFailedcount() {
	return failedcount;
}

public void setFailedcount(int failedcount) {
	this.failedcount = failedcount;
}

public String getAccountstatus() {
	return accountstatus;
}

public void setAccountstatus(String accountstatus) {
	this.accountstatus = accountstatus;
}

@Override
public String toString() {
	return "User [firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile + ", gender=" + gender
			+ ", email=" + email + ", password=" + password + ", failedcount=" + failedcount + ", accountstatus="
			+ accountstatus + "]";
}


}
