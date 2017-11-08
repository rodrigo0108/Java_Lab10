package com.ramos.gestion.services;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.LoginException;
import com.ramos.gestion.model.Employee;

public interface SecurityService {
	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;
}
