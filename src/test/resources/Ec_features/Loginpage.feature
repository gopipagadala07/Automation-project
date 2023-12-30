Feature: FocalPoint Exam_Center Login functionality

  Scenario Outline: FocalPoint Exam_Center login test with valid credentials scenario
    Given User launch the application
    And User able to see pleaselogintoapp text
    When User enters the valid credential from the given excel sheet at <RowNumber>
    Then User able to see the Home page

    Examples: 
      | RowNumber |
      |         0 |
      #|         1 |
      #|         2 |
