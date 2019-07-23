package com.sysintelli.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sysintelli.entity.Employee;

public class EmployeeDAO {

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	Connection con = null;

	public void addEmployee(Employee emp) {

		try {
			if (con == null) {
				con = dataSource.getConnection();
				Statement st = con.createStatement();
				st.execute("INSERT INTO `example`.`employee` VALUES(" + emp.getId() + ",'" + emp.getName() + "',"
						+ emp.getSalary() + ")");
				System.out.println("inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}

	}

	public void deleteEmployeeByID(int empID) {
		try {
			if (con == null) {
				con = dataSource.getConnection();
				Statement st = con.createStatement();
				st.execute("Delete  from  employee where id=" + empID);
				System.out.println("Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

		}
	}

	public Employee getEmployeeByID(int empID) {
		Employee e = new Employee();

		int id = 0;
		String name = " ";
		float salary = 0;
		try {

			if (con == null) {
				con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from employee where id=" + empID);
				while (rs.next()) {
					id = rs.getInt("id");
					name = rs.getString("name");
					salary = rs.getFloat("salary");
				}
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);

			}
		} catch (SQLException ea) {
			// TODO Auto-generated catch block
			ea.printStackTrace();
		}

		return e;
	}

	public List<Employee> getAllEmployees() {
		ArrayList<Employee> E = new ArrayList<Employee>();

		int id = 0;
		String name = " ";
		float salary = 0;

		try {

			if (con == null) {
				con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from example.employee");
				while (rs.next()) {
					Employee ea = new Employee();
					id = rs.getInt("id");
					name = rs.getString("name");
					salary = rs.getFloat("salary");
					ea.setId(id);
					ea.setName(name);
					ea.setSalary(salary);

					E.add(ea);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return E;
	}
}
