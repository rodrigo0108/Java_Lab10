package com.ramos.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ramos.gestion.dao.EmployeeDAO;
import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.mapper.EmployeeMapper;
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

	@Override
	public List<Employee> findAll() throws DAOException, EmptyResultException {
		
		List<Employee> lista_empleados= employeeDAO.findAllEmployees();
		
		return lista_empleados;
	}
	


}
