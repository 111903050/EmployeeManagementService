package com.employee.restcontroller;

import com.employee.dto.EmployeeDto;
import com.employee.port.EmployeeService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Name;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee-management")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public EmployeeDto getEmployee(@Parameter(description = "Employee Id", example = "1") @PathVariable(name = "id") String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(path ="/post", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void addEmployee(@RequestBody EmployeeDto employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path= "/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public void deleteEmployee(@Parameter(description = "Employee Id", example = "1") @PathVariable(name = "id") String id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path= "/upload", produces = "application/json", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadFile(@Parameter(description = "File to be uploaded", required = true, schema = @Schema(name = "file", type = "string", format = "binary"))
                                                 @RequestPart("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file!");
        }
        employeeService.addAllEmployees(file);
        return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
    }
}
