package com.jlc.book.shop.action;

import java.util.Calendar;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlc.book.shop.delegate.OrderDelegate;
import com.jlc.book.shop.to.OrderTO;
import com.jlc.book.shop.to.UserTO;
import com.jlc.book.shop.util.GetTotalAmount;
import com.jlc.book.shop.validator.JLCDataValidator;

public class PlaceOrderAction {

	public String placeOrder(HttpServletRequest req,
			HttpServletResponse res) {
		String page ="placeOrderDef.jsp";
		boolean isError=false;
		String address = req.getParameter("address");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String state= req.getParameter("state");
		String country = req.getParameter("country");
		String zip = req.getParameter("zip");
		String cardNo = req.getParameter("cardNo");
		String pin = req.getParameter("pin");
		String cardExp = req.getParameter("cardExp");
		
		//VALIDATIND ADDRESS
		if(!JLCDataValidator.validateRequired(address)){
			req.setAttribute("address", "Address is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(address, 3)){
			req.setAttribute("address", "Address must be minimun 3 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(address, 25)){
			req.setAttribute("address", "Address must be maximum 25 characters");
			isError=true;
		}
		
		
		//VALIDATING STREET
		if(!JLCDataValidator.validateRequired(street)){
			req.setAttribute("street", "Street is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(street, 3)){
			req.setAttribute("street", "Street must be minimun 3 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(street, 30)){
			req.setAttribute("street", "Street must be maximum 30 characters");
			isError=true;
		}

		//VALIDATING CITY
		if(!JLCDataValidator.validateRequired(city)){
			req.setAttribute("city", "City is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(city, 3)){
			req.setAttribute("city", "City must be minimun 3 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(city, 30)){
			req.setAttribute("city", "City must be maximum 30 characters");
			isError=true;
		}
		
		//VALIDATING STATE
		if(!JLCDataValidator.validateRequired(state)){
			req.setAttribute("state", "state is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(state, 2)){
			req.setAttribute("state", "state must be minimun 2 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(state, 20)){
			req.setAttribute("state", "state must be maximum 20 characters");
			isError=true;
		}
		
		//VALIDATING COUNTRY
		if(!JLCDataValidator.validateRequired(country)){
			req.setAttribute("country", "country is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(country, 2)){
			req.setAttribute("country", "country must be minimun 2 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(country, 20)){
			req.setAttribute("country", "country must be maximum 20 characters");
			isError=true;
		}
		
		//VALIDATING ZIP
		if(!JLCDataValidator.validateRequired(zip)){
			req.setAttribute("zip", "zip is Required");
			isError = true;
		}else if(!JLCDataValidator.validateLong(zip)){
			req.setAttribute("zip", "Zip must be digits only");
		}else if(!JLCDataValidator.minLength(zip, 6)){
			req.setAttribute("zip", "zip must be minimun 6 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(zip, 6)){
			req.setAttribute("zip", "zip must be maximum 6 characters");
			isError=true;
		}
		
		//VALIDATING CARD NUMBER
		if(!JLCDataValidator.validateRequired(cardNo)){
			req.setAttribute("cardNo", "Card No is Required");
			isError = true;
		}else if(!JLCDataValidator.validateLong(cardNo)){
			req.setAttribute("cardNo", "Card No must be digits only");
		}else if(!JLCDataValidator.minLength(cardNo, 16)){
			req.setAttribute("cardNo", "Card No must be minimun 16 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(cardNo, 16)){
			req.setAttribute("cardNo", "Card No must be maximum 16 characters");
			isError=true;
		}
		
		//VALIDATING SECRET PIN
		if(!JLCDataValidator.validateRequired(pin)){
			req.setAttribute("pin", "Secret pin is Required");
			isError = true;
		}else if(!JLCDataValidator.validateLong(pin)){
			req.setAttribute("pin", "Secret pin must be digits only");
		}else if(!JLCDataValidator.minLength(pin, 4)){
			req.setAttribute("pin", "Secret pin must be minimun 4 characters");
			isError = true;
		}else if(!JLCDataValidator.maxLength(pin, 4)){
			req.setAttribute("pin", "Secret pin must be maximum 4 characters");
			isError=true;
		}
		
		//VALIDATING EXPIRY DATE
		if(!JLCDataValidator.validateRequired(cardExp)){
			req.setAttribute("cardExp", "Expiry Date is Required");
			isError = true;
		}else if(!JLCDataValidator.minLength(cardExp, 6)){
			req.setAttribute("cardExp", "Not a valid Expiry Date");
			isError = true;
		}else if(!JLCDataValidator.maxLength(cardExp, 7)){
			req.setAttribute("cardExp", "Not a valid Expiry Date");
			isError=true;
		}else if(!JLCDataValidator.validateExpDate(cardExp)){
			req.setAttribute("cardExp", "Not a valid Expiry Date");
			isError=true;
		}
		System.out.println("*******************"+isError);
		if(!isError){
			String orderDate = Calendar.getInstance().get(Calendar.DATE)+"/"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"/"+Calendar.getInstance().get(Calendar.YEAR);
		
		Set orderItemList= (Set)req.getSession().getAttribute("SELECTED_BOOK_LIST");
		
		float totalAmount = 0.0f;
		int totalItem=0;
		Object obj = req.getSession().getAttribute("TOTAL_BOOK_QUANTITY");
		if(obj!=null){
			Integer i = (Integer)obj;
			totalItem = i.intValue();
		}
		
		obj = req.getSession().getAttribute("TOTAL_BOOK_AMOUNT");
		System.out.println("***********"+obj);
		if(obj!=null){
			Double d = (Double)obj;
			totalAmount = Float.parseFloat(GetTotalAmount.getTotalAmount(d.toString()));
		}
		UserTO userTo = (UserTO)req.getSession().getAttribute("USER_TO");
		OrderTO oto = new OrderTO();
		oto.setAddress(address);
		oto.setCardNo(cardNo);
		oto.setCity(city);
		oto.setCountry(country);
		oto.setUserId(userTo.getUserId());
		oto.setExpDate(cardExp);
		oto.setOrderDate(orderDate);
		oto.setOrderItemList(orderItemList);
		oto.setState(state);
		oto.setStreet(street);
		oto.setTotalAmount(totalAmount);
		oto.setTotalItem(totalItem);
		oto.setZip(zip);
		String orderId = OrderDelegate.placeOrder(oto,req.getRemoteAddr());
		System.out.println("ORDERID::  "+orderId);
		if(orderId !=null){
			req.setAttribute("ORDER_PLACED", orderId);
			HttpSession sess = req.getSession();
			sess.removeAttribute("TOTAL_BOOK_AMOUNT");
			sess.removeAttribute("TOTAL_BOOK_QUANTITY");
		}else{
			req.setAttribute("errorInOrder", "Error occured while placing order. Please try later");
		}
		}
		
		return page;
	}
}
