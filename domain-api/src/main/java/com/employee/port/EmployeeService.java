package com.employee.port;

import com.employee.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeDto> getEmployeeById(Long id);

    void addEmployee(EmployeeDto employee);

    void deleteEmployee(Long id);

    List<EmployeeDto> getAllEmployees();
}
