package com.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {
    @Schema(description = "Employee Id")@NonNull
    public String id;
    @Schema(description = "Employee First Name")@NonNull
    public String firstName;
    @Schema(description = "Employee Last Name")@NonNull
    public String lastName;
    @Schema(description = "Employee Email")@NonNull
    public String email;
    @Schema(description = "Employee Phone Number")@NonNull
    public String phoneNumber;
    @Schema(description = "Employee Hire Date")@NonNull
    public LocalDate hireDate;
    @Schema(description = "Employee Date Of Birth")@NonNull
    public LocalDate dateOfBirth;
    @Schema(description = "Employee Address")@NonNull
    public int address;
}
