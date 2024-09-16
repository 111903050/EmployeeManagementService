package com.employee.port;

import com.employee.dto.EmployeeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto getEmployeeById(Long id);

    void addEmployee(EmployeeDto employee);

    void deleteEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    void addAllEmployees(MultipartFile file);
}
