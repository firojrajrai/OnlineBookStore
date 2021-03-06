package com.jlc.book.shop.tags;

import java.io.Writer;
import java.util.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class ShowSortFieldTag extends TagSupport {
Logger log = Logger.getLogger(this.getClass());

@Override
	public int doEndTag() throws JspException {
	Map<String, String> m = new LinkedHashMap<>();
	m.put("Select Sort Field", "");
	m.put("Book Name", "bname");
	m.put("Author", "author");
	m.put("Publication", "publication");
	m.put("Edition", "edition");
	m.put("Cost", "cost");
	
	try{
		Writer out = pageContext.getOut();
		out.write("<select name=\"field\" style=\"color: black; background-color:#b4e0d2;\">");
		Iterator<Map.Entry<String, String>> it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> ent= it.next();
			out.write("<option value=\""+ent.getValue()+"\"");
			Object obj = pageContext.getRequest().getAttribute("FIELD");
			if(obj!=null){
				String str = obj.toString();
				if(ent.getValue().equals(str));
				out.write("selected=\"selected\"");
			}
			out.write(">"+ent.getKey()+"</option>");
		}
		out.write("</select>");
	}catch(Exception e){
		log.error("Exception in ShowSortFieldTag\n", e);
	}
		return EVAL_PAGE;
	}
}
