package com.ramos.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ramos.gestion.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("employee_id"));
		emp.setLogin(rs.getString("login"));
		emp.setPassword(rs.getString("password"));
		emp.setFirstname(rs.getString("first_name"));
		emp.setLastname(rs.getString("last_name"));
		emp.setSalary(rs.getInt("salary"));
		emp.setDepart_id(rs.getString("department_id"));
		return emp;
	}
}
