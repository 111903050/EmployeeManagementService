package com.employee.persistentclient;

import com.employee.dto.LeaveRequestDto;
import com.employee.entity.Employee;
import com.employee.entity.LeaveRequest;
import com.employee.repo.LeaveRequestJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class LeaveRequestFromDatabase implements LeaveRequestJpaRepository {

    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestFromDatabase(EmployeeRepository employeeRepository, LeaveRequestRepository leaveRequestRepository) {
        this.employeeRepository = employeeRepository;
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    @Transactional
    public void createLeaveRequest(LeaveRequestDto leaveRequestDto) {
        Employee employee = employeeRepository.findEmployeeById(leaveRequestDto.emp_id);
        if(Objects.nonNull(employee)){
            LeaveRequest leaveRequest = LeaveRequest.mapDtoToEntity(leaveRequestDto);
            leaveRequest.setEmployee(employee);

            leaveRequestRepository.save(leaveRequest);
        }
    }
}
