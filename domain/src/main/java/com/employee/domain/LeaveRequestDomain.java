package com.employee.domain;

import com.employee.dto.LeaveRequestDto;
import com.employee.port.LeaveRequestService;
import com.employee.repo.LeaveRequestJpaRepository;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
@Builder
public class LeaveRequestDomain implements LeaveRequestService {
    private final LeaveRequestJpaRepository leaveRequestJpaRepository;

    public LeaveRequestDomain(LeaveRequestJpaRepository leaveRequestJpaRepository) {
        this.leaveRequestJpaRepository = leaveRequestJpaRepository;
    }

    @Override
    public void createLeaveRequest(LeaveRequestDto leaveRequestDto) {
        leaveRequestJpaRepository.createLeaveRequest(leaveRequestDto);
    }
}
