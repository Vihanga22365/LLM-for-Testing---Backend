package com.research.citi.employeemanagement.service.meeting;

import com.research.citi.employeemanagement.config.ModelMapperConfig;
import com.research.citi.employeemanagement.dto.EmployeeDTO;
import com.research.citi.employeemanagement.dto.MeetingDTO;
import com.research.citi.employeemanagement.dto.UserDTO;
import com.research.citi.employeemanagement.entity.Meeting;
import com.research.citi.employeemanagement.entity.User;
import com.research.citi.employeemanagement.exception.MeetingExistException;
import com.research.citi.employeemanagement.exception.MeetingNotFoundException;
import com.research.citi.employeemanagement.exception.UserExistException;
import com.research.citi.employeemanagement.repository.MeetingRepository;
import com.research.citi.employeemanagement.service.employee.EmployeeService;
import com.research.citi.employeemanagement.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;
    private final ModelMapperConfig modelMapperConfig;
    private final UserService userService;
    private final EmployeeService employeeService;
    @Override
    public MeetingDTO createMeeting(MeetingDTO meetingDTO, String countryCode, String businessCode, Long uuid) throws UserExistException, MeetingExistException {

        UserDTO userDTO = userService.getUser(meetingDTO.getCustomerId());
        EmployeeDTO employeeDTO = employeeService.getEmployee(meetingDTO.getBankerId());

        if (userDTO == null) {
            UserDTO newUser = UserDTO.builder().
                    userId(meetingDTO.getCustomerId()).
                    userFirstName(meetingDTO.getCustomerFirstName()).
                    userLastName(meetingDTO.getCustomerLastName()).
                    userPassword(meetingDTO.getCustomerId()).
                    build();
            userService.createUser(newUser);
        }

        if (employeeDTO == null) {
            EmployeeDTO newEmployee = EmployeeDTO.builder().
                    employeeId(meetingDTO.getBankerId()).
                    employeeFirstName(meetingDTO.getBankerFirstName()).
                    employeeLastName(meetingDTO.getBankerLastName()).
                    employeeType(meetingDTO.getHostType()).
                    employeePassword(meetingDTO.getBankerId()).
                    build();
            employeeService.createEmployee(newEmployee);
        }

        Meeting existMeeting = meetingRepository.findAllByMeetingId(meetingDTO.getMeetingId());

        if(existMeeting == null) {
            Meeting meeting = Meeting.builder().
                    meetingId(meetingDTO.getMeetingId()).
                    bankerId(meetingDTO.getBankerId()).
                    customerId(meetingDTO.getCustomerId()).
                    bankerFirstName(meetingDTO.getBankerFirstName()).
                    bankerLastName(meetingDTO.getBankerLastName()).
                    customerFirstName(meetingDTO.getCustomerFirstName()).
                    customerLastName(meetingDTO.getCustomerLastName()).
                    hostType(meetingDTO.getHostType()).
                    meetingDate(meetingDTO.getMeetingDate()).
                    startTime(meetingDTO.getStartTime()).
                    endTime(meetingDTO.getEndTime()).
                    countryCode(countryCode).
                    businessCode(businessCode).
                    uuid(uuid).
                    build();

            meetingRepository.save(meeting);
            return modelMapperConfig.modelMapper().map(meeting, MeetingDTO.class);
        } else {
            throw new MeetingExistException("Meeting Already Exist");
        }

    }

    @Override
    public List<MeetingDTO> getBankerMeeting(String bankerId) throws MeetingNotFoundException {
        List<Meeting> meeting = meetingRepository.findAllByBankerId(bankerId);
        if (meeting != null && !meeting.isEmpty()) {
            return modelMapperConfig.modelMapper().map(meeting, List.class);
        } else {
            throw new MeetingNotFoundException("Meeting Not Found");
        }
    }

    @Override
    public List<MeetingDTO> getCustomerMeeting(String customerId) throws MeetingNotFoundException {
        List<Meeting> meeting = meetingRepository.findAllByCustomerId(customerId);
        if (meeting != null && !meeting.isEmpty()) {
            return modelMapperConfig.modelMapper().map(meeting, List.class);
        } else {
            throw new MeetingNotFoundException("Meeting Not Found");
        }
    }
}
