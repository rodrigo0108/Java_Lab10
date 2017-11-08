package com.ramos.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.ramos.gestion.model.Department;



public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dep = new Department();
		dep.setDepartment_id(rs.getInt("department_id"));
		dep.setName(rs.getString("name"));
		dep.setDesc(rs.getString("descr"));
		dep.setCity(rs.getString("city"));

		return dep;
	}

}
