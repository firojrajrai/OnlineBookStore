package com.jlc.book.shop.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.jlc.book.shop.dao.OrderDAO;
import com.jlc.book.shop.to.BookTO;
import com.jlc.book.shop.to.OrderTO;
import com.jlc.book.shop.util.JDBCUtil;
public class JDBCOrderDAO implements OrderDAO{
Logger log = Logger.getLogger(this.getClass());
	@Override
	public List getOrderByUserId(String userId) {
		List orderList = null;
		Connection con =  null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement("select * from order_table where userId=?");
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				orderList = new ArrayList();
				do{
					OrderTO oto = new OrderTO();
					oto.setAddress(rs.getString("address"));
					oto.setCardNo(rs.getString("cardNo"));
					oto.setCity(rs.getString("city"));
					oto.setCountry(rs.getString("country"));
					oto.setExpDate(rs.getString("expDate"));
					oto.setOrderDate(rs.getString("orderDate"));
					oto.setTotalAmount(rs.getFloat("totalAmount"));
					oto.setTotalItem(rs.getInt("totalItem"));
					oto.setStatus(rs.getString("status"));
					oto.setOrderId(rs.getString("orderId"));
					oto.setState(rs.getString("state"));
					oto.setStreet(rs.getString("street"));
					oto.setUserId(rs.getString("userId"));
					oto.setZip(rs.getString("zip"));
					orderList.add(oto);
				}while(rs.next());
			}
		}catch(Exception e){
			log.error("Exception in getOrderByUserId:\n", e);
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
		return orderList;
	}
	@Override
	public String placeOrder(OrderTO oto, String ip) {
		String orderId = null;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = JDBCUtil.getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("insert into order_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			orderId=getOrderId(oto.getOrderDate(),ip);
			ps.setString(1, orderId);
			ps.setString(2, oto.getAddress());
			ps.setString(3, oto.getStreet());
			ps.setString(4, oto.getCity());
			ps.setString(5, oto.getState());
			ps.setString(6, oto.getCountry());
			ps.setString(7, oto.getZip());
			ps.setString(8, oto.getCardNo());
			ps.setString(9, oto.getExpDate());
			ps.setFloat(10, oto.getTotalAmount());
			ps.setInt(11, oto.getTotalItem());
			ps.setString(12, oto.getUserId());
			ps.setString(13, oto.getOrderDate());
			ps.setString(14, "New");
			int ab = ps.executeUpdate();
			if(ab>0){
				PreparedStatement ps1 = con.prepareStatement("insert into orderItem_table(bookId,quantity,orderId) values(?,?,?)");
				Iterator it = oto.getOrderItemList().iterator();
				while(it.hasNext()){
					BookTO bto = (BookTO)it.next();
					ps1.setInt(1, bto.getBookId());
					ps1.setInt(2, bto.getSelectedNumberOfBook());
					ps1.setString(3, orderId);
					ps1.addBatch();
				}
				int x[] = ps1.executeBatch();
			}
			con.commit();
		}catch(Exception e){
			orderId = null;
			try{
			con.rollback();
			}catch(Exception e1){
				log.error("Error in rollback in Place Order:\n",e1);
			}
			log.error("Exception in Place Order:\t", e);
		}finally{
			JDBCUtil.close(null, ps, con);
		}
		return orderId;
	}
	private String getOrderId(String date, String ip) {
		String id="";
		Calendar cal = Calendar.getInstance();
		String str[] = date.split("/");
		String hh = cal.get(Calendar.HOUR)+"";
		String mm = cal.get(Calendar.MINUTE)+"";
		String ss = cal.get(Calendar.SECOND)+"";
		String dt = str[0]+str[1]+str[2];
		String time = hh+mm+ss;
		String ips[]=ip.split(":");
		ip = ips[0]+ips[1]+ips[2]+ips[3];
		String hexDate= Long.toHexString(Long.parseLong(dt));
		String hexTime= Long.toHexString(Long.parseLong(time));
		String hexIp= Long.toHexString(Long.parseLong(ip));
		id=hexDate+"J"+hexIp+"J"+hexTime;
		return id;
	}
	
	public OrderTO getOrderByOrderId(String orderId) {
	OrderTO oto=null;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try{
		con = JDBCUtil.getConnection();
		ps = con.prepareStatement("select * from order_table where orderId=?");
		ps.setString(1,orderId);
		rs=ps.executeQuery();
		if(rs.next()){
			oto=new OrderTO();
			oto.setAddress(rs.getString("address"));
			oto.setCity(rs.getString("city"));
			oto.setCountry(rs.getString("country"));
			oto.setOrderDate(rs.getString("orderDate"));
			oto.setTotalAmount(rs.getFloat("totalAmount"));
			oto.setTotalItem(rs.getInt("totalItem"));
			oto.setStatus(rs.getString("status"));
			oto.setState(rs.getString("state"));
			oto.setOrderId(rs.getString("orderId"));
			oto.setStreet(rs.getString("street"));
			oto.setZip(rs.getString("zip"));
			
			PreparedStatement ps2 = con.prepareStatement("select * from book_table inner join orderitem_table using(bookId) where orderitem_table.orderId=?");
			ps2.setString(1, orderId);
			ResultSet rs2 = ps2.executeQuery();
			HashSet hs=new HashSet();

			while(rs2.next()){
				BookTO bto = new BookTO();
				bto.setBookId(rs2.getInt("bookId"));
				bto.setAuthor(rs2.getString("author"));
				bto.setBookName(rs2.getString("bookName"));
				bto.setCost(rs2.getFloat("cost"));
				bto.setEdition(rs2.getString("edition"));
				bto.setPublication(rs2.getString("publication"));
				bto.setSelectedNumberOfBook(rs2.getInt("quantity"));
				hs.add(bto);
			}
			System.out.println(hs);
			oto.setOrderItemList(hs);
			
		}
		
	}catch(Exception e){
		log.error("Exception occoured in getOrderByOrderId:\t", e);
	}finally{
		JDBCUtil.close(rs, ps, con);
	}
		return oto;
	}
	@Override
	public List getAllOrderInfo() {
		List orderList = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
		con = JDBCUtil.getConnection();
		ps=con.prepareStatement("select * from order_table");
		rs=ps.executeQuery();
		if(rs.next()){
			orderList = new ArrayList();
			do{
				OrderTO oto = new OrderTO();
				oto.setAddress(rs.getString("address"));
				oto.setCardNo(rs.getString("cardNo"));
				oto.setCity(rs.getString("city"));
				oto.setCountry(rs.getString("country"));
				oto.setExpDate(rs.getString("expDate"));
				oto.setOrderDate(rs.getString("orderDate"));
				oto.setTotalAmount(rs.getFloat("totalAmount"));
				oto.setTotalItem(rs.getInt("totalItem"));
				oto.setStatus(rs.getString("status"));
				oto.setState(rs.getString("state"));
				oto.setOrderId(rs.getString("orderId"));
				oto.setStreet(rs.getString("street"));
				oto.setUserId(rs.getString("userId"));
				oto.setZip(rs.getString("zip"));
				orderList.add(oto);
			}while(rs.next());
		}
			
		}catch(Exception e){
			log.error("Exception occured in getAllOrderInfo:\t", e);
		}
		return orderList;
	}
	@Override
	public void updateStatus(String orderId, String status) {
		Connection con=null;
		PreparedStatement ps =null;
		try{
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement("update order_table set status=? where orderId=?");
			ps.setString(1, status);
			ps.setString(2, orderId);
			ps.executeUpdate();
		}catch(Exception e){
			log.error("Error in updateStatus()\t:",e);
		}finally{
			JDBCUtil.close(null, ps, con);
		}
		
	}
}