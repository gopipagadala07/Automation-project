Feature: Verify the Benchmark Scoring from Teacher Activity progress

  Scenario Outline: Validating the Benchmark Scoring from Teacher Activity progress screen
    Given User launch the application with Valid URL
    And User able to see all Fields
    Then User enters the credentials from the excel sheet at <rownumber>
    And User is on homepage
    When Users Click on Assessment Centre tab in Left menu
    Then Users clicks on Assessment Centre Course <rownumber1><rownumber>
    When User clicks on Benchmarks Tab
    Then User navigates to Student Activity Progress
    And User navigate and give score to the Benchmark
    When User sumbit the Benchmark scoring and navigate back
    Then User capture the Band Status of the Student

    Examples: 
      | rownumber | rownumber1 |
      |         2 |          0 |
