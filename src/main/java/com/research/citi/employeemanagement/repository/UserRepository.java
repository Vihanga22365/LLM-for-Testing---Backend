package com.research.citi.employeemanagement.repository;

import com.research.citi.employeemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String id);

    Optional<User> findByUserIdAndUserPassword(String username, String password);
}
