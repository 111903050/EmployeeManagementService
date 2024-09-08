package com.employee.entity;

import com.employee.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Long id;
    @Column(name = "EMPLOYEE_NAME")
    private String name;
    @Column(name = "EMPLOYEE_DEPT")
    private String department;
    @Column(name = "EMPLOYEE_SAL")
    private Double salary;

    public static EmployeeDto mapEntityToDto(Employee employee){
        return new EmployeeDto(employee.id, employee.name,employee.department, employee.salary);
    }
    public static Employee mapDtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.id, employeeDto.name,employeeDto.department, employeeDto.salary);
    }
}
