Feature: Verify the Announcements functionality

  Scenario Outline: Creating Announcements
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    Then user clicks on Learning and assessment center
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
  #Student Login
  #Scenario Outline: Verifying Announcements At Student side
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
    #Then user clicks on Learning and assessment center
    #Then user clicks on the classroom name <rownumber1> <rownumber2>
    #Then user clicks on the Announcement from home tab
#
    #Examples: 
      #| rownumber | rownumber1 | rownumber2 |
      #|         3 |          0 |          2 |
