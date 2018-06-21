package com.jlc.book.shop.validator;

import java.util.Calendar;

public class JLCDataValidator {

	public static boolean validateRequired(String value) {
		boolean valid=false;
		if(value!=null && value.length()>0){
			valid=true;
		}
		return valid;
	}
	 
	public static boolean minLength(String value,int len){
		boolean valid=false;
		if(value!=null && value.length()>=len){
			valid=true;
		}
		return valid;
	}

	public static boolean maxLength(String value,int len){
		boolean valid=false;
		if(value!=null && value.length()<=len){
			valid=true;
		}
		return valid;
	}

	public static boolean validateFirstCharacterAsUpper(String value) {
		return Character.isUpperCase(value.charAt(0));
	}

	public static boolean validateName(String value) {
		boolean valid = false;
		if(value!=null){
			valid=value.trim().matches("^[A-Z][a-z]*");
			
		}
		return valid;
	}

	public static boolean validateEmail(String email) {
		boolean valid = false;
		String pattern = "^[a-zA-z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
		if(email!=null){
			valid=email.matches(pattern);
		}
		return valid;
	}

	public static boolean validateLong(String value) {
		boolean valid = false;
		if(value != null){
			try{
				long l = Long.parseLong(value);
				valid=true;
			}catch(Exception e){}
		}
		return valid;
	}

	public static boolean validateExpDate(String value) {
		boolean valid = false;
		if(value != null){
			String[] str=value.split("/");
			if(str.length==2){
				try{
					int mm = Integer.parseInt(str[0]);
					int yy = Integer.parseInt(str[1]);
					int yyyy = Calendar.getInstance().get(Calendar.YEAR);
					if(yy==yyyy){
						int m = Calendar.getInstance().get(Calendar.MONTH)+1;
						if(mm>m && mm<=12){
							valid=true;
						}
					}else{
						System.out.println("else");
						if(mm>0 && mm<=12 && yy>yyyy && yy<=(yyyy+10)){
							valid=true;
						}
					}
				}catch(Exception e){}
			}
		}
		return valid;
	}
	
	
	
}
