package com.iqmsoft.boot.jasper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.iqmsoft.boot.jasper.model.Employee;
import com.iqmsoft.boot.jasper.repository.EmployeeRepository;

@Configuration
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.iqmsoft.boot.jasper.repository")
@ComponentScan(basePackages = "com.iqmsoft.boot.jasper")
@EnableAutoConfiguration
public class JasperPocApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		createTestEmployeeData();
	}

	public void createTestEmployeeData() {
		
		employeeRepository.deleteAll();
		
		final String[] employeeNames = { "David Smith", "Lazy Payne", "Mike Jones", "John Jackson", "Pierre Williams",
				"Bob Roberts" };

		final List<Employee> employees = new ArrayList<>(employeeNames.length);

		int employeeNumber = 100;

		for (String name : employeeNames) {

			Employee e = new Employee();
			e.setEmpNo(employeeNumber);
			e.setName(name);
			e.setSalary(employeeNumber * 888);
			e.setCommission((float) employeeNumber / 75f);
			employees.add(e);
			employeeNumber++;
		}

		employeeRepository.save(employees);
	}

	public static void main(String[] args) {
		SpringApplication.run(JasperPocApplication.class, args);
	}

	
}

