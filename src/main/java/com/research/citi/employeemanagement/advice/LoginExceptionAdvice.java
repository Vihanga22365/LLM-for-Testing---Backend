package com.research.citi.employeemanagement.advice;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.LoginNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.sql.Types.NULL;

@RestControllerAdvice
public class LoginExceptionAdvice {

    @ExceptionHandler(value = LoginNotValidException.class)
    public ResponseEntity<ResponseDTO> handleLoginException(LoginNotValidException loginNotValidException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseDTO(HttpStatus.NOT_FOUND, loginNotValidException.getMessage(), NULL)
        );
    }
}
