Feature: Examcenter Creation of Examinations Schedules and Examtaker Enrollments feature

  Scenario Outline: Controller Creating Examinations in Examcenter
    Given User launch the application
    And User able to see all Fields in login page
    When User enters the valid credential from the given excel sheet at <RowNumber>
    Then User able to see the Home page
    Then User click on ExamAdministration tab
    And User click on AddExam button under Examination tab
    Then User enters the Examname and Description from the given excelsheet at <RowNumber1>
    Then User click on save button

    #And User Search the Examination in Search here field <RowNumber1>
    #Then User click on Searched Examination Edit button
    #Then User edited the examination name <RowNumber1>
    #Then User click on edit Save button
    Examples: 
      | RowNumber | RowNumber1 |
      |         0 |          0 |

  Scenario Outline: Creating Schedule for an Examinations
    Given User launch the application
    And User able to see all Fields in login page
    When User enters the valid credential from the given excel sheet at <RowNumber>
    Then User able to see the Home page
    Then User click on ExamAdministration tab
    And User Search the Examination in Search here field <RowNumber1>
    Then User click on Add New schedule button
    And Click on Search Test button in Add-Edit schedule popup
    Then User Search the Testname <RowNumber1>
    Then User click on Go icon and click on Add icon for that searched test
    And User enter the Schedule name with <RowNumber1>
    Then User select the Testtype dropdown
    And User enable the all toggles
    Then Click on datepicker icon
    And User choose the date month year from excel datepicker <RowNumber1>
    Then User enters the text in the Ckeditor fields from excel <RowNumber1>
    Then User click on Schedule Save button
    Then Enabled the published and Exam live toggles with schedulename <RowNumber1>

    Examples: 
      | RowNumber | RowNumber1 |
      |         0 |          0 |

  Scenario Outline: Enroll the Examination and schedule to the Examtaker
    Given User launch the application
    And User able to see all Fields in login page
    When User enters the valid credential from the given excel sheet at <RowNumber>
    Then User able to see the Home page
    Then User click on Administration tab
    Then Click on Provisioning tab
    And User Search the Examtaker in Search here field <RowNumber1>
    Then User click on the searched Examtaker <RowNumber1>
    Then User click on Enroll to an Exam button
    And User click on the Examinations dropdown
    Then Select one Examinations name from excel <RowNumber1>
    And Again click on the Schedule dropdown
    Then Choose one Schedule name from an selected Examinations <RowNumber1>
    And User click on Enrollment Save button

    Examples: 
      | RowNumber | RowNumber1 |
      |         0 |          0 |
