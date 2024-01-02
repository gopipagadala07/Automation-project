Feature: FocalPointk12 Exam_Center Procter Comment, Reset the Examination

  @SmokeTest
  Scenario Outline: Provide the Procter Comment to a ExamTaker
    Given User launch the application
    And User enters the valid cridential <rownumber>
    Then User click on Enrollment
    When User click on the Examination Lookup
    Then User Select the Examination <ExamTaker_details_rownumber>
    When User click on the Location Lookup
    Then User Select the Location <ExamTaker_details_rownumber>
    When User select the particular Timeslot <Timeslot_rownumber>
    Then User search the particular ExamTaker <ExamTaker_details_rownumber>
    When Examtaker not added in the Timeslot then add the Examtaker in the Timeslot
    Then User search the added ExamTaker in the TimeSlot <ExamTaker_details_rownumber>
    Then User provide the comment to the Examtaker

    Examples: 
      | rownumber | ExamTaker_details_rownumber | Timeslot_rownumber |
      |         1 |                           0 |                  0 |
      #
   #@SmokeTest
  #Scenario Outline: Reset the Examination Token for the ExamTaker at Procter side
    #Given User launch the application
    #And User enters the valid cridential <rownumber>
    #When User select the particular Examination for Reset the Examination <ExamTaker_details_rownumber>
    #Then User select the particular Location for Reset the Examination <ExamTaker_details_rownumber>
    #When User select the Timeslot for Reset the Examination <Timeslot_rownumber>
    #Then User search the ExamTaker for the Reset the Examination <ExamTaker_details_rownumber>
    #Then User reset the Examainataion for the ExamTaker
#
    #Examples: 
      #| LoginRowNumber | ExamTaker_details_rownumber | Timeslot_rownumber |
      #|              1 |                           0 |                  0 |
