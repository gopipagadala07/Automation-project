Feature: Verify the SIS Provisioning Creation Functionality

  Scenario Outline: Checking the School, Classroom, Section Creation Functionality With valid Data
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User Click on SIS provisining tab under Administration in Left menu
    Then User Navigate to School tab
    And User Click on the Add New School button
    When User Enter the Name and Description
    And User Select the Timezone from Dropdown <rownumber>
    Then User Saved the School and Search for the Created School in Search here Field
    And User Navigate to Classroom tab
    Then User Select the Created School in School dropdown
    And User Click on the Add New Classroom button
    Then User Enter the Classroom Name and Description
    And User Saved the Classroom and Search for the Created Classroom in Search here Field
    Then User Navigate to Sections tab
    And User Select the Active Year from year Dropdown <rownumber>
    Then User Click on the Add New Sections button
    And User Enter the Section Name and Description
    Then User Saved the Section and Search for the Created Section in Search here Field

    Examples: 
      | rownumber |
      |         0 |

  Scenario Outline: Verify the Users Creation Functionality with valid Data
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User Click on SIS provisining tab under Administration in Left menu
    When User Navigate to District User tab
    And User Click on Add New User button
    Then User Enters the District user Email, District user First name, District user Last name into the Respective Fields
    When User Saved the District User and Search for the User in search here Field
    And user Click on Edit option for Logins Creations
    Then Click on Create New login button
    And User Reset the Password and save the user
    And User Click on Settings option at User level Ellipses
    Then User Check the Is District Admin Checkbox
    And User Close the Settings Pop up
    Then Store the users data in Excel
    #Teacher Creation
    When User Navigate to Teachers tab
    Then User Select the Created School in School dropdown
    And User Click on Add New Teacher button
    Then User Enters the Teacher Email, Teacher First name, Teacher Last name into the Respective Fields
    When User Saved the Teacher and Search for the User in search here Field
    And user Click on Edit option for Logins Creations
    Then Click on Create New login button
    And User Reset the Password and save the user
    And User Click on Settings option at User level Ellipses
    Then User Navigate to Classrooms tab in settings Pop up
    And User Select the Values in the Year <rownumber>, Section, Classroom dropdown and Click on Add button
    And User Close the Settings Pop up
    Then Store the users data in Excel
    #Student Creation
    Then User Navigate to Students tab
    When User Select the Created School in School dropdown
    And User Click on Add New Student button
    When User Enters the Student Email, Student First name, Student Last name into the Respective Fields
    Then User Saved the Student and Search for the User in search here Field
    And user Click on Edit option for Logins Creations
    Then Click on Create New login button
    And User Reset the Password and save the user
    And User Click on Settings option at User level Ellipses
    Then User Select the Value from Classroom dropdown and Click on Add button
    And User Close the Settings Pop up
    Then Store the users data in Excel

    Examples: 
      | rownumber |
      |         0 |
  #Scenario Outline: Checking the Login Functionality With valid Data
    #Given User launch the application with Valid URL
    #And User able to see all Fields
    #Then User enters the credentials from the excel sheet at <rownumber>
#
    #Examples: 
      #| rownumber |
      #|         1 |
      #|         2 |
      #|         3 |
