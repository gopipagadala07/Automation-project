Feature: Checking the Multi Scoring Portfolio Center Assignment Submission Functionality


  Scenario Outline: Verifying the Multi Scoring Portfolio Center Assignment Submission Functionality At student side
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then the user clicks on Learning and Portfolio Courses
    And the user selects the Multi Scoring Course and clicks on the Continue Learning <rownumber1>
    Then The user launches the Multi Scoring Course Assignment and  Submit the Assignment <rownumber1>

    Examples: 
      | rownumber | rownumber1 |
      |         3 |          0 |
