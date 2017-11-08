package com.ramos.gestion.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ramos.gestion.dao.DepartmentDAO;
import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.mapper.DepartmentMapper;
import com.ramos.gestion.mapper.EmployeeMapper;
import com.ramos.gestion.model.Department;
import com.ramos.gestion.model.Employee;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Department> findAllDepartments() throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, descr, city FROM departments ";

		try {

			List<Department> departments = jdbcTemplate.query(query, new DepartmentMapper());
			//
			return departments;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	


	}
	
	@Override
	public void create(String name, String desc, String city) throws DAOException {
		String query = "INSERT INTO departments (name, descr, city)  VALUES ( ?,?,? )";

		Object[] params = new Object[] { name, desc, city };

		Department department = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			department = this.findDepartmentByName(name);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String name) throws DAOException {
		String query = "DELETE FROM  departments WHERE name = ? ";

		Object[] params = new Object[] {name };

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void update(String name, String desc, String city) throws DAOException {

		String query = "UPDATE departments SET descr = ?, city =? WHERE name = ?";

		Object[] params = new Object[] { desc,city, name };

		
		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
		
	

	@Override
	public Department findDepartmentByName(String name) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, descr, city FROM departments WHERE name = ? ";

		Object[] params = new Object[] { name };

		try {

			Department department = jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return department;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Department findDepartment(int id) throws DAOException, EmptyResultException {
		String query = "SELECT department_id, name, descr, city "
				+ " FROM departments WHERE department_id = ?";

		Object[] params = new Object[] { id };

		try {

			Department dep = (Department) jdbcTemplate.queryForObject(query, params, new DepartmentMapper());
			//
			return dep;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

}
