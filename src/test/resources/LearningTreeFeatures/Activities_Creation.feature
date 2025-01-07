Feature: Verify the Activities Creation Functionality

  Scenario Outline: Creating the the Activities
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User Click Course Designer in Left menu
    ###Course Designer Community Creation
    Then .User Click on the Add New Community button
    When User Enter the Community Name and Description
    Then User Saved the Community and Search for the Created Community in Search here Field<rownumber1>
    And User Click on that Community<rownumber1>
    Then User Add Child Objective
    ###Activities Creation at Virtual Goal
    And User Add Activities in Virtual Goal
    ###Activities Creation at Unit Goal
    Then User Add Discussion Activity
    Then User Add Assignment Activity
    Then User Add Assessment Activity<rownumber1>
    #Then User Add Resources Activity
    #Then User Add Content Activity
    #Then User Add External Tool Activity
    #Then User Add Epub Activity
    #Then User Add LTI Activity
    ###Activities Creation at Topic Goal
    And User Add Activities in Topic Goal
    #Activities Creation at Sub Topic Goal
    Then User Add Activities in Sub Topic Goal
    And User click on Publish Toggle for All Activity in CD

    Examples: 
      | rownumber | rownumber1 |
      |         0 |          0 |
 
