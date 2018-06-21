package com.jlc.book.shop.util;

public class GetTotalAmount {

	public static String getTotalAmount(String value) {
		String st="";
		double d= Double.parseDouble(value);
		long l=(long)d;
		double frac=d-l;
		if(frac!= .5){
			st=l+1+".00";
		}
		return st;
	}

}
