Feature: Feature to Test major UI elements

@PracticePage
Scenario: Scenario Radio button
Given I want to launch practice page url
And I want to select radio1
And I want to select radio2
And I want to select radio3

@PracticePage
Scenario: Scenario to select and print country in suggestion Box
Given I want to launch practice page url
And I search for India
Then I verify text in suggestion box is India
And I search for Belgium
Then I verify text in suggestion box is Belgium

@PracticePage
Scenario: Scenario to select and print option from selector
Given I want to launch practice page url
And I want to opt for Option3
Then I want to verify selected option is Option3
And I want to opt for Option2
Then I want to verify selected option is Option2
And I want to opt for Option1
Then I want to verify selected option is Option1
