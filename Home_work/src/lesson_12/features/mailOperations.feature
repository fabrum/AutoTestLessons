Feature: Test Mail.ru Mail


 Scenario: Moving a letter to spam
    Given I am on main page mail.ru
    When I am Login in mail.ru
    When I select first letter
    When I click on Spam
    Then the list of letters in spam

 Scenario: extracting a letter from spam
    Given I am on main page mail.ru
    When I am Login in mail.ru
    When I go to Spam page
    When I select first letter
    When I click on  Return mail
    Then the list of letters in page


 Scenario: extracting a letter from spam
    Given I am on main page mail.ru
    When I am Login in mail.ru
    When I click on New mail
    When I enter 3 mail address
    When I enter text mail
    When I click on send mail
    Then the  email sent

 Scenario: mark 3 letters with a flag
    Given I am on main page mail.ru
    When I am Login in mail.ru
    When I mark 3 letter
    Then the email is marked

 Scenario: deselect all flag
      Given I am on main page mail.ru
      When I am Login in mail.ru
      When I deselect flag
      Then the email not have a flag