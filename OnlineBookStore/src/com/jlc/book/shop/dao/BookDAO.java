package com.jlc.book.shop.dao;

import java.util.List;

import com.jlc.book.shop.to.BookTO;

public interface BookDAO {

	boolean alreadyExist(BookTO bto);

	boolean addBook(BookTO bto);

	List searchBook(BookTO bto,int start,int numberOfBooks);

	int getTotalNumberOfBook(BookTO bto);

	boolean deleteBook(int bookId);

	BookTO getBookById(String bid);

}
