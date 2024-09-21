package com.employee.repo;

import com.employee.dto.AddressDto;

public interface AddressJpaRepository {
    void saveAddress(AddressDto addressDto);
}
