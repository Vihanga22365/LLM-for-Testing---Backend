package com.research.citi.employeemanagement.advice;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.sql.Types.NULL;

@RestControllerAdvice
public class UserExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value= UserExistException.class)
    public ResponseEntity<ResponseDTO> handleUserExistException(UserExistException userExistException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(HttpStatus.BAD_REQUEST,userExistException.getMessage(), NULL));
    }
}
