package com.employee.restcontroller;

import com.employee.dto.AddressDto;
import com.employee.port.AddressService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {
    public final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/save", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address saved successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> saveAddress(@RequestBody AddressDto addressDto){
        addressService.saveAddress(addressDto);
        return ResponseEntity.ok("Address Saved");
    }
}
