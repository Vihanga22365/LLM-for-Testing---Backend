package com.research.citi.employeemanagement.service.login;

import com.research.citi.employeemanagement.dto.LoggedUserDTO;
import com.research.citi.employeemanagement.dto.LoginDTO;
import com.research.citi.employeemanagement.exception.NotLoggedUserException;

import javax.servlet.http.HttpSession;

public interface LoginService {
    LoggedUserDTO loginUser(LoginDTO loginDTO, HttpSession session);

    LoggedUserDTO getLoginUser(HttpSession session) throws NotLoggedUserException;
}
