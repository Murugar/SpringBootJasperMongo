package com.iqmsoft.boot.jasper.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	
	@org.springframework.data.annotation.Id
	private String id;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	private int empNo;
	
	private String name;    
	private Integer salary;
	private Float commission;
	
	public Employee(){}
	
	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public Float getCommission() {
		return commission;
	}


	public void setCommission(Float commission) {
		this.commission = commission;
	}



	
}
