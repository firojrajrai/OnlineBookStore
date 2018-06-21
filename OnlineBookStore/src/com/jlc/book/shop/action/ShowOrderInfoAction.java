package com.jlc.book.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.OrderDelegate;
import com.jlc.book.shop.to.OrderTO;
import com.jlc.book.shop.to.UserTO;

public class ShowOrderInfoAction {

	public String getOrderInfo(HttpServletRequest req,
			HttpServletResponse res) {
		String page= req.getParameter("page");
		String orderId = req.getParameter("orderId");
		OrderTO oto = OrderDelegate.getOrderByOrderId(orderId);
System.out.println(oto.getOrderItemList());

		req.setAttribute("ORDER_TO", oto);
		List orderList = null;
		if(page.equals("userOrderStatuDef.jsp")){
			Object obj = req.getSession().getAttribute("USER_TO");
			UserTO uto = (UserTO)obj;
			orderList = OrderDelegate.getOrderByUserId(uto.getUserId());
			}else{
				orderList= OrderDelegate.getAllOrderInfo();
				}
		if(orderList != null){
			req.setAttribute("ORDER_FOUND", orderList);
		}
		return page;
	}

}
