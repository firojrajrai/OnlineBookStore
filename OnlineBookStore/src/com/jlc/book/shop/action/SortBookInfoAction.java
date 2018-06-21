package com.jlc.book.shop.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.to.BookTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class SortBookInfoAction {

	public String sortBookInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String page = "searchBookDef.jsp";
		String field = request.getParameter("field");
		String order = request.getParameter("order");
		request.setAttribute("ORDER", order);
		request.setAttribute("FIELD", field);
		boolean sort = true;
		if(!JLCDataValidator.validateRequired(field) && !JLCDataValidator.validateRequired(order)){
			request.setAttribute("sortingError", "Select Field and Order to Sort");
			sort=false;
		}else if(!JLCDataValidator.validateRequired(field)){
			request.setAttribute("sortingError", "Select Field to sort");
			sort = false;
		}else if(!JLCDataValidator.validateRequired(order)){
			request.setAttribute("sortingError", "Select Order to Sort");
			sort = false;
		}if(sort){
			Object obj = request.getSession().getAttribute("BOOK_LIST");
			if(obj!=null){
				List bookList = (List)obj;
				Collections.sort(bookList, getComparator(field,order));
				request.getSession().setAttribute("BOOK_LIST", bookList);
			}
		}
		return page;
	}

	private Comparator getComparator(String field, String order) {
		Comparator comp = null;
		if(field.equals("bname")){
			comp= new BookNameComparator(order);
		}else if(field.equals("author")){
			comp= new AuthorComparator(order);
		}else if(field.equals("publication")){
			comp = new PublicationComparator(order);
		}else if(field.equals("edition")){
			comp = new EditionComparator(order);
		}else if(field.equals("cost")){
			comp = new CostComparator(order);
		}
		return comp;
	}

}

//BOOKNAME COMPARATOR
class BookNameComparator implements Comparator{
	private String order;
	BookNameComparator(String order){
		this.order=order;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
	BookTO bto1=(BookTO)o1;
	BookTO bto2 = (BookTO)o2;
	if(order.equals("asc")){
		return bto1.getBookName().compareTo(bto2.getBookName());
	}else{
		return bto2.getBookName().compareTo(bto1.getBookName());
	}
	}
}

//AUTHOR COMPARATOR
class AuthorComparator implements Comparator{
	String order = null;
	
	public AuthorComparator(String order) {
		this.order = order;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
	BookTO bto1 = (BookTO)o1;
	BookTO bto2 = (BookTO)o2;
	if(order.equals("asc")){
		return bto1.getAuthor().compareTo(bto2.getAuthor());
	}else{
		return bto2.getAuthor().compareTo(bto1.getAuthor());
	}
	}
}

//PUBLICATION COMPARATOR

class PublicationComparator implements Comparator{
	String order = null;
	PublicationComparator(String order){
		this.order = order;
	}
	@Override
	public int compare(Object o1, Object o2) {
	BookTO bto1 = (BookTO)o1;
	BookTO bto2 = (BookTO)o2;
	if(order.equals("asc")){
		return bto1.getPublication().compareTo(bto2.getPublication());
	}else{
		return bto2.getPublication().compareTo(bto1.getPublication());
	}
	}
}

//EDITION COMPARATOR

class EditionComparator implements Comparator{
	String order=null;
	public EditionComparator(String order) {
		this.order=order;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
	BookTO bto1 = (BookTO)o1;
	BookTO bto2 = (BookTO)o2;
	if(order.equals("asc")){
		return bto1.getEdition().compareTo(bto2.getEdition());
	}else{
		return bto2.getEdition().compareTo(bto1.getEdition());
	}
	}
}

//COST COMPARATOR

class CostComparator implements Comparator{
	String order = null;
	public CostComparator(String order){
		this.order=order;
	}
	@Override
	public int compare(Object o1, Object o2) {
		BookTO bto1 = (BookTO)o1;
		BookTO bto2 = (BookTO)o2;
		if(order.equals("asc")){
			return (int)(bto1.getCost()-bto2.getCost());
		}else{
			return (int)(bto2.getCost()-bto1.getCost());
		}
	}
}


