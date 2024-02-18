package com.research.citi.employeemanagement.service.user;

import com.research.citi.employeemanagement.dto.UserDTO;
import com.research.citi.employeemanagement.exception.UserExistException;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO) throws UserExistException;

    List<UserDTO> getUsers();

    UserDTO getUser(String id);
}
