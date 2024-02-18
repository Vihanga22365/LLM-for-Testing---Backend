package com.research.citi.employeemanagement.service.employee;

import com.research.citi.employeemanagement.dto.EmployeeDTO;
import com.research.citi.employeemanagement.exception.UserExistException;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws UserExistException;

    List<EmployeeDTO> getEmployees();

    EmployeeDTO getEmployee(String id);
}
