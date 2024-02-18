package com.research.citi.employeemanagement.repository;

import com.research.citi.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmployeeId(String id);

    Optional<Employee> findByEmployeeIdAndEmployeePassword(String username, String password);
}
