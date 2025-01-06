@ExamCenterGroup
Feature: FocalPointk12 Exam_Center Procter Comment, Reset the Examination

  #@SmokeTest
  Scenario Outline: Provide the Procter Comment to a ExamTaker
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on Enrollment
    Then User Select the Examination <rownumber1>
    Then User Select the Location <rownumber1>
    #Then User click Timeslot lookup and select particular Timeslot
    #Then User search the added ExamTaker in the TimeSlot <rownumber2>
    Then User provide the comment to the Examtaker
    #When User reset the Examinataion for the ExamTaker
    Then User click on ExamTaker Entry Details

    #Then User remove the ExamTaker from the Timeslot
    Examples: 
      | rownumber | rownumber1 | Timeslot_rownumber | rownumber2 |
      |         2 |          0 |                  0 |          3 |
