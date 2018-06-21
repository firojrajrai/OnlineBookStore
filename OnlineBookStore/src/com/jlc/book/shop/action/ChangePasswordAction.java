package com.jlc.book.shop.action;

import javax.servlet.http.*;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class ChangePasswordAction {

	public String changePassword(HttpServletRequest req,HttpServletResponse res) {
String page="changePasswordDef.jsp";
req.setAttribute("CHANGED_PASSWORD", "NOT OK");
String newpass = req.getParameter("newpass");
String currpass = req.getParameter("currpass");
String confpass = req.getParameter("confpass");

boolean compareEquals=true;
boolean interactWithDB = true;

/*VALIDATING NEW PASSWORD*/
if(!JLCDataValidator.validateRequired(newpass)){
	req.setAttribute("newpass", "New password is Required");
	interactWithDB=false;
	compareEquals=false;
}else if(!JLCDataValidator.minLength(newpass, 6)){
	req.setAttribute("newpass", "New password must be minimum 6 characters long");
	interactWithDB=false;
	compareEquals=false;
}else if(!JLCDataValidator.maxLength(newpass, 15)){
	req.setAttribute("newpass", "New password must be maximum 15 characters long");
interactWithDB=false;
compareEquals=false;
}

/*VALIDATING CURRTENT PASSWORD*/
if(!JLCDataValidator.validateRequired(currpass)){
	req.setAttribute("currpass", "Current password is Required");
	interactWithDB=false;
	compareEquals=false;
}

/*VALIDATING CONFIRM PASSWORD*/
if(!JLCDataValidator.validateRequired(confpass)){
	req.setAttribute("confpass", "Confirm password is Required");
	interactWithDB=false;
	compareEquals=false;
}else if(!JLCDataValidator.minLength(newpass, 6)){
	req.setAttribute("confpass", "Confirm password must be minimum 6 characters long");
	interactWithDB=false;
	compareEquals=false;
}else if(!JLCDataValidator.maxLength(newpass, 15)){
	req.setAttribute("confpass", "COnfirm password must be maximum 15 characters long");
interactWithDB=false;
compareEquals=false;
}

if(compareEquals){
	if(!newpass.equals(confpass)){
		interactWithDB =false;
		req.setAttribute("changePasswordError", "New & Confirm Password doesn't match");
	}
}

if(interactWithDB){
	Object obj = req.getSession().getAttribute("USER_TO");
	UserTO usto=(UserTO)obj;
	if(currpass.equals(usto.getPassword())){
		UserTO uto=UserDelegate.changePassword(usto,newpass);
		if(uto!=null){
			req.getSession().setAttribute("USER_TO", uto);
			req.setAttribute("changePasswordError", "Password updated Successfully");
			req.setAttribute("CHANGED_PASSWORD", "OK");
		}else{
			req.setAttribute("changePasswordError", "Error in changing Password");
		}
	}else{
		req.setAttribute("changePasswordError", "Current Password is Invalid");
	}
	
}
return page;
	}

}
