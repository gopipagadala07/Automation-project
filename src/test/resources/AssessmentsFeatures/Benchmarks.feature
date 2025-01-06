@AssessmentCenterGroup
Feature: Verify the Benchmarks functionality

  Scenario Outline: Creating Benchmarks and activating
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber1>
    And User is on homepage
    When the user clicks on the Districts
    And user navigates to Benchmarks tab
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

    Examples: 
      | rownumber | rownumber1 |
      |         0 |          1 |

  Scenario Outline: Activating Benchmark Through Test Administration
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber2>
    And User is on homepage
    When the user clicks on the Districts
    When user clicks on Testadministration tab
    And the user selects the Year from the dropdown at row <rownumber>
    And the user selects the Grade from the dropdown at row <rownumber>
    And the user selects the Subject from the dropdown at row <rownumber>
    And the user selects the course benchmark from the dropdown at row <rownumber>
    And the user selects the school from the dropdown at row <rownumber>
    And the user selects the teacher from the dropdown at row <rownumber1>
    And the user selects the classroom from the dropdown at row <rownumber>
    When user clicks on toggle to activate benchmark
    Then user checks the status and Reset the Benchmark Activity

    Examples: 
      | rownumber | rownumber1 | rownumber2 |
      |         0 |          2 |          1 |
