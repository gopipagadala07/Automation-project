Feature: FocalPointk12 Exam_Center Create a Time_Slot and Enrolled the Exam Taker to the Time slot

  # Scenario Outline: Create a Time_Slot for the Examination
  #Given User launch the application with Valid URL
  #And User able to see all Fields
  #Then User enters the credentials from the excel sheet at <rownumber>
  #And User is on homepage
  #Then User click on Enrollment
  ##When User click on the Examination Lookup
  #When User Select the Examination <ExamTaker_details_rownumber>
  ##When User click on the Location Lookup
  #Then User Select the Location <ExamTaker_details_rownumber>
  #And User click on TimeSlot Tab
  #Then User click on Add New TimeSlot
  ##When User click on the calender in Exam Time slot popup
  ##Then User select the Exam date <Timeslot_rownumber>
  #When User click on the start Time in Exam Time slot popup
  #Then User select the start Time in Hr <Timeslot_rownumber>
  #Then User select the start Time in Min <Timeslot_rownumber>
  #When User click on the end Time in Exam Time slot popup
  #Then User select the end Time in Hr <Timeslot_rownumber>
  #Then User select the end Time in Min <Timeslot_rownumber>
  #And User provide the examtaker count <Timeslot_rownumber>
  #Then User click on Exam Time Slot Save button
  #
  #Examples:
  #| rownumber | ExamTaker_details_rownumber | Timeslot_rownumber |
  #|         1 |                           0 |                  0 |
  Scenario Outline: Add the Examataker in a Particular TimeSlot
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on Enrollment
    When User Select the Examination <Exam_details_rownumber>
    Then User Select the Location <Exam_details_rownumber>
    When User select the particular Timeslot <Timeslot_rownumber>
    Then User search the particular ExamTaker <ExamTaker_details_rownumber>
    When User add the Examtaker in the Timeslot
    Then User search the added ExamTaker in the TimeSlot <ExamTaker_details_rownumber>
    When User approve and Live the Examtaker for the Examination

    Examples: 
      | rownumber | ExamTaker_details_rownumber | Timeslot_rownumber | Exam_details_rownumber |
      |         1 |                           2 |                  0 |                      0 |
