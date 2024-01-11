Feature: Checking the My profile Page Functionality

  Scenario Outline: Checking the My profile Page Functionality
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <Login>
    And User is on homepage
    And User clicks on Myprofile Logo
    Then User edit the Details <UserDetails>
    And User Upload the profile Picture with <UserDetails>
    Then User change the Password with Credentials <UserDetails>
    Then Save the User Profile

    Examples: 
      | Login | UserDetails |
      |     0 |           0 |
      |     1 |           0 |
      |     2 |           0 |
