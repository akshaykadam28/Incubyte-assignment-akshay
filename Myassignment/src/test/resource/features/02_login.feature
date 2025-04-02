Feature: Sign In
  
  Scenario: Sign in with valid email and password
    Given the user is on the sign in page
    When the user enters a valid email "sdet.kadam@gmail.com" 
    And a valid password "Akshay@123"
    And clicks on "Sign In"
    Then the user should be successfully signed in and redirected to the dashboard
    
  
  Scenario: Sign in with invalid email format
    Given the user is on the sign in page
    When the user enters an invalid email format "sdet.kadam.gmail.com" 
    And a valid password "Akshay@123"
    And clicks on "Sign In"
    Then an error message should be displayed indicating that the email format is invalid
  
  Scenario: Sign in with incorrect password
    Given the user is on the sign in page
    When the user enters a valid email "sdet.kadam@gmail.com" 
    And an incorrect password "WrongPass123"
    And clicks on "Sign In"
    Then an error message should be displayed indicating that the email or password is incorrect

  Scenario: Sign in with missing email
    Given the user is on the sign in page
    When the user leaves the email field blank 
    And enters a valid password "Akshay@123"
    And clicks on "Sign In"
    Then an error message should be displayed indicating that the email is required

  Scenario: Sign in with missing password
    Given the user is on the sign in page
    When the user enters a valid email "sdet.kadam@gmail.com" 
    And leaves the password field blank
    And clicks on "Sign In"
    Then an error message should be displayed indicating that the password is required

  Scenario: Sign in with both email and password missing
    Given the user is on the sign in page
    When the user leaves both email and password fields blank
    And clicks on "Sign In"
    Then error messages should be displayed for both fields indicating that they are required

  Scenario: Sign in with an unregistered email
    Given the user is on the sign in page
    When the user enters an unregistered email "unregistered@gmail.com" and a valid password "Akshay@123"
    And clicks on "Sign In"
    Then an error message should be displayed indicating that the email or password is incorrect

 