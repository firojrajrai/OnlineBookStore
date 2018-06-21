package com.jlc.book.shop.delegate;

import java.util.List;

import com.jlc.book.shop.dao.OrderDAO;
import com.jlc.book.shop.factory.DAOFactory;
import com.jlc.book.shop.to.OrderTO;

public class OrderDelegate {
	private static OrderDAO orderDAO= null;
	static{
		orderDAO= DAOFactory.getOrderDAO();
	}
	public static List getOrderByUserId(String userId) {
		return orderDAO.getOrderByUserId(userId);
	}
	public static String placeOrder(OrderTO oto, String ip) {
		// TODO Auto-generated method stub
		return orderDAO.placeOrder(oto,ip);
	}
	public static OrderTO getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderByOrderId(orderId);
	}
	public static List getAllOrderInfo() {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrderInfo();
	}
	public static void updateStatus(String orderId, String status) {
		// TODO Auto-generated method stub
		orderDAO.updateStatus(orderId,status);
	}

}
