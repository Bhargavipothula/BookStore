package com.bookstore.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
public static void main(String args[]) {
	
	String url = "jdbc:mysql://localhost:3306/book1";
	String user="root";
	String password ="Bhargavi@68";
	
	try {
		Connection connection =DriverManager.getConnection(url, user, password);
		System.out.println("connected to the database!");
		
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO book1(author,name,price)VALUES('George Orwell','Animal Farm',567);");
		ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
		
		
		while(resultSet.next()) {
			System.out.println("ID: " + resultSet.getInt("Id"));
			System.out.println("NAME: " + resultSet.getString("Name"));
			System.out.println("AUTHOR: " + resultSet.getString("Author"));
			System.out.println("PRICE: " + resultSet.getInt("Price"));
			//System.out.println("ACTION: " + resultSet.getString("Action"));
		                                                                                              	
					
		}
		
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		
	}


}
