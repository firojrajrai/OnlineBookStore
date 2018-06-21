package com.jlc.book.shop.tags;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.jlc.book.shop.util.DoubleFormator;

public class BookAmountTag extends TagSupport{
private String value;
private String quantity;
Logger log = Logger.getLogger(this.getClass());
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}

@Override
	public int doEndTag() throws JspException {
	try{
	Writer out = pageContext.getOut();
	String st = DoubleFormator.formatDouble(value);
	Object obj1= pageContext.getAttribute("TOTAL_BOOK_AMOUNT",PageContext.SESSION_SCOPE);
	Object obj2= pageContext.getAttribute("TOTAL_BOOK_QUANTITY",PageContext.SESSION_SCOPE);
	if(obj1 !=null){
		Double d = (Double)obj1;
		double d1 = Double.parseDouble(st);
		double d2 = d.doubleValue()+d1;
		pageContext.setAttribute("TOTAL_BOOK_AMOUNT", new Double(d2),PageContext.SESSION_SCOPE);
	}else{
		Double d = new Double(st);
	pageContext.setAttribute("TOTAL_BOOK_AMOUNT", d,PageContext.SESSION_SCOPE);
	}
	if(obj2 != null){
		Integer i = (Integer)obj2;
		int i1= i.intValue()+Integer.parseInt(quantity);
		pageContext.setAttribute("TOTAL_BOOK_QUANTITY", new Integer(i1), PageContext.SESSION_SCOPE);
	}else{
		pageContext.setAttribute("TOTAL_BOOK_QUANTITY", new Integer(quantity), PageContext.SESSION_SCOPE);
	}
	out.write(st);
	}catch(Exception e){
		log.error("Exception in BookAmountTag\n:", e);
	}
		return EVAL_PAGE;
	}










}
