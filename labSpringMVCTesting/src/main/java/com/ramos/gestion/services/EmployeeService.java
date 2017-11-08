package com.ramos.gestion.services;

import java.util.List;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Employee;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;
	
	List<Employee> findAll() throws DAOException, EmptyResultException;
	
	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;
	
	void delete(String login) throws DAOException;

	void create(String login, String password, String lastname, String firstname, int salary, int deptId) throws DAOException;


}
