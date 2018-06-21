package com.jlc.book.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlc.book.shop.delegate.OrderDelegate;

/**
 * Servlet implementation class UpdateOrderStatusAction
 */
public class UpdateOrderStatusAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	public String updateOrderStatus(HttpServletRequest req,HttpServletResponse res){
		String page = "allOrdersDef.jsp";
		String orderId=req.getParameter("orderId");
		String status=req.getParameter("status");
		OrderDelegate.updateStatus(orderId,status);
		List orderList = OrderDelegate.getAllOrderInfo();
		if(orderList != null){
			req.setAttribute("ORDER_FOUND", orderList);
		}
		
		return page;
	}

}
