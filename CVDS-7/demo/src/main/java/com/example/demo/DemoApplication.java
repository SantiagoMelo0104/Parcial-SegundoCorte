package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			System.out.println("\nDeleting employee....");
			employeeService.deleteEmployeeAll();
			System.out.println("Adding employees....\n");

			employeeService.addEmployee(new Employee("Santiago", "Naranjo", "Student", 63000.00, LocalDate.of(2003, 4, 1)));
			employeeService.addEmployee(new Employee("Jorge", "Useche", "Teacher", 43000.00,  LocalDate.of(1992, 1, 15)));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));



		};
	}

}
