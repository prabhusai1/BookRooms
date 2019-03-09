package com.maven.roomsbooking.UI;

import java.util.Scanner;

import com.maven.roomsbooking.Service.RoomsBookingService;
import com.maven.roomsbooking.Service.RoomsBookingServiceImpl;

public class MainUI {
	public static void main(String args[]) throws Exception {
		Scanner in=new Scanner(System.in);
		RoomsBookingService roomService=new RoomsBookingServiceImpl();
		int choice;
		System.out.println("please enter your choice \n1. Book Room \n2. View Status \n3. Exit");
		choice=in.nextInt();
		
		switch(choice) {
		case 1: roomService.getDetails();
				break;
				
		case 2: roomService.viewStatus();
				break;
		}
		
	}
}