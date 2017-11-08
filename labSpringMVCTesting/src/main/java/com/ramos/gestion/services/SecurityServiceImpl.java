package com.ramos.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramos.gestion.dao.EmployeeDAO;
import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.LoginException;
import com.ramos.gestion.model.Employee;

@Service
public class SecurityServiceImpl  implements SecurityService {
	
	@Autowired
	private EmployeeDAO employeeDAO;


	@Override
	public Employee validate(String login, String password) throws LoginException, DAOException {
		
		Employee emp = employeeDAO.validate(login, password);

		return emp;

	}

}
