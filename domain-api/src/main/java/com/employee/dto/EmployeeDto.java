package com.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {
    @Schema(description = "Employee Id")
    public Long id;
    @Schema(description = "Employee Name")
    public String name;
    @Schema(description = "Employee department")
    public String department;
    @Schema(description = "Employee salary")
    public Double salary;
}
