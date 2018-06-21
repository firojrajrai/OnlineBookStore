package com.jlc.book.shop.to;

import java.util.Set;

public class OrderTO {
private String orderId;
private String address;
private String street;
private String city;
private String state;
private String country;
private String zip;
private String cardNo;
private String expDate;
private float totalAmount;
private int totalItem;
private String userId;
private String orderDate;
private int orderItemId;
private Set orderItemList;
private String status;
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public String getExpDate() {
	return expDate;
}
public void setExpDate(String expDate) {
	this.expDate = expDate;
}
public float getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(float totalAmount) {
	this.totalAmount = totalAmount;
}
public int getTotalItem() {
	return totalItem;
}
public void setTotalItem(int totalItem) {
	this.totalItem = totalItem;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public int getOrderItemId() {
	return orderItemId;
}
public void setOrderItemId(int orderItemId) {
	this.orderItemId = orderItemId;
}
public Set getOrderItemList() {
	return orderItemList;
}
public void setOrderItemList(Set orderItemList) {
	this.orderItemList = orderItemList;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
