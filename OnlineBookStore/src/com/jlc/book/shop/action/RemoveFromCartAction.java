package com.jlc.book.shop.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.book.shop.to.BookTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class RemoveFromCartAction {

	public String removeFromCart(HttpServletRequest request,
			HttpServletResponse response) {
		String page="showCartDef.jsp";
		String bid=request.getParameter("bookId");
		
		if(!JLCDataValidator.validateRequired(bid)){
			request.setAttribute("bookId", "Please Select Book To Remove");
		}else{
			int bookId = Integer.parseInt(bid);
			HttpSession sess=request.getSession();
			Object obj = sess.getAttribute("SELECTED_BOOK_LIST");
			Set selectedBookList=null;
			BookTO bto = null;
			if(obj!=null){
				selectedBookList = (Set)obj;
				Iterator it = selectedBookList.iterator();
				while(it.hasNext()){
					BookTO bookTO =(BookTO)it.next();
					if(bookTO.getBookId()==bookId){
						bto=bookTO;
						it.remove();
						break;
					}
				}
				
			if(selectedBookList.size()>0){
				sess.setAttribute("SELECTED_BOOK_LIST",selectedBookList);
			}else{
				sess.removeAttribute("SELECTED_BOOK_LIST");
				request.setAttribute("REMOVED_TOTAL", "Book Removed from Cart. No Books available in cart");
			}
			request.setAttribute("REMOVED_BOOK", bto);
			}
		}
		
		return page;
	}

}
