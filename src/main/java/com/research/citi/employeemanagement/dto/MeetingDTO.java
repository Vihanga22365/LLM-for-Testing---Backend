package com.research.citi.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingDTO {
    private String meetingId;
    private String bankerId;
    private String customerId;
    private String bankerFirstName;
    private String bankerLastName;
    private String customerFirstName;
    private String customerLastName;
    private String hostType;
    private Date meetingDate;
    private Time startTime;
    private Time endTime;
    private String countryCode;
    private String businessCode;
    private Long uuid;
}
