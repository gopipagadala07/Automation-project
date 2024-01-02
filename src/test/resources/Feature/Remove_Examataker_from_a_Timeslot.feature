Feature: FocalPointk12 Exam_Center Remove the ExamTaker

  @SmokeTest
  Scenario Outline: Remove the ExamTaker from the TimeSlot
    Given User launch the application with a valid URL for Remove the ExamTaker
    And User enters the login credentials for Remove the ExamTaker <LoginRowNumber>
    When User select the particular Examination for Remove the ExamTaker <ExamTaker_details_rownumber>
    Then User select the particular Location for Remove the ExamTaker <ExamTaker_details_rownumber>
    When User select the Timeslot for Remove the ExamTaker <Timeslot_rownumber>
    Then User search the ExamTaker for the Remove <ExamTaker_details_rownumber>
    Then User remove the ExamTaker from the Timeslot

    Examples: 
      | LoginRowNumber | ExamTaker_details_rownumber | Timeslot_rownumber |
      |              1 |                           0 |                  0 |
