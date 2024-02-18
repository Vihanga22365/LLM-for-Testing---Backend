Feature: Meeting scheduling
  Scenario: Schedule a meeting successfully with an existing RM and customer
    Given I have set the API endpoint to "http://localhost:8083/api/v1/meeting"
    And I have set the HTTP method to "POST"
    And I have set the mandatory header parameters to "countryCode=US,businessCode=GCB"
    And I have set the non-mandatory header parameters to "uuid=123456"
    And I have set the mandatory request payload parameters to "meetingId=MET001,bankerId=EMP002,customerId=CUS002,bankerFirstName=Naradha,customerFirstName=Santhush,hostType=RM,meetingDate=2023-10-01,startTime=11:00,endTime=13:00"
    And I have set the non-mandatory request payload parameters to "bankerLastName=Liyanage,customerLastName=Ranasinghe"
    When I make a request to schedule a meeting
    Then the response status code should be 200
    And the response message should be "Meeting scheduled successfully"