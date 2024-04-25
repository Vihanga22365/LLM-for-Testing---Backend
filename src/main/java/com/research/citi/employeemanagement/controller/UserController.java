package com.research.citi.employeemanagement.controller;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.dto.UserDTO;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserDTO userDTO) throws UserExistException {
        UserDTO savedUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpStatus.CREATED, "User created successfully", savedUser));
    }

    @GetMapping("/user")
    public ResponseEntity<ResponseDTO> getUsers() {
        List<UserDTO> userList = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Users fetched successfully", userList));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable String id) {
        UserDTO user = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "User fetched successfully", user));
    }
}
