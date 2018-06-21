package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.BookDelegate;
import com.jlc.book.shop.to.BookTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class AddBookAction {

	public String addBookInfo(HttpServletRequest request,HttpServletResponse response) {
		String page="addBookDef.jsp";
		String bnm = request.getParameter("bname");
		String author = request.getParameter("author");
		String cost=request.getParameter("cost");
		String pub = request.getParameter("publication");
		String edi=request.getParameter("edition");
		float bcost=0.0f;
		boolean convertCost=true;
		boolean interactWithDB=true;
		
		//VALIDATING BOOK NAME*****************
		if(!JLCDataValidator.validateRequired(bnm)){
			request.setAttribute("bname", "Book Name is required");
			interactWithDB=false;
		}else if(!JLCDataValidator.minLength(bnm, 3)){
			request.setAttribute("bname", "Book Name must be minimum 3 characters");
			interactWithDB=false;
		}else if(!JLCDataValidator.maxLength(bnm, 60)){
			request.setAttribute("bname", "Book Name must be maximum 60 characters");
			interactWithDB=false;
		}
		
		//VALIDATING AUTHOR NAME*****************
				if(!JLCDataValidator.validateRequired(author)){
					request.setAttribute("author", "Author Name is required");
					interactWithDB=false;
				}else if(!JLCDataValidator.minLength(author, 3)){
					request.setAttribute("author", "Author Name must be minimum 3 characters");
					interactWithDB=false;
				}else if(!JLCDataValidator.maxLength(bnm, 50)){
					request.setAttribute("author", "Author Name must be maximum 50 characters");
					interactWithDB=false;
				}
				
		if(!JLCDataValidator.validateRequired(cost)){
			request.setAttribute("cost", "Cost is required");
			interactWithDB = false;
			convertCost = false;
		}
		
		if(!JLCDataValidator.validateRequired(edi)){
			request.setAttribute("edition", "Edition is required");
			interactWithDB = false;
		}
		
		if(!JLCDataValidator.validateRequired(pub)){
			request.setAttribute("publication", "Publication is required");
			interactWithDB = false;
		}else if(!JLCDataValidator.minLength(pub, 3)){
			request.setAttribute("publication", "Publication must be minimum 3 characters");
			interactWithDB = false;
		}else if(!JLCDataValidator.maxLength(pub,50)){
			request.setAttribute("publication", "Publication must be maximum 50 characters");
			interactWithDB=false;
		}
		
		if(convertCost){
			try{
				bcost=Float.parseFloat(cost);
			}catch(NumberFormatException e){
				request.setAttribute("cost", "Cost is invalid");
				interactWithDB= false;
			}
		}
		
		if(interactWithDB){
			BookTO bto = new BookTO(bnm,author,pub,edi,bcost);
			
			if(BookDelegate.alreadyExist(bto)){
				request.setAttribute("addingBookError", "Book Information is already available");
			}else{
				boolean added=BookDelegate.addBook(bto);
				if(added){
					request.setAttribute("addingBookError", "Book information added Successfully");
					request.setAttribute("SHOW_ADD_BOOK", "OK");
				}else{
					request.setAttribute("addingBookError", "Error in adding book information");
				}
			}
		}
		return page;
	}

}
