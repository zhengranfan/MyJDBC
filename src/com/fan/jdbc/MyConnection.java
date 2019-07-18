package com.fan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection  extends ConnectionWrapper{

	public MyConnection(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		System.out.print("hello");
		super.close();
		System.out.print("hello");
	}

}
