package com.employee.domain;

import com.employee.dto.AddressDto;
import com.employee.port.AddressService;
import com.employee.repo.AddressJpaRepository;
import com.employee.repo.EmployeeJpaRepository;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class AddressDomain implements AddressService {
    private final AddressJpaRepository addressJpaRepository;
    private final EmployeeJpaRepository employeeJpaRepository;
    public AddressDomain(AddressJpaRepository addressJpaRepository, EmployeeJpaRepository employeeJpaRepository) {
        this.addressJpaRepository = addressJpaRepository;
        this.employeeJpaRepository = employeeJpaRepository;
    }

    @Override
    public void saveAddress(AddressDto addressDto) {
        addressJpaRepository.saveAddress(addressDto);
    }
}
