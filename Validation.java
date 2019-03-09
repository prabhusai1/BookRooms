package com.maven.roomsbooking.DAO;

import java.util.regex.Pattern;

public class Validation {
	
	public boolean emailValidate(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) {
			System.out.println("Incorrect email");
			return false;
		}
		
		return pat.matcher(email).matches();
	}
	
	public boolean mobileValidate(long mobileNumber) {
		int length = String.valueOf(mobileNumber).length();
		if(length==10) {
			return true;
		}
		else {
			System.out.println("Incorrect mobile number");
			return false;
		}
	}
	
	public boolean roomNoValidate(int roomNo,String roomType) {
		if(roomNo==101 || roomNo==102) {
			if(roomType.contentEquals("AC_SINGLE")) {
				return true;
			}
		else {
			return false;
		}
		}
		
		else if(roomNo==103) {
			if(roomType.contentEquals("AC_DOUBLE")){
				return true;
			}
		else 
			return false;
		
		}
		
		else if((roomNo==201 || roomNo==202)) {
			if(roomType.contentEquals("NONAC_SINGLE")) {
				return true;
			}
		else {
			return false;
		}
		}
		
		else if(roomNo==203) {
			if(roomType.contentEquals("NONAC_DOUBLE")){
				return true;
			}
		else 
			return false;
		
		}
		
		else 
			return false;
		
	}
	
	
}
