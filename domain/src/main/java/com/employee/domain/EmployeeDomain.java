package com.employee.domain;

import com.employee.port.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDomain {
    public final EmployeeService employeeService;

    @Autowired
    public EmployeeDomain(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
}
