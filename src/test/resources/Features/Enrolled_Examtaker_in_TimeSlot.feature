Feature: FocalPointk12 Exam_Center Procter Comment, Reset the Examination

  #@SmokeTest
  Scenario Outline: Provide the Procter Comment to a ExamTaker
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on Enrollment
    Then User Select the Examination <ExamTaker_details_rownumber>
    Then User Select the Location <ExamTaker_details_rownumber>
    When User select the particular Timeslot <Timeslot_rownumber>
    Then User search the particular ExamTaker <ExamTaker_details_rownumber>
    When Examtaker not added in the Timeslot then add the Examtaker in the Timeslot
    Then User search the added ExamTaker in the TimeSlot <ExamTaker_details_rownumber>
    Then User provide the comment to the Examtaker <ExamTaker_details_rownumber>
    Then User click on ExamTaker Entry Details
    #When User reset the Examinataion for the ExamTaker
    #Then User remove the ExamTaker from the Timeslot

    Examples: 
      | rownumber | ExamTaker_details_rownumber | Timeslot_rownumber |
      |         1 |                           0 |                  0 |
