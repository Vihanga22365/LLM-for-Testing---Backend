package com.research.citi.employeemanagement.controller;

import com.research.citi.employeemanagement.dto.EmployeeDTO;
import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("employee")
    public ResponseEntity<ResponseDTO> createEmployee(@RequestBody  EmployeeDTO employeeDTO) throws UserExistException {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpStatus.CREATED, "Employee created successfully", savedEmployee));
    }

    @GetMapping("employee")
    public ResponseEntity<ResponseDTO> getEmployees() {
        List<EmployeeDTO> employees = employeeService.getEmployees();
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Employees fetched successfully", employees));
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable String id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        return  ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Employee fetched successfully", employee));
    }
}
