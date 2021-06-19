package com.example.crud.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultSet {
	
	private Long user_id;
	
	private String user_name;
	
	private long salary;
	
	private String name;
	}
