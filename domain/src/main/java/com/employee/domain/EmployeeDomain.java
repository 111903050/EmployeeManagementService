package com.employee.domain;

import com.employee.dto.EmployeeDto;
import com.employee.port.EmployeeService;
import com.employee.repo.EmployeeRepository;
import lombok.Builder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Builder
@Component
public class EmployeeDomain implements EmployeeService{
    public final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDomain(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);

    }

    @Override
    public void addEmployee(EmployeeDto employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public void addAllEmployees(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Assuming the first row is the header
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            headerRow.forEach(cell -> headers.add(cell.getStringCellValue()));

            List<EmployeeDto> employeeDtos =new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                EmployeeDto employeeDto = new EmployeeDto();
                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i);
                    if(i==0){
                        employeeDto.setId(cell.getStringCellValue());
                    }
                    else if (i==1){
                        employeeDto.setFirstName(cell.getStringCellValue());
                    }
                    else if(i==2){
                        employeeDto.setLastName(cell.getStringCellValue());
                    }
                    else if(i==3){
                        employeeDto.setEmail(cell.getStringCellValue());
                    }
                    else if(i==4){
                        employeeDto.setPhoneNumber(cell.getStringCellValue());
                    }
                    else if(i==5){
                        employeeDto.setHireDate(cell.getLocalDateTimeCellValue().toLocalDate());
                    }
                    else if(i==6){
                        employeeDto.setDateOfBirth(cell.getLocalDateTimeCellValue().toLocalDate());
                    }
                    else if(i==7){
                        employeeDto.setAddress((int) cell.getNumericCellValue());
                    }
                }
                employeeDtos.add(employeeDto);
            }
            workbook.close();
            employeeRepository.addAllEmployees(employeeDtos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
