package com.fan.jdbc.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	/**
	 * 必须要有c3p0-congfig.xml 默认配置
	 */
	private static ComboPooledDataSource  pooledDataSource = new ComboPooledDataSource();
	
	private JDBCUtils() {
		
	}
	/**
	 * 返回连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return pooledDataSource.getConnection();
	}
	/**
	 * 返回池对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return pooledDataSource;
	}

}
