Feature: Exam_Center Location feature

  Scenario Outline: Exam_Center AddEdit Location scenario
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <RowNumber>
    And User is on homepage
    #Then User click on Change Password Close Icon
    And User click on Administration tab in homepage
    Then User click on Location tab
    And User click on AddNew button under location tab
    Then User enters the LocationName from the given excelsheet at <RowNumber1>
    Then User enters the Address from the given excelsheet at <RowNumber1>
    Then User click on Locationsave button

    #And User click on Location Edit button with reference Location name <RowNumber1>
    #Then User edited the Location name <RowNumber1>
    #Then User click on editlocation Save button
    Examples: 
      | RowNumber | RowNumber1 |
      |         0 |          0 |
