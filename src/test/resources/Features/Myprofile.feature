Feature: Checking the My profile Page Functionality

  Scenario Outline: Checking the My profile Page Functionality
    Given User Logged into the Application with Credentials <Login>
    And User clicks on Myprofile Logo
    Then User edit the Details <UserDetails>
    And User Upload the profile Picture with <UserDetails>
    Then User change the Password with Credentials <UserDetails>
    Then Save the User Profile

    Examples: 
      | Login | UserDetails |
      |     0 |           0 |
