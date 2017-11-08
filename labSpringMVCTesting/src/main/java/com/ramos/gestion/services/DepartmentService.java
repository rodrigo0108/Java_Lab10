package com.ramos.gestion.services;

import java.util.List;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Department;



public interface DepartmentService {
	
	Department find(int id) throws DAOException, EmptyResultException;
	
	List<Department> findAll() throws DAOException, EmptyResultException;
	
	void update(String name, String desc, String city) throws DAOException;
	
	void delete(String name) throws DAOException;

	void create(String name, String desc, String city) throws DAOException;
}
