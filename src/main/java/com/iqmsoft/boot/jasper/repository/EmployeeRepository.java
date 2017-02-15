package com.iqmsoft.boot.jasper.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.iqmsoft.boot.jasper.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
