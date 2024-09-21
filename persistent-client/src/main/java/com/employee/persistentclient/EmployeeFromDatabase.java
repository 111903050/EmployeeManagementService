package com.employee.persistentclient;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repo.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableJpaRepositories
@EntityScan("com.employee")
public class EmployeeFromDatabase implements EmployeeJpaRepository {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeFromDatabase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeDto getEmployeeById(String id) {
        EmployeeDto employeeDto;
        try{
            Employee employee = employeeRepository.findEmployeeById(id);
            return Employee.mapEntityToDto(employee);
        }
        catch(Exception e){
            throw new RuntimeException("Employee not found", e);
        }
    }
    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.mapDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(Employee::mapEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void addAllEmployees(List<EmployeeDto> employeeDtos) {
        List<Employee> employees = employeeDtos.stream().map(Employee::mapDtoToEntity).collect(Collectors.toList());
        employeeRepository.saveAll(employees);
    }
}
