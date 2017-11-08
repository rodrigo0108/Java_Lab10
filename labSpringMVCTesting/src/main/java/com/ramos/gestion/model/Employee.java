package com.ramos.gestion.model;

public class Employee {

	String login;
	String password;
	int employeeId;
	String firstname;
	String lastname;
	int salary;
	String depart_id;
	

	/**
	 * 
	 * @param login
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param salary
	 * @param dapart_id
	 */
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepart_id() {
		return depart_id;
	}
	public void setDepart_id(String depart_id) {
		this.depart_id = depart_id;
	}
	public Employee(String login, String password, int employeeId, String firstname, String lastname, int salary,
			String depart_id) {
		super();
		this.login = login;
		this.password = password;
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.salary = salary;
		this.depart_id = depart_id;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [login=" + login + ", password=" + password + ", employeeId=" + employeeId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", salary=" + salary + ", depart_id=" + depart_id + "]";
	}
	
	
	
	
}