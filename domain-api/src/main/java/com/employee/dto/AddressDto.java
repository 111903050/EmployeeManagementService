package com.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    @Schema(description = "Employee Id", example = "EMP0001")
    public String emp_id;
    @Schema(description = "Street Address", example = "Tilak street")
    public String street_address;
    @Schema(description = "City", example = "Pune")
    public String city;
    @Schema(description = "State", example = "Maharashtra")
    public String state;
    @Schema(description = "Postal Code", example = "413711")
    public String postal_code;
    @Schema(description = "Country", example = "India")
    public String country;
}
