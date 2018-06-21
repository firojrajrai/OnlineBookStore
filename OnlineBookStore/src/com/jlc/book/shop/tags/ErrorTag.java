package com.jlc.book.shop.tags;
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.log4j.Logger;
public class ErrorTag extends TagSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 3266131225931815738L;
private String property;
Logger log = Logger.getLogger(this.getClass());
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public Logger getLog() {
	return log;
}
public void setLog(Logger log) {
	this.log = log;
}

public int doEndTag() throws JspException{
	try{
		Writer out=pageContext.getOut();
		Object obj = pageContext.getAttribute(property,PageContext.REQUEST_SCOPE);
		if(obj !=null)
			out.write(obj.toString());
	}catch(Exception e){
		log.error("Exception in ErrorTag\n",e);
	}
	return EVAL_PAGE;
}
}
