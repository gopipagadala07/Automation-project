Feature: Verify the Announcements functionality

  Scenario Outline: Creating the Announcements
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User Click Course Designer in Left menu
    Then User able to Search for the Community in Search here Field<rownumber1>
    And User Click on that Community<rownumber1>
    
    
    Then user clicks on the classroom name <rownumber1> <rownumber>
    And user clicks on Announcements Tab
    And user clicks on Add New Announcement button
    Then user checks Announcements search Functionality
    Then user  checks the pagenation
    Then user clicks on the Hometab
    And user clicks on Announcements Tab
    Then user clicks on Addnew button and save button

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |