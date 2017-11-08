package com.ramos.gestion.dao;

import java.util.List;

import com.ramos.gestion.exception.DAOException;
import com.ramos.gestion.exception.EmptyResultException;
import com.ramos.gestion.model.Department;




public interface DepartmentDAO {
	
	Department findDepartment(int id) throws DAOException, EmptyResultException;

	List<Department> findAllDepartments() throws DAOException, EmptyResultException;
	
	void create(String name, String desc, String city) throws DAOException;

	void delete(String name) throws DAOException;

	void update(String name, String desc, String city) throws DAOException;

	Department findDepartmentByName(String name) throws DAOException, EmptyResultException;

}