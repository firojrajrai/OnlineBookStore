package com.jlc.book.shop.dao;

import java.util.List;

import com.jlc.book.shop.to.OrderTO;

public interface OrderDAO {

	public List getOrderByUserId(String userId);

	public String placeOrder(OrderTO oto, String ip);

	public OrderTO getOrderByOrderId(String orderId);

	public List getAllOrderInfo();

	public void updateStatus(String orderId, String status);

}
