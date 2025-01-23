package com.vinay.nagisetty.springboot_rabbitmq;

import com.vinay.nagisetty.springboot_rabbitmq.dto.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
		Student student = new Student("Vinay", "CSE", 25);
		System.out.println(student.getName());
	}


}
