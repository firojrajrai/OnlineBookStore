package com.jlc.book.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.book.shop.delegate.BookDelegate;
import com.jlc.book.shop.to.BookTO;
import com.jlc.book.shop.util.BookUtil;

public class PreviousAction {

	public String searchBookInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String page = "searchBookDef.jsp";
		HttpSession sess = request.getSession();
		String bnm = sess.getAttribute("BOOK_NAME").toString();
		String author = sess.getAttribute("AUTHOR").toString();
		String pub = sess.getAttribute("PUBLICATION").toString();
		String edi = sess.getAttribute("EDITION").toString();
		int start = Integer.parseInt(sess.getAttribute("START").toString());
		String str = sess.getAttribute("COST").toString();
		float bcost = 0.0f;
		if(str.length()>0)
			bcost = Float.parseFloat(str);
		BookTO bto = new BookTO(bnm,author,pub,edi,bcost);
		int total=BookDelegate.getTotalNumberOfBook(bto);
		int noBook = BookUtil.NUMBER_OF_BOOK;
		
		if(start>0){
			start = start-noBook;
		}else{
			start=0;
		}
		int end = start+noBook;
		sess.setAttribute("START", new Integer(start));
		sess.setAttribute("TOTAL", new Integer(total));
		sess.setAttribute("END", new Integer(end));
		List bookList = new BookDelegate().searchBook(bto, start, noBook);
		sess.setAttribute("BOOK_LIST", bookList);
		return page;
	}

}
