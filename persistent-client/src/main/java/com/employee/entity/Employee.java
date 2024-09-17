package com.employee.entity;

import com.employee.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "EMP_ID")
    private String id;
    @Column(name = "EMP_FIRST_NAME")
    private String firstName;
    @Column(name = "EMP_LAST_NAME")
    private String lastName;
    @Column(name = "EMP_EMAIL")
    private String email;
    @Column(name = "EMP_PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMP_HIRE_DATE")
    private LocalDate hireDate;
    @Column(name = "EMP_DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name = "EMP_ADDRESS")
    private int address;

    public static EmployeeDto mapEntityToDto(Employee employee){
        return new EmployeeDto(employee.id, employee.firstName, employee.lastName, employee.email, employee.phoneNumber, employee.hireDate, employee.dateOfBirth, employee.address);
    }
    public static Employee mapDtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.id, employeeDto.firstName, employeeDto.lastName, employeeDto.email, employeeDto.phoneNumber, employeeDto.hireDate, employeeDto.dateOfBirth, employeeDto.address);
    }
}
