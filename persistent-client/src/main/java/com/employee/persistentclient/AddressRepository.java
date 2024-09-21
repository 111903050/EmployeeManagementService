package com.employee.persistentclient;

import com.employee.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
