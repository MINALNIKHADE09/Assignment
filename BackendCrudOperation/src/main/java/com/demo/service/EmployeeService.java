package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.Employee;

public interface EmployeeService {
	
	
	//create employee
	public Employee saveEmployee(Employee employee);
	
	//read employee 
	public Optional<Employee> getEmployeeById(int id);
	
	//get all employee
	public List<Employee> getAllEmployee();
	
	//get employee by Salary
	public Optional<List<Employee>> getEmployeeBySalary(int salary);
	
	//update employee
	public Employee updateEmployee(int id, Employee newEmployee);
	
	//delete employee
	public void deleteEmployeebyId(int id);

}
