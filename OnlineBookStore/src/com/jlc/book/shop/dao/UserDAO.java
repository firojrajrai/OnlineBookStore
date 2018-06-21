package com.jlc.book.shop.dao;

import com.jlc.book.shop.to.UserTO;

public interface UserDAO {

	UserTO verifyUser(String username, String password);

	boolean alreadyExist(String username);

	boolean registerUser(UserTO uto);

	UserTO changePassword(UserTO usto, String password);

	UserTO getUserInfoById(String userId);

	boolean updateUserInfo(String userId, String email, long phone);

	


}
