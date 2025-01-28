Feature: Verifying the Announcements functionality in Learning tree

  Scenario Outline: Announcements Creation in LT
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    And User Click on Courses in Left menu
    Then User Search for the Course in Search here Field<rownumber1>
    And User Click on that CourseName<rownumber1>
    And User clicks on Announcements Tab in LT
    And User clicks on Add New Announcement button
    Then User checks the pagination
    Then User checks Announcements search Functionality


    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |

  ##Student Login
  #Scenario Outline: Verifying LT Announcements At Student side
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
    #And User is on homepage
    #And User Click on Learningtree in Left menu
    #Then User Search for the Course in Search here Field<rownumber1>
    #And User Click on that CourseName<rownumber1>
    #And User clicks on Announcements Tab in LT
    #Then User clicks on the Student Announcements from home tab
#
    #Examples: 
      #| rownumber | rownumber1 |
      #|         3 |          0 |