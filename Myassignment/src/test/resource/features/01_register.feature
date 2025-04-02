Feature: User Registration
1
  Scenario: Register with valid details
    Given User is on the registration page
    When User enters the following registration details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User clicks on "Create an Account"
    Then User should be successfully registered and redirected to the dashboard
    

  Scenario: Register with missing First Name
    Given User is on the registration page
    When User leaves the First Name field blank
    And User enters the following details:
      | Field            | Value                    |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that First Name is required

  Scenario: Register with missing Last Name
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User leaves the Last Name field blank
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Last Name is required

  Scenario: Register with invalid Email
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam.gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Email is invalid

  Scenario: Register with weak Password
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | 123                      |
      | Confirm Password | 123                      |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that the Password is too weak

  Scenario: Register with mismatched Password and Confirm Password
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Kadam@123                |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Password and Confirm Password do not match

  Scenario: Register with missing Password
    Given User is on the registration page
    When User leaves the Password field blank
    And User leaves the Confirm Password field blank
    And User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Password is required

  Scenario: Register with missing Confirm Password
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | (blank)                  |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Confirm Password is required

  Scenario: Register with an already registered Email
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | sdet.kadam@gmail.com     |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Email is already in use

  Scenario: Register with empty Email field
    Given User is on the registration page
    When User enters the following details:
      | Field            | Value                    |
      | First Name       | Akshay                   |
      | Last Name        | Kadam                    |
      | Email            | (blank)                  |
      | Password         | Akshay@123               |
      | Confirm Password | Akshay@123               |
    And User clicks on "Create an Account"
    Then User should see an error message indicating that Email is required

  Scenario: Register with all fields left blank
    Given User is on the registration page
    When User leaves all fields (First Name, Last Name, Email, Password, Confirm Password) blank
    And User clicks on "Create an Account"
    Then User should see error messages for all required fields indicating that they must be filled out before proceeding
