package com.research.citi.employeemanagement.service.employee;

import com.research.citi.employeemanagement.config.ModelMapperConfig;
import com.research.citi.employeemanagement.dto.EmployeeDTO;
import com.research.citi.employeemanagement.entity.Employee;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapperConfig modelMapperConfig;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws UserExistException {
        Optional<Employee> existEmployee = employeeRepository.findByEmployeeId(employeeDTO.getEmployeeId());
        if(!existEmployee.isPresent()) {
            Employee employee = modelMapperConfig.modelMapper().map(employeeDTO, Employee.class);
            Employee savedEmployee = employeeRepository.save(employee);
            return modelMapperConfig.modelMapper().map(savedEmployee, EmployeeDTO.class);
        } else {
            throw new UserExistException("Employee Already Exist");
        }
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return modelMapperConfig.modelMapper().map(employees, List.class);
    }

    @Override
    public EmployeeDTO getEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findByEmployeeId(id);
        log.info("Employee: {}", employee);
        return modelMapperConfig.modelMapper().map(employee, EmployeeDTO.class);
    }
}
