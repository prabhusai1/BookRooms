package com.maven.roomsbooking.Service;

import com.maven.roomsbooking.DAO.InsertOperations;
import com.maven.roomsbooking.DAO.InsertOperationsImpl;

public class RoomsBookingServiceImpl implements RoomsBookingService{

	InsertOperations insert = new InsertOperationsImpl();
	public void getDetails() throws Exception {
		
		insert.getDetails();
	}
	
	public void viewStatus() throws Exception {
		insert.viewStatus();
	}
	
}