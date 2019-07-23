# new feature
# Tags: optional
    
Feature: Test login page
    

      Scenario: Test negotive login page
        Given I am on main application page
        When enter valid pass and wrong user Mail
        Then I see error massage
