package com.employee.entity;

import com.employee.dto.AddressDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    public int id;
    @Column(name = "STREET_ADDRESS")
    public String streetAddress;
    @Column(name = "CITY")
    public String city;
    @Column(name = "STATE")
    public String state;
    @Column(name = "POSTAL_CODE")
    public String postalCode;
    @Column(name = "COUNTRY")
    public String country;

    public Address(String streetAddress, String city, String state, String postalCode, String country) {
        this.city = city;
        this.streetAddress = streetAddress;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public static Address mapDtoToEntity(AddressDto addressDto){
        return new Address(addressDto.street_address,addressDto.city,addressDto.state,addressDto.postal_code, addressDto.country);
    }
}
