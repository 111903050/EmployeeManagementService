package com.employee.persistentclient;

import com.employee.dto.AddressDto;
import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.repo.AddressJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
@Service
public class AddressFromDatabase implements AddressJpaRepository {
    private  final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public AddressFromDatabase(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public void saveAddress(AddressDto addressDto) {
        Employee employee = employeeRepository.findEmployeeById(addressDto.emp_id);
        if(Objects.nonNull(employee)){
            Address address = Address.mapDtoToEntity(addressDto);
            employee.setAddress(address);
            employeeRepository.save(employee);
        }
    }
}
