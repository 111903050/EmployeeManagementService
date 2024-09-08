package com.employee.repo;

import com.employee.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<EmployeeDto> getEmployeeById(Long id);

    void addEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    void addAllEmployees(List<EmployeeDto> employeeDtos);
}
