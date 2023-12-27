Feature: Saucedemo Practice

@Smoke
Scenario: User is able to login to the application 
Given I launch website url 
And User enters standard_user as username
And User enters secret_sauce as valid password
And I click on login
Then I verify website title is Swag Labs


@Smoke
Scenario: User is able to login to the application 
Given I launch website url 
And User enters standard_user as username
And User enters secret_sauce as valid password
And I click on login
Then I verify website title is Swag Labs


@Smoke
Scenario: User is able to login to the application 
Given I launch website url 
And User enters problem_user as username
And User enters performance_glitch_user as valid password
And I click on login
Then I verify website title is Swag Labs


@Smoke
Scenario: User is able to login to the application 
Given I launch website url 
And User enters locked_out_user as username
And User enters secret_sauce as valid password
And I click on login
Then I verify website title is Swag Labs
