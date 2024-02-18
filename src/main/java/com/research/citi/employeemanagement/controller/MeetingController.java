package com.research.citi.employeemanagement.controller;

import com.research.citi.employeemanagement.dto.MeetingDTO;
import com.research.citi.employeemanagement.dto.ResponseDTO;
import com.research.citi.employeemanagement.exception.MeetingExistException;
import com.research.citi.employeemanagement.exception.MeetingNotFoundException;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.service.meeting.MeetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.sql.Types.NULL;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MeetingController {

    private final MeetingService meetingService;

    @PostMapping("/meeting")
    public ResponseEntity<ResponseDTO> createMeeting(@RequestBody MeetingDTO meetingRequestDTO, @RequestHeader("countryCode") String countryCode, @RequestHeader("businessCode") String businessCode, @RequestHeader(value = "uuid", required = false) Long uuid) throws UserExistException, MeetingExistException {
        if (countryCode == null || businessCode == null || countryCode.isEmpty() || businessCode.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(HttpStatus.UNAUTHORIZED, "Please Add Valid Headers", NULL));
        } else {
            MeetingDTO savedMeeting = meetingService.createMeeting(meetingRequestDTO, countryCode, businessCode, uuid);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpStatus.CREATED, "Meeting created successfully", savedMeeting));
        }

    }

    @GetMapping("/meeting/banker/{bankerId}")
    public ResponseEntity<ResponseDTO> getBankerMeeting(@PathVariable("bankerId") String bankerId) throws MeetingNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Meeting fetched successfully", meetingService.getBankerMeeting(bankerId)));
    }

    @GetMapping("/meeting/customer/{customerId}")
    public ResponseEntity<ResponseDTO> getCustomerMeeting(@PathVariable("customerId") String customerId) throws MeetingNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, "Meeting fetched successfully", meetingService.getCustomerMeeting(customerId)));
    }
}
