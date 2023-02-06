package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public Optional<List<Employee>> getEmployeeBySalary(int salary);

}
