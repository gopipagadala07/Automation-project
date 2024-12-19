Feature: FocalPointk12 Exam_Center Create a Time_Slot and Enrolled the Exam Taker to the Time slot

  Scenario Outline: Create a Time_Slot for the Examination
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on Enrollment
    When User Select the Examination <rownumber1>
    Then User Select the Location <rownumber1>
    And User click on TimeSlot Tab
    Then User click on Add New TimeSlot
    When User click on the calender and select the Exam date from calendar
    Then User select the start time from time picker
    Then User clicks on ok button
    Then User click on the end Time in Exam Time slot popup
    Then User clicks on ok button
    And User provide the examtaker count
    Then User click on Exam Time Slot Save button
    Then User click on Enrollee tab
    Then User click Timeslot lookup and select particular Timeslot
    Then User search the particular ExamTaker <rownumber2>
    When User add the Examtaker in the Timeslot
    Then User search the added ExamTaker in the TimeSlot <rownumber2>
    When User approve and Live the Examtaker for the Examination

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         2 |          0 |          3 |
