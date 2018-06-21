package com.jlc.book.shop.delegate;

import java.util.List;

import com.jlc.book.shop.dao.BookDAO;
import com.jlc.book.shop.factory.DAOFactory;
import com.jlc.book.shop.to.BookTO;

public class BookDelegate {

	private static BookDAO bookDAO = null;
	static{
		bookDAO=DAOFactory.getBookDAO();
	}
	public static boolean alreadyExist(BookTO bto) {
		return bookDAO.alreadyExist(bto);
	}

	public static boolean addBook(BookTO bto) {
		return bookDAO.addBook(bto);
	}

	public static List searchBook(BookTO bto, int start, int noBook) {
		return bookDAO.searchBook(bto, start, noBook);
		
	}

	public static int getTotalNumberOfBook(BookTO bto) {
		return bookDAO.getTotalNumberOfBook(bto);
	}

	public static boolean deleteBook(int bookId) {
		return bookDAO.deleteBook(bookId);
	}

	public static BookTO getBookById(String bid) {
		return bookDAO.getBookById(bid);
	}

}
