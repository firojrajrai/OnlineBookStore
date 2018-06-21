package com.jlc.book.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.UserDelegate;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.validator.JLCDataValidator;

public class RegisterAction {

	public String registerStudent(HttpServletRequest req,
			HttpServletResponse res) {
		boolean isError = false;
		String page = "registerDef.jsp";
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender= req.getParameter("gender");
		String username = req.getParameter("uname");
		String password = req.getParameter("pass");
		
		//VALIDATING FIRST NAME
		if(!JLCDataValidator.validateRequired(fname)){
			req.setAttribute("fname", "First Name is Required");
			isError = true;
		}else if(!JLCDataValidator.validateFirstCharacterAsUpper(fname)){
			req.setAttribute("fname", "First Name must start with a capital Letter");
			isError=true;
		}else if(!JLCDataValidator.minLength(fname, 3)){
			req.setAttribute(fname, "First Name must be minimum 3 characters");
			isError=true;
		}else if(!JLCDataValidator.maxLength(fname, 10)){
			req.setAttribute(fname, "First Name must be maximum 10 characters");
			isError=true;
		}else if(!JLCDataValidator.validateName(fname)){
			req.setAttribute("fname", "First name must be only character");
			isError=true;
		}
		
		//VALIDATING MIDDLE NAME
		if(mname!=null && mname.length()>0){
			if(!JLCDataValidator.validateFirstCharacterAsUpper(mname)){
				req.setAttribute("mname", "Middle name must start with capital Letter");
				isError = true;
			}else if(!JLCDataValidator.minLength(mname, 1)){
				req.setAttribute("mname", "Middle Name must be minimum 1 character");
				isError=true;
			}else if(!JLCDataValidator.maxLength(mname, 10)){
				req.setAttribute("mname", "Middle name must be maximum 10 characters");
				isError = true;
			}else if(!JLCDataValidator.validateName(mname)){
				req.setAttribute("mname", "Middle name must be only character");
				isError=true;
			}
		}
		
		//VALIDATING LAST NAME
		if(lname!=null && lname.length()>0){
			if(!JLCDataValidator.validateFirstCharacterAsUpper(lname)){
				req.setAttribute("lname", "Last name must start with capital Letter");
				isError = true;
			}else if(!JLCDataValidator.minLength(lname, 1)){
				req.setAttribute("lname", "Last Name must be minimum 1 character");
				isError=true;
			}else if(!JLCDataValidator.maxLength(lname, 10)){
				req.setAttribute("lname", "Last name must be maximum 10 characters long");
				isError = true;
			}else if(!JLCDataValidator.validateName(lname)){
				req.setAttribute("lname", "Last name must be only character");
				isError=true;
			}
		}
		
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
		
		//VALIDATION GENDER
		if(!JLCDataValidator.validateRequired(gender)){
			req.setAttribute("gender", "Please select the gender");
			isError = true;
		}
		
		//VALIDATING USERNAME
		if(!JLCDataValidator.validateRequired(username)){
			req.setAttribute("uname", "Username is required");
			isError=true;
		}else if(!JLCDataValidator.minLength(username, 6)){
			req.setAttribute("uname", "username must be minimum 6 character");
			isError=true;
		}else if(!JLCDataValidator.maxLength(username,8)){
			req.setAttribute("uname", "username must be maximum 8 characters long");
			isError = true;
		}else if(UserDelegate.alreadyExist(username)){
			req.setAttribute("uname", "Username is already used Please use a different username");
			isError=true;
		}
		
		//VALIDATING PASSWORD
		if(!JLCDataValidator.validateRequired(password)){
			req.setAttribute("pass", "Password is required");
			isError=true;
		}else if(!JLCDataValidator.minLength(password, 6)){
			req.setAttribute("pass", "Password must be minimum 6 character");
			isError=true;
		}else if(!JLCDataValidator.maxLength(password,15)){
			req.setAttribute("pass", "Password must be maximum 15 characters long");
			isError = true;
		}
		
		if(!isError){
			boolean registered=false;
			UserTO uto = new UserTO(fname,mname,lname,email,Long.parseLong(phone), username,password,"User");
			System.out.println(uto);
			registered = UserDelegate.registerUser(uto);
			if(registered){
				req.setAttribute("registrationError", "Registration completes Successfully");
			}else{
				req	.setAttribute("REGISTERED", "OK");
				req.setAttribute("registrationError", "Error happened in registration. Please try later");
			}
		}
		return page;
	}

}
