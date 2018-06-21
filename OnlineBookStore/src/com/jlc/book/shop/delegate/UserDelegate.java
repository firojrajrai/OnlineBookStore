package com.jlc.book.shop.delegate;

import com.jlc.book.shop.dao.UserDAO;
import com.jlc.book.shop.factory.DAOFactory;
import com.jlc.book.shop.to.UserTO;

public class UserDelegate {
	private static UserDAO userDAO=null;
	static{
		userDAO = DAOFactory.getUserDAO();
	}
	public static UserTO verifyUser(String username, String password) {
		return userDAO.verifyUser(username,password);
	}
	public static boolean alreadyExist(String username) {
		
		return userDAO.alreadyExist(username);
	}
	public static boolean registerUser(UserTO uto) {
		return userDAO.registerUser(uto);
	}
	public static UserTO changePassword(UserTO usto, String password) {
		return userDAO.changePassword(usto,password);
	}
	public static UserTO getUserInfoById(String userId) {
		return userDAO.getUserInfoById(userId);
	}
	public static boolean updateUserInfo(String userId, String email,
			long phone) {
		return userDAO.updateUserInfo(userId,email,phone);
	}
	
}
