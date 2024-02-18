package com.research.citi.employeemanagement.repository;

import com.research.citi.employeemanagement.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
    Meeting findAllByMeetingId(String meetingId);
    List<Meeting> findAllByBankerId(String bankerId);

    List<Meeting> findAllByCustomerId(String customerId);
}
