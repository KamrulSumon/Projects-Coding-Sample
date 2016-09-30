package com.sumon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sumon.entity.Employee;
import com.sumon.util.DBUtils;

public class EmployeeDAO {

	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();

		Connection con = DBUtils.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * FROM employee");
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setAddress1(rs.getString("ADDRESS1"));
				emp.setAddress2(rs.getString("ADDRESS2"));
				emp.setCity(rs.getString("CITY"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setId(rs.getInt("ID"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setState(rs.getString("STATE"));
				emp.setZip(rs.getInt("ZIP"));

				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	public User findOne(String id) {

	}

	public User create(User user) {

	}

	public User update(User user) {

	}

	public void delete(User user) {

	}

	public User findByEmail(String email) {

	}
}
