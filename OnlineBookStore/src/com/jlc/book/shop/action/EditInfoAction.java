package com.jlc.book.shop.action;

import javax.servlet.http.*;

public class EditInfoAction {
public String makeEditable(HttpServletRequest req,HttpServletResponse res){
	String page="detailsDef.jsp";
	req.getSession().setAttribute("EDIT_INFO", "ok");
	return page;
}
	
}
