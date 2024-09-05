package com.employee.restcontroller;

import com.employee.dto.EmployeeDto;
import com.employee.port.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee-management")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
