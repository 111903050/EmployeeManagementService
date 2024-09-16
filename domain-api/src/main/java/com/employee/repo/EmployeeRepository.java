package com.employee.repo;

import com.employee.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    EmployeeDto getEmployeeById(String id);

    void addEmployee(EmployeeDto employeeDto);

    void deleteEmployee(String id);

    List<EmployeeDto> getAllEmployees();

    void addAllEmployees(List<EmployeeDto> employeeDtos);
}
