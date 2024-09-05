package com.employee.entity;

import com.employee.dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Employee {
    @Id
    private Long id;
    private String name;
    private String department;
    private Double salary;

    public static EmployeeDto mapEntityToDto(Employee employee){
        return new EmployeeDto(employee.id, employee.name,employee.department, employee.salary);
    }
    public static Employee mapDtoToEntity(EmployeeDto employeeDto){
        return new Employee(employeeDto.id, employeeDto.name,employeeDto.department, employeeDto.salary);
    }
}
