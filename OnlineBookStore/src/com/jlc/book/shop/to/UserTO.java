package com.jlc.book.shop.to;

import java.io.Serializable;

public class UserTO implements Serializable{
private String userId;
private String firstName;
private String middleName;
private String lastName;
private String email;
private long phone;
private String loginId;
private String username;
private String password;
private String role;

public UserTO(String fName, String mName, String lName, String eml, long phn,String unm, String pwd, String role) {
	super();
	this.firstName = fName;
	this.middleName = mName;
	this.lastName = lName;
	this.email = eml;
	this.phone = phn;
	this.username = unm;
	this.password = pwd;
	this.role = role;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getLoginId() {
	return loginId;
}
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
