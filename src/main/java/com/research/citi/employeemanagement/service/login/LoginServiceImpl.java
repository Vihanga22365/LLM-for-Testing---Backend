package com.research.citi.employeemanagement.service.login;

import com.research.citi.employeemanagement.config.ModelMapperConfig;
import com.research.citi.employeemanagement.dto.LoggedUserDTO;
import com.research.citi.employeemanagement.dto.LoginDTO;
import com.research.citi.employeemanagement.exception.LoginNotValidException;
import com.research.citi.employeemanagement.exception.NotLoggedUserException;
import com.research.citi.employeemanagement.repository.EmployeeRepository;
import com.research.citi.employeemanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapperConfig modelMapperConfig;

    @Override
    public LoggedUserDTO loginUser(LoginDTO loginDTO, HttpSession session) {
        LoggedUserDTO loggedUserDTO = userRepository.findByUserIdAndUserPassword(loginDTO.getUsername(), loginDTO.getPassword())
                .map(user -> {
                    log.info("User: {} logged in successfully", user);
                    return LoggedUserDTO.builder()
                            .logUserId(user.getUserId())
                            .logUserFirstName(user.getUserFirstName())
                            .logUserLastName(user.getUserLastName())
                            .logUserType("user")
                            .logUserEmployeeType(null)
                            .build();
                })
                .orElseGet(() -> {
                    try {
                        return employeeRepository.findByEmployeeIdAndEmployeePassword(loginDTO.getUsername(), loginDTO.getPassword())
                                .map(employee -> {
                                    log.info("Employee: {} logged in successfully", employee);
                                    return LoggedUserDTO.builder()
                                            .logUserId(employee.getEmployeeId())
                                            .logUserFirstName(employee.getEmployeeFirstName())
                                            .logUserLastName(employee.getEmployeeLastName())
                                            .logUserType("employee")
                                            .logUserEmployeeType(employee.getEmployeeType())
                                            .build();
                                }).orElseThrow(() -> {
                                    log.error("Login failed for user: {}", loginDTO.getUsername());
                                    return new LoginNotValidException("Login failed");
                                });
                    } catch (LoginNotValidException e) {
                        throw new RuntimeException(e);
                    }
                });

        return loggedUserDTO;
    }

    @Override
    public LoggedUserDTO getLoginUser(HttpSession session) throws NotLoggedUserException {
        String logUserId = (String) session.getAttribute("logUserId");
        String logUserFirstName = (String) session.getAttribute("logUserFirstName");
        String logUserLastName = (String) session.getAttribute("logUserLastName");
        String logUserType = (String) session.getAttribute("logUserType");
        String logUserEmployeeType = (String) session.getAttribute("logUserEmployeeType");
        if (logUserId != null) {
            return LoggedUserDTO.builder()
                    .logUserId(logUserId)
                    .logUserFirstName(logUserFirstName)
                    .logUserLastName(logUserLastName)
                    .logUserType(logUserType)
                    .logUserEmployeeType(logUserEmployeeType)
                    .build();
        } else {
            throw new NotLoggedUserException("User Not Logged");
        }
    }
}
