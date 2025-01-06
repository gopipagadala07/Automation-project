@ExamCenterGroup
Feature: Checking the Test Analytics under Enroller tab at Proctor side

  Scenario Outline: Testing the Test Analytics popup at proctor Enrolle side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And user click on Enrolle tab
    When User Select the ExamSchedule <Examination>
    Then search for Examtaker<ExamTakerName>
    Then user click on Test Analytics icon<Examination>
    And finally print the Examtaker Name in that pop up <ExamTakerName>

    Examples: 
      | rownumber | Examination | ExamTakerName |
      |         2 |           0 |             3 |
