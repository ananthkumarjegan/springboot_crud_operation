package com.example.crud.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.crud.demo.entity.Employee;
import com.example.crud.demo.entity.ResultSet;
import com.example.crud.demo.entity.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	@Query("SELECT new com.example.crud.demo.entity.ResultSet(u.user_id,u.user_name,u.salary,e.name) FROM User u,Employee e WHERE u.id = e.id and u.id =:param")
	List<ResultSet> getValue(@Param("param") long param);
	
}
