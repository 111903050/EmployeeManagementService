package com.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDto {
    @Schema(description = "Employee Id", example = "EMP0001", required = true)
    public String emp_id;
    @Schema(description = "Leave Type", example = "Tilak street", required = true)
    public String leave_type;
    @Schema(description = "Start Date", example = "2024-09-17", required = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate start_date;
    @Schema(description = "End Date", example = "2024-09-17", required = true)
    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate end_date;
}
