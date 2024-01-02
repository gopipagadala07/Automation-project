#Feature: FocalPointk12 Exam_Center Reset the Examination Token
#
  #@SmokeTest
  #Scenario Outline: Reset the Examination Token for the ExamTaker at Procter side
    #Given User launch the application with a valid URL for Reset the Examination
    #And User enters the login credentials for Reset the Examination <LoginRowNumber>
    #When User select the particular Examination for Reset the Examination <ExamTaker_details_rownumber>
    #Then User select the particular Location for Reset the Examination <ExamTaker_details_rownumber>
    #When User select the Timeslot for Reset the Examination <Timeslot_rownumber>
    #Then User search the ExamTaker for the Reset the Examination <ExamTaker_details_rownumber>
    #Then User reset the Examainataion for the ExamTaker
#
    #Examples: 
      #| LoginRowNumber | ExamTaker_details_rownumber | Timeslot_rownumber |
      #|              1 |                           0 |                  0 |
