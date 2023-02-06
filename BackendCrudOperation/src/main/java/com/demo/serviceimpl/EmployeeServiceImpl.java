package com.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<List<Employee>> getEmployeeBySalary(int salary) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeBySalary(salary);
	}

	@Override
	public Employee updateEmployee(int id, Employee newEmp) {
		Optional<Employee> emp=employeeRepository.findById(id);
		Employee availableEntity = null;
		if(emp.isPresent()) {
			availableEntity = emp.get();
		}
		if(availableEntity != null) {
			if(newEmp.getSalary()!= 0 && newEmp.getName()!= null) {
			    availableEntity.setSalary(newEmp.getSalary()); 
			    availableEntity.setName(newEmp.getName());
			}
			employeeRepository.save(availableEntity);
		}
		return availableEntity;
	}

	@Override
	public void deleteEmployeebyId(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}
	
}

