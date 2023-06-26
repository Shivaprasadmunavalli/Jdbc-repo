package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Hotel {
	public static void main(String[] args) {
 		
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel1","root","root");
			
			boolean repeat=true;
			do {
				System.out.println("WELCOME COME TO JSP");
				System.out.println("---------------------------");
				System.out.println("1.addmenu");
				System.out.println("2.deletemenu");
				System.out.println("3.updatemenu");
				System.out.println("4.getallmenu");
				System.out.println("5.EXIT-->");
				System.out.println("ENTER YOUR CHOICE");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:{
					PreparedStatement ps=Connection.prepareStatement("insert into hotel1 values(?,?,?,?,?)");
				System.out.println("enter item id");
				ps.setInt(1,sc.nextInt() );
				System.out.println("enter item name");
				ps.setString(2, sc.next());
				System.out.println("enter item cost");
				ps.setInt(3, sc.nextInt());
				System.out.println("enter item quntity");
				ps.setInt(4, sc.nextInt());
				System.out.println("enter Rating");
				ps.setDouble(5, sc.nextDouble());
				ps.execute();
				System.out.println("data saved");
				
				}
				break;
				
				case 2:{
					PreparedStatement ps=Connection.prepareStatement("delete from hotel1 where id=?");
					System.out.println("enter id");
					int id=sc.nextInt();
					ps.setInt(1,id );
					ps.execute();
				}
				break;
				case 3:{
					PreparedStatement ps=Connection.prepareStatement("update hotel1 set cost=? where name=?");
					System.out.println("enter cost");
					int cost=sc.nextInt();
					ps.setInt(1,cost );
					System.out.println("enter item name");
					String name=sc.next();
					ps.setString(2, name);
					ps.execute();
					
				}
				break;
				
				case 4:{
					PreparedStatement ps=Connection.prepareStatement("select * from hotel1 where name=?");
					System.out.println("enter the name");
					String name=sc.next();
				ps.setString(1, name);
				
					ResultSet resultset=ps.executeQuery();
					
					while(resultset.next()) {
						System.out.println("item id is"+resultset.getInt(1));
						System.out.println("item name is"+resultset.getString(2));
						System.out.println("item cost is"+resultset.getInt(3));
						System.out.println("item quantity is"+resultset.getInt(4));
						System.out.println("item rating is"+resultset.getDouble(5));
						
						System.out.println("menu");
						
					}
				}
				break;
				case 5:{
					repeat=false;
					System.out.println("thank you");
				}
				break;
				default :
				System.out.println("invalid choice");
					
				}
				
			}
			while(repeat);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
