package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.Employee.Employee;

@Repository
public class Dao implements CommonDao {
	
	private static final String query = "select * from personal_info";
	@Autowired
	private DataSource dataSource;
	List<Employee> al = null;
	
	public List<Employee> operation(){
		al = new ArrayList<Employee>();
		System.out.println("DataSource is "+dataSource.getClass().getName());
		try {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDob(rs.getString(3));
			emp.setCity(rs.getString(4));
			al.add(emp);
		}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
		
		
		
	}
}
