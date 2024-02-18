package com.research.citi.employeemanagement.advice;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.MeetingExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.sql.Types.NULL;

@RestControllerAdvice
public class MeetingExceptionAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value= MeetingExistException.class)
    public ResponseEntity<ResponseDTO> handleMeetingExistException(MeetingExistException meetingExistException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(HttpStatus.BAD_REQUEST,meetingExistException.getMessage(), NULL));
    }
}
