Feature: Exam_Center Location feature

  Scenario Outline: Exam_Center AddEdit Location scenario
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <RowNumber>
    And User is on homepage
    Then User click on Administration tab in homepage
    Then User click on Location tab
    And User click on AddNew button under location tab
    Then User enters the LocationName and Addressfield generated randomly
    Then User click on Locationsave button

    Examples: 
      | RowNumber |
      |         0 |
