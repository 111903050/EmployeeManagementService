package com.employee.entity;

import com.employee.dto.LeaveRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "LEAVE_REQUEST")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LR_LEAVE_ID")
    private Long id;

    @Column(name = "LR_LEAVE_TYPE")
    private String leaveType;
    @Column(name = "LR_START_DATE")
    private LocalDate startDate;
    @Column(name = "LR_END_DATE")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LR_EMPLOYEE_ID", nullable = false)
    private Employee employee;

    public LeaveRequest(String leaveType, LocalDate startDate, LocalDate endDate) {
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static LeaveRequest mapDtoToEntity(LeaveRequestDto leaveRequestDto) {
        return new LeaveRequest(leaveRequestDto.leave_type,leaveRequestDto.start_date,leaveRequestDto.end_date);
    }
}
