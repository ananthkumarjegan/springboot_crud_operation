package com.example.crud.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.crud.demo.entity.Employee;
import com.example.crud.demo.exception.BusinessException;
import com.example.crud.demo.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee save(Employee employee) {
		Employee savedEmployee = null;
		if (employee == null || employee.getName() == null || employee.getName().length() < 1) {
			throw new BusinessException("801", "Employee Entity not having proper parameter");
		}
		try {
			savedEmployee = employeeRepo.save(employee);
		} catch (Exception e) {
			throw new BusinessException("802", "Somthing went wrong in service layer "+ e.getMessage());
		}
		
		return savedEmployee;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> resultSet=null;
		try {
			resultSet=  employeeRepo.findAll();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Somthing went wrong in service layer "+ e.getMessage());	
		}
		return resultSet;
	}

	@Override
	public Employee getById(Long empId) {
		Employee employeeById=null;
		try {			
		employeeById= employeeRepo.findById(empId).get();
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Somthing went wrong in service layer "+ e.getMessage());	
		}
		
		return employeeById;
	}

	@Override
	public void deleteById(Long empId) {
		try {
			employeeRepo.deleteById(empId);			
		} catch(NoSuchElementException e) {
			throw new NoSuchElementException("Somthing went wrong in service layer "+ e.getMessage());	
		}

	}

}
