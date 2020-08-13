package com.example.management;

import com.example.management.DTO.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);

	}
	@Bean
	public CommandLineRunner demo(EmployeeController controller) {
		return (args) -> {
			controller.saveCEO(new Employee());
			controller.saveEmployee(new Employee());
			controller.saveEmployee(new Employee());
		};
	}
}
