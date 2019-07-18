package com.fan.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	@Test
	public void fun1() throws PropertyVetoException, SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("11111111");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydatabase");
		
		comboPooledDataSource.setAcquireIncrement(5);
		comboPooledDataSource.setInitialPoolSize(20);
		comboPooledDataSource.setMinPoolSize(2);
		comboPooledDataSource.setMaxPoolSize(50);
		
		Connection connection = comboPooledDataSource.getConnection();
		System.out.print(connection);
		connection.close();	
	}
	
	@Test
	public  void fun2() throws SQLException {
	 ComboPooledDataSource pool = new ComboPooledDataSource();
	 Connection connection = pool.getConnection();
	 System.out.print(connection);
	 connection.close();
}

}
