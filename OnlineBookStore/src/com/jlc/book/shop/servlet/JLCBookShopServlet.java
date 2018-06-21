package com.jlc.book.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.C2BConverter;

import com.jlc.book.shop.action.*;

/**
 * Servlet implementation class JLCBookShopServlet
 */
public class JLCBookShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginAction loginAction=null;
	LogoutAction logoutAction=null;
	AddBookAction addBookAction = null;
	SearchBookAction searchBookAction=null;
	RegisterAction registerAction =null;
	SortBookInfoAction sortBookInfoAction = null;
	DeleteBookAction deleteBookAction =null;
	NextAction nextAction = null;
	PreviousAction previousAction = null;
	AddBookToCartAction addBookToCartAction =null;
	UserOrderStatusAction userOrderStatusAction = null;
	RemoveFromCartAction removeFromCartAction=null;
	PlaceOrderAction placeOrderAction = null;
	ShowOrderInfoAction showOrderInfoAction =null;
	ChangePasswordAction changePasswordAction =null;
	AllOrdersAction allOrdersAction = null;
	UpdateOrderStatusAction updateOrderStatusAction=null;
	ShowUserInfoAction showUserInfoAction = null;
	EditInfoAction editInfoAction = null;
	CancelEditInfoAction cancelEditInfoAction = null;
	UpdateInfoAction updateInfoAction=null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		loginAction=new LoginAction();
		logoutAction = new LogoutAction();
		addBookAction = new AddBookAction();
		searchBookAction = new SearchBookAction();
		registerAction = new RegisterAction();
		sortBookInfoAction = new SortBookInfoAction();
		deleteBookAction = new DeleteBookAction();
		nextAction = new NextAction();
		previousAction = new PreviousAction();
		addBookToCartAction = new AddBookToCartAction();
		userOrderStatusAction = new UserOrderStatusAction();
		removeFromCartAction = new RemoveFromCartAction();
		placeOrderAction = new PlaceOrderAction();
		showOrderInfoAction = new ShowOrderInfoAction();
		changePasswordAction = new ChangePasswordAction();
		allOrdersAction = new AllOrdersAction();
		updateOrderStatusAction =new UpdateOrderStatusAction();
		showUserInfoAction = new ShowUserInfoAction();
		editInfoAction = new EditInfoAction();
		cancelEditInfoAction = new CancelEditInfoAction();
		updateInfoAction = new UpdateInfoAction();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String page="";
		if(uri.endsWith("login.jlc")){
			page=loginAction.verifyUser(request, response);
		}
		else if(uri.endsWith("logout.jlc")){
				page=logoutAction.logout(request,response);
		}
		else if(uri.endsWith("addBook.jlc")){
			page=addBookAction.addBookInfo(request,response);
		}else if(uri.endsWith("searchBook.jlc")){
			page=searchBookAction.searchBookInfo(request,response);
		}else if(uri.endsWith("register.jlc")){
			page=registerAction.registerStudent(request,response);
		}else if(uri.endsWith("sortInfo.jlc")){
			page = sortBookInfoAction.sortBookInfo(request,response);
		}else if(uri.endsWith("delete.jlc")){
			page= deleteBookAction.deleteBook(request,response);
		}else if(uri.endsWith("next.jlc")){
			page= nextAction.searchBookInfo(request,response);
		}else if(uri.endsWith("previous.jlc")){
			page = previousAction.searchBookInfo(request,response);
		}else if(uri.endsWith("addtocart.jlc")){
			page = addBookToCartAction.addBookToCart(request,response);
		}else if(uri.endsWith("userorderstatus.jlc")){
			page = userOrderStatusAction.getUserOrderStatus(request,response);
		}else if(uri.endsWith("removefromcart.jlc")){
			page=removeFromCartAction.removeFromCart(request,response);
		}else if(uri.endsWith("placeorder.jlc")){
			page=placeOrderAction.placeOrder(request,response);
		}else if(uri.endsWith("showorderinfo.jlc")){
			page=showOrderInfoAction.getOrderInfo(request,response);
		}else if(uri.endsWith("changePassword.jlc")){
			page=changePasswordAction.changePassword(request,response);
		}else if(uri.endsWith("allorders.jlc")){
		page = allOrdersAction.getAllOrders(request,response);	
		}else if(uri.endsWith("updatestatus.jlc")){
			page=updateOrderStatusAction.updateOrderStatus(request,response);
		}else if(uri.endsWith("showuserinfo.jlc")){
			page=showUserInfoAction.getUserInfo(request,response);
		}else if(uri.endsWith("editinfo.jlc")){
			page=editInfoAction.makeEditable(request, response);
		}else if(uri.endsWith("canceledit.jlc")){
			page=cancelEditInfoAction.cancelEditInfo(request, response);
		}else if(uri.endsWith("updateinfo.jlc")){
			page=updateInfoAction.updateUserInfo(request,response);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
