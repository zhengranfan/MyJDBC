package com.fan.dbutils;


import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class QR {
	
	private DataSource dataSource;
	
	
	

	public QR() {
		super();
	}
	

	public QR(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(String sql ,Object... objects) {
		
		Connection connection  = null;
		PreparedStatement preparedStatement = null;
	
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			initParams(preparedStatement,objects);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					
					throw new RuntimeException(e);
				}finally {
					if(connection != null) {
						try {
							connection.close();
						} catch (SQLException e) {
							
							throw new RuntimeException(e);
						}}
				}
				
			}
		}

	}
	
	private void initParams(PreparedStatement preparedStatement ,Object... objects) throws SQLException {
		for(int i = 0 ;i<objects.length ; i++) {
			preparedStatement.setObject(i+1, objects[i]);
			
		}
		
	}


	public <T> T query(String sql , RsHandler<T> rHandler , Object... objects) {
		Connection connection  = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
	
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			initParams(preparedStatement,objects);
			resultSet= preparedStatement.executeQuery();
			
			return rHandler.handle(resultSet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			
			if(resultSet !=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
				
					throw new RuntimeException(e);
				}finally {
					if(preparedStatement != null) {
						try {
							preparedStatement.close();
						} catch (SQLException e) {
							
							throw new RuntimeException(e);
						}finally {
							if(connection != null) {
								try {
									connection.close();
								} catch (SQLException e) {
									
									throw new RuntimeException(e);
								}}
						}
						
					}	
				}
			}
			
	
		}
		
	}
	
	
	
	
	
	interface RsHandler<T>{
	 public T handle(ResultSet resultSet) throws SQLException;
		
	}
	
}
