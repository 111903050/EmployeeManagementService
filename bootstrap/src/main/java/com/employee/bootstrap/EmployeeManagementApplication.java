package com.employee.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.employee")
public class EmployeeManagementApplication {
    public static void main(String[] args){
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }
}