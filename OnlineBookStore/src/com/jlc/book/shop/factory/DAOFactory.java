package com.jlc.book.shop.factory;

import com.jlc.book.shop.dao.BookDAO;
import com.jlc.book.shop.dao.OrderDAO;
import com.jlc.book.shop.dao.UserDAO;
import com.jlc.book.shop.dao.impl.JDBCBookDAO;
import com.jlc.book.shop.dao.impl.JDBCOrderDAO;
import com.jlc.book.shop.dao.impl.JDBCUserDAO;

public class DAOFactory {
private static UserDAO userDAO = null;
private static BookDAO bookDAO = null;
private static OrderDAO orderDAO = null;
static{
	userDAO=new JDBCUserDAO();
	bookDAO = new JDBCBookDAO();
	orderDAO = new JDBCOrderDAO();
}
	public static UserDAO getUserDAO() {
		return userDAO;
	}
	public static BookDAO getBookDAO() {
		return bookDAO;
	}
	public static OrderDAO getOrderDAO() {
		// TODO Auto-generated method stub
		return orderDAO;
	}

}
