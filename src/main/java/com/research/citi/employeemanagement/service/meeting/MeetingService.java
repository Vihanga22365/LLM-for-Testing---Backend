package com.research.citi.employeemanagement.service.meeting;

import com.research.citi.employeemanagement.dto.MeetingDTO;
import com.research.citi.employeemanagement.exception.MeetingExistException;
import com.research.citi.employeemanagement.exception.MeetingNotFoundException;
import com.research.citi.employeemanagement.exception.UserExistException;

import java.util.List;

public interface MeetingService {
    MeetingDTO createMeeting(MeetingDTO meetingDTO, String countryCode, String businessCode, Long uuid) throws UserExistException, MeetingExistException;

    List<MeetingDTO> getBankerMeeting(String bankerId) throws MeetingNotFoundException;

    List<MeetingDTO> getCustomerMeeting(String customerId) throws MeetingNotFoundException;
}
