package com.employee.entity;

import com.employee.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMP_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveRequest> leaves = new ArrayList<>();

    public Employee(String id, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, LocalDate dateOfBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.dateOfBirth = dateOfBirth;
    }

    public static EmployeeDto mapEntityToDto(Employee employee){
        return new EmployeeDto(employee.id, employee.firstName, employee.lastName, employee.email, employee.phoneNumber, employee.hireDate, employee.dateOfBirth);
    }
    public static Employee mapDtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.id, employeeDto.first_name, employeeDto.last_name, employeeDto.email, employeeDto.phone_number, employeeDto.hire_date, employeeDto.date_of_birth);
    }
}
