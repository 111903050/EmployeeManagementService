package com.employee.repo;

import com.employee.dto.LeaveRequestDto;

public interface LeaveRequestJpaRepository {

    void createLeaveRequest(LeaveRequestDto leaveRequestDto);
}
