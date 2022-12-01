package com.example.RestDemo;

import com.example.RestDemo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@RestController
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
		//System.out.println("Hello world");
		//List<Student> student=new ArrayList<>();
		//student.add(new Student())
	}
	//List<String> l=new ArrayList<>(7);
//(Long id, String email, LocalDate dob, String name, Integer age


}
