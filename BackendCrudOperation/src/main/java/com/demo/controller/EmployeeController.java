package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.ok().body(emp);
	}
	
	@GetMapping("/get/{eid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("eid") int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<>(emp.get(), HttpStatus.OK); 
		} else {
			throw new RecordNotFoundException("No Record Found"); 
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> emp = employeeService.getAllEmployee();
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/getSalary/{esalary}")
	public ResponseEntity<List<Employee>> getEmployeeBySalary(@PathVariable("esalary") int salary)
	{
		Optional<List<Employee>> emp = employeeService.getEmployeeBySalary(salary);
		if(emp.isPresent())
		{
			return new ResponseEntity<List<Employee>>(emp.get(), HttpStatus.OK);
		}
		else
		{
			throw new RecordNotFoundException("No Record Found");
		}
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable("id")  int id , @RequestBody Employee newEmp) {
		return employeeService.updateEmployee(id, newEmp);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id")   int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);
		if(emp.isPresent()) {
			employeeService.deleteEmployeebyId(id);
			return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
		}else {
			throw new RecordNotFoundException("No Record Found");
		}
		
	}
}