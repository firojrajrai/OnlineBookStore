package com.jlc.book.shop.tags;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

import com.jlc.book.shop.util.DoubleFormator;
import com.jlc.book.shop.util.GetTotalAmount;

public class TotalAmountTag extends TagSupport{
Logger log = Logger.getLogger(this.getClass());
@Override
	public int doEndTag() throws JspException {
	try{
		Writer out=pageContext.getOut();
		Object obj1 = pageContext.getAttribute("TOTAL_BOOK_AMOUNT",PageContext.SESSION_SCOPE);
		if(obj1!=null){
			String st=DoubleFormator.formatDouble(obj1.toString());
			System.out.println("AMOUNT::"+st);
			st=GetTotalAmount.getTotalAmount(st);
			out.write(st);
		}
	}catch(Exception e){
		log.error("Exception in TotalAmountTag\n:", e);
	}
	return EVAL_PAGE;
	}
}
