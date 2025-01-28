Feature: Verify the Documents functionality

  Scenario Outline: Creating folders and uploading Documents
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click on Courses in Left menu
    Then User Search for the Course in Search here Field<rownumber1>
    And User Click on that CourseName<rownumber1>
    And User clicks on Documents Tab
    When User created folder by Entering the Folder Name and Description
    Then User click Upload file button
    Then User successfully uploaded the document file

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |

  #Student Login
  Scenario Outline: Verifying Documents At Student side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then User clicks on Learning tree
    Then User Search for the Course in Search here Field<rownumber1>
    And User Click on that CourseName<rownumber1>
    And User clicks on Documents Tab
    Then User downloaded the file

    Examples: 
      | rownumber | rownumber1 |
      |         3 |          0 |
