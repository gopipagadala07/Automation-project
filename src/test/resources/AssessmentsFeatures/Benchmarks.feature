Feature: Verify the Benchmarks functionality

  Scenario Outline: Creating Benchmarks and activating
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    When the user clicks on the Districts tab and navigates to Benchmarks
    And the user selects the Year from the dropdown at row <rownumber>
    And the user selects the Grade from the dropdown at row <rownumber>
    And the user selects the Subject from the dropdown at row <rownumber>
    Then the user clicks on the Add New Benchmark button
    And the user enters the benchmark name and description generated randomly
    And the user clicks on the Find Test button
    Then the user clicks on the Search Here field and enters the test name from row <rownumber>
    And the user clicks on the Add icon button
    And the user selects all the checkboxes
    Then the user clicks on the Save button
    Then the user clicks on the Publish button
    And a confirmation popup appears, and the user clicks on the Yes button
    And the user clicks on the created benchmark and navigates to the Sections tab
    Then the user clicks on the Search Here field and enters the section name from row <rownumber>
    And the user clicks on the Add button <rownumber>
    #Then Store the data in Excel

    Examples: 
      | rownumber |
      |         0 |
