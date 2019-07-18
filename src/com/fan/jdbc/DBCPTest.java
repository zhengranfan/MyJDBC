package com.fan.jdbc;


import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


public class DBCPTest {
	public static void main(String[] args) throws SQLException {
		BasicDataSource ds = new BasicDataSource();
		System.out.println(ds);
		ds.setUsername("root");
		ds.setPassword("11111111");
		ds.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		ds.setMaxTotal(20);
		ds.setMaxIdle(10);
		ds.setInitialSize(5);
		ds.setMinIdle(2);
		ds.setMaxIdle(1000);
		
		Connection con = ds.getConnection();
		MyConnection myConnection = new MyConnection(con);
		System.out.println(myConnection.getClass().getName());
		myConnection.close();
		
	
	}

}
