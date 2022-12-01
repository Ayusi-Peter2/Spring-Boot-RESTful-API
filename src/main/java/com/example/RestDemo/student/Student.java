package com.example.RestDemo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class Student {
    Long id;
    String email;
    LocalDate dob;
    String name;
    Integer age;
   // String email;


    public Student(Long id, String email, LocalDate dob, String name, Integer age) {
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(String email, LocalDate dob, String name, Integer age) {
        this.email = email;
        this.dob = dob;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
