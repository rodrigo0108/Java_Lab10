package com.ramos.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ramos.gestion.dao.DepartmentDAO;
import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Department;
import com.ramos.gestion.model.Employee;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Override
	public List<Department> findAll() throws DAOException, EmptyResultException {
		List<Department> lista_departamentos= departmentDAO.findAllDepartments();
		
		return lista_departamentos;
	}

	@Override
	public void update(String name, String desc, String city) throws DAOException {
		departmentDAO.update(name,desc,city);
		
	}

	@Override
	public void delete(String name) throws DAOException {
		departmentDAO.delete(name);
		
	}

	@Override
	public void create(String name, String desc, String city) throws DAOException {
		departmentDAO.create(name,desc,city);
		
	}

	@Override
	public Department find(int id) throws DAOException, EmptyResultException {
		Department department = departmentDAO.findDepartment(id);

		return department;
	}

}
