package com.example.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.demo.entity.Employee;
import com.example.crud.demo.service.EmployeeService;

@RestController
@RequestMapping("/crud")
public class CrudController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.save(employee);

		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllData() {
		List<Employee> retrivedEmployees = employeeService.getAll();

		return new ResponseEntity<List<Employee>>(retrivedEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<Employee> getDataById(@PathVariable("empId") Long empId) {
		Employee retrivedEmployeeById = employeeService.getById(empId);

		return new ResponseEntity<Employee>(retrivedEmployeeById, HttpStatus.OK);
	}
	
	@PostMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteById(@PathVariable("empId") Long empId) {
		 employeeService.deleteById(empId);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Employee> updateData(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.save(employee);

		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}
	
	
	
	

}
