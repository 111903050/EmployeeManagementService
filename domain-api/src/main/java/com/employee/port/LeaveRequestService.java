package com.employee.port;

import com.employee.dto.LeaveRequestDto;

public interface LeaveRequestService {

    void createLeaveRequest(LeaveRequestDto leaveRequestDto);
}
