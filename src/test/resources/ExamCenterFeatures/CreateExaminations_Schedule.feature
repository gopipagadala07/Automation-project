Feature: Examcenter Creation of Examinations Schedules and Examtaker Enrollments feature

  Scenario Outline: Controller Creating Examinations in Examcenter
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <RowNumber>
    And User is on homepage
    Then User click on ExamAdministration tab
    And User click on AddExam button under Examination tab
    Then User enters the Examname and Description for the Respective Fields
    Then User click on save button

    #And User Search the Examination in Search here field <RowNumber1>
    #Then User click on Searched Examination Edit button
    #Then User edited the examination name <RowNumber1>
    #Then User click on edit Save button
    Examples: 
      | RowNumber |
      |         0 |

  Scenario Outline: Creating Schedule for an Examinations
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on ExamAdministration tab
    And User Search the Examination in Search here field
    Then User click on Add New schedule button
    And Click on Search Test button in Add-Edit schedule popup
    Then User Search the Testname <rownumber>
    Then User click on Go icon and click on Add icon for that searched test <rownumber>
    And User enter the Schedule name
    Then User select the Testtype dropdown
    And User enable the all toggles
    And User choose the date month year from datepicker icon
    Then User enters the text in the Ckeditor fields
    Then User click on Schedule Save button
    Then Enabled the published and Exam live toggles with schedulename

    Examples: 
      | rownumber |
      |         0 |

  Scenario Outline: Enroll the Examination and schedule to the Examtaker
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User click on Administration tab
    Then Click on Provisioning tab
    And User Search the Examtaker in Search here field <RowNumber1>
    Then User click on the searched Examtaker <RowNumber1>
    Then User click on Enroll to an Exam button
    And Select one Examinations name from Examinations lookups <rownumber>
    Then Select one Schedule name from an selected Examinations
    And User click on Enrollment Save button

    Examples: 
      | rownumber | RowNumber1 |
      |         0 |          3 |
