package com.research.citi.employeemanagement.controller;

import com.research.citi.employeemanagement.dto.LoggedUserDTO;
import com.research.citi.employeemanagement.dto.LoginDTO;
import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.NotLoggedUserException;
import com.research.citi.employeemanagement.service.login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static java.sql.Types.NULL;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO, HttpSession session) {
        LoggedUserDTO loggedUserDTO = loginService.loginUser(loginDTO, session);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO(HttpStatus.OK, "Login Successful", loggedUserDTO)
        );
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> getLoginUser(HttpSession session) throws NotLoggedUserException {
        LoggedUserDTO loggedUserDTO = loginService.getLoginUser(session);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO(HttpStatus.OK, "Login Successful", loggedUserDTO)
        );
    }
}
