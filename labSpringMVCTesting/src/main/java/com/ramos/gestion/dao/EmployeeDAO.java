package com.ramos.gestion.dao;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Employee;

public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;
	
	//int create(String login, String password, String firstname, String lastname, Double salary, int department_id);

}
