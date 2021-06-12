package com.example.crud.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.crud.demo.entity.Employee;

@Component
public interface EmployeeService {
	
	public Employee save(Employee employee);

	public List<Employee> getAll();

	public Employee getById(Long empId);

	public void deleteById(Long empId);

}
