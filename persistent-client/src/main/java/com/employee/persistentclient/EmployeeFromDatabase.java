package com.employee.persistentclient;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableJpaRepositories
@EntityScan("com.employee")
public class EmployeeFromDatabase implements com.employee.repo.EmployeeRepository {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeFromDatabase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(Employee::mapEntityToDto);
    }
    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.mapDtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(Long id) {
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
