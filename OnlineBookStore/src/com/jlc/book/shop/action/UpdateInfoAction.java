package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class UpdateInfoAction {

	public String updateUserInfo(HttpServletRequest req,HttpServletResponse res) {
		boolean isError=false;
		String page="detailsDef.jsp";
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		req.setAttribute("EMAIL", email);
		req.setAttribute("PHONE", phone);
		
		//VALIDATING EMAIL
				if(!JLCDataValidator.validateRequired(email)){
					req.setAttribute("email", "Email is required");
					isError = true;
				}else if(!JLCDataValidator.maxLength(email, 32)){
					req.setAttribute("email", "Email must be maximum 32 characters long");
					isError=true;
				}else if(!JLCDataValidator.validateEmail(email)){
					req.setAttribute("email", "Please Enter valid email id");
					isError=true;
				}
				
		//VALIDATING PHONE
				if(!JLCDataValidator.validateRequired(phone)){
					req.setAttribute("phone", "Phone is required");
					isError=true;
				}else if(!JLCDataValidator.validateLong(phone)){
					req.setAttribute("phone", "Phone must be digits only");
					isError = true;
				}else if(!JLCDataValidator.minLength(phone, 10)){
					req.setAttribute("phone", "Phone must be 10 digits");
					isError = true;
				}
				
			if(!isError){
				boolean updated=false;
				Object obj = req.getSession().getAttribute("USER_TO");
				UserTO uto =(UserTO)obj;
				updated= UserDelegate.updateUserInfo(uto.getUserId(),email,Long.parseLong(phone));
				if(updated){
					req.setAttribute("updateError", "Information updated Successfully");
					req.getSession().removeAttribute("EDIT_INFO");
					uto.setEmail(email);
					uto.setPhone(Long.parseLong(phone));
				}else{
					req.setAttribute("updateError", "Error occured while Updating the Information. Please try again Later...");
				}
			} 
		return page;
	}

}
