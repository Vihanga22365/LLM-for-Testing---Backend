package com.research.citi.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoggedUserDTO {
    private String logUserId;
    private String logUserFirstName;
    private String logUserLastName;
    private String logUserType;
    private String logUserEmployeeType;
}
