package com.fan.dbutils;




import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.fan.dbutils.QR.RsHandler;
import com.fan.domain.Student;
import com.fan.jdbc.utils.JDBCUtils;

public class QRTest {

	@Test
	public void fun1() {
		//Student student = new Student(1,"bary1",22,100.00f);
		//addStu(student);
		System.out.print(load(1));
		}
	
	public void addStu(Student stu) {
		QR qr = new QR(JDBCUtils.getDataSource());
		String sqlString = "insert into my_table values(?,?,?,?) ";
		Object[] paramsObjects = {stu.getId(),stu.getName(),stu.getAge(),stu.getMoney()};
		qr.update(sqlString, paramsObjects);	
   
	}
	
	
	public Student load(int id) {
		QR qr = new QR(JDBCUtils.getDataSource());
		String sqlString = "select * from my_table where id = ? ";
		Object[] paramsObjects = {id};
		
		return qr.query(sqlString, new RsHandler<Student>() {

			@Override
			public Student handle(ResultSet resultSet) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				if(resultSet.next()) {
					student.setId(resultSet.getInt("id"));
					student.setName(resultSet.getString("name"));
					student.setAge(resultSet.getInt("age"));
					student.setMoney(resultSet.getFloat("money"));
					
				}
				return  student;
			}
			
		
		}, paramsObjects);
		
	}
	
	
	
}
