Feature: FocalPointk12 Exam_Center Login

  @SmokeTest
  Scenario Outline: FocalPointk12 Exam_Center login test with valid credentials scenario
    Given User launch the application with valid URL
    And User enters the credentials from the given admin excel sheet at <rownumber>
    Then User able to see the Home page

    Examples: 
      | rownumber |
      #|         0 |
      |         1 |
      #|         2 |
