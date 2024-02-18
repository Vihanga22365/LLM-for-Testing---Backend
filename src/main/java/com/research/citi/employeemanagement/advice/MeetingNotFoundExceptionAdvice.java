package com.research.citi.employeemanagement.advice;

import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.MeetingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.sql.Types.NULL;

@RestControllerAdvice
public class MeetingNotFoundExceptionAdvice {
    @ExceptionHandler(value= MeetingNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleMeetingNotFoundException(MeetingNotFoundException meetingNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,meetingNotFoundException.getMessage(), NULL));
    }
}
