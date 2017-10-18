package com.ramos.gestion.services;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Employee;

public interface EmployeeService {
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;

}
