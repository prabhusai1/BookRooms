package com.maven.roomsbooking.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import com.maven.roomsbooking.Beans.*;
import com.maven.roomsbooking.Utility.*;


public class InsertOperationsImpl implements InsertOperations{
	static int r_no;
	CustomerDetails custDetails=new CustomerDetails();
	Validation validate=new Validation();
	
	public void getDetails() throws Exception {
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("please enter your name");
		String name=in.next();
		custDetails.setCustName(name);
		String custName=custDetails.getCustName();
		
		System.out.println("please enter your email");
		String email=in.next();
		custDetails.setEmail(email);
		String EMail=custDetails.getEmail();
		
		System.out.println("please enter your address");
		String address=in.next();
		custDetails.setCustAddress(address);
		String custAdd=custDetails.getCustAddress();
		
		System.out.println("please enter your mobile number");
		long number=in.nextLong();
		custDetails.setCustMobile(number);
		long Mobile=custDetails.getCustMobile();
		
		System.out.println("please enter the room number");
		int roomNo=in.nextInt();
		custDetails.setRoomNo(roomNo);
		int room=custDetails.getRoomNo();
		
		System.out.println("please enter room type");
		String roomType=in.next();
		custDetails.setRoomType(roomType);
		String roomtype=custDetails.getRoomType();
		
		
		boolean resultEmail=validate.emailValidate(email);
		boolean resultMobile=validate.mobileValidate(number);
		boolean resultRoomNo=validate.roomNoValidate(roomNo,roomType);
		
		
		if(resultEmail==false || resultMobile==false || resultRoomNo==false) {
			System.out.println("please enter details correctly");
			getDetails();
		}
		
		else {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roomsbooking","root","mysqlroot1");
			String sql="insert into CustomerDetails(CustName,EMail,CustAddress,MobileNo, RoomType, RoomNo) values(?,?,?,?,?,?)";
			PreparedStatement pst= con.prepareStatement(sql);
			
			pst.setString(1, custName);
			pst.setString(2, EMail);
			pst.setString(3, custAdd);
			pst.setLong(4, Mobile);
			pst.setString(5, roomType);
			pst.setInt(6, room);
			
			pst.executeUpdate();
			
			//Statement statement=con.createStatement();
			
			ResultSet rs=pst.executeQuery("select * from CustomerDetails where RoomNo= '"+room+"' ");
			 //= statement.executeQuery("select * from CustomerDetails where RoomNo='room' ");
			
			
			while(rs.next())
			{
				System.out.println("Your room has been successfully booked, your Customer ID is :"+rs.getInt(1));

				
				String sql5="UPDATE roomsdetails SET status='Booked' where Roomno='"+room+"';";
				pst=con.prepareStatement(sql5);
				pst.executeUpdate();
			    break;
			}
			
			
		}
		
	}
	
	public void viewStatus() throws Exception {
		Scanner in=new Scanner(System.in);
		
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roomsbooking","root","mysqlroot1");
		
		Statement statement = con.createStatement();
		ResultSet rs=statement.executeQuery("select * from CustomerDetails");
		
		
		System.out.println("please enter customer ID");
		int cId=in.nextInt();
		
			if(validatecustomerId(cId)) {
				ResultSet rs1=statement.executeQuery("select * from roomsdetails");
				while(rs1.next()) {
					if(rs1.getInt(1)==r_no) {
						System.out.println("Status is "+rs1.getString(3));
						break;
					}
				}
			}
	}
		
		
	
	
	boolean validatecustomerId(int customerid) throws Exception
	{   
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/roomsbooking","root","mysqlroot1");
		
		boolean var=false;;
		Statement statement;
			statement = con.createStatement();
			ResultSet rs=statement.executeQuery("select * from CustomerDetails ");
			while(rs.next())
			{
				if(rs.getInt(1)==customerid)
				{
					System.out.println("customer name :"+rs.getString(2)+"\n"+"room no:"+rs.getInt(7)+"\n"+"room type :"+rs.getString(6));
					r_no=rs.getInt(7);
					var=true;
					break;
				}
	
			}

		return var;

}

}
