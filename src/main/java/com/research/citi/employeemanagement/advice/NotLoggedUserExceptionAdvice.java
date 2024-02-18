package com.research.citi.employeemanagement.advice;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.NotLoggedUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.sql.Types.NULL;

@RestControllerAdvice
public class NotLoggedUserExceptionAdvice {
    @ExceptionHandler(value = NotLoggedUserException.class)
    public ResponseEntity<ResponseDTO> handleNotLoggedUserException(NotLoggedUserException notLoggedUserException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(HttpStatus.UNAUTHORIZED, notLoggedUserException.getMessage(), NULL));
    }
}
