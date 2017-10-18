package com.ramos.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.gestion.dao.EmployeeDAO;
import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}

}
