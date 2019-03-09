package com.maven.roomsbooking.Beans;

public class CustomerDetails{
	private String custName;
	private String custAddress;
	private String email;
	private String roomType;
	private long custMobile;
	private int roomNo;
	
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustName() {
		return custName;
	}
	
	
	
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustAddress() {
		return custAddress;
	}
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomType() {
		return roomType;
	}
	
	
	
	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	public long getCustMobile() {
		return custMobile;
	}
	
	
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomNo() {
		return roomNo;
	}
		
}