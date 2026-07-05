Feature: Registration Functionality

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Utkarsh   |
      | lastName  | Patil     |
      | telephone | 123456565 |
      | password  |     12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates an account with all fields
    Given User navigates to Register Account Page
    When User enters the details into below fields
      | firstName | Utkarsh   |
      | lastName  | Patil     |
      | telephone | 123456565 |
      | password  |     12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User creates a duplicate account
    Given User navigates to Register Account Page
    When User enters the details into below fields with duplicate email
      | firstName | Utkarsh               |
      | lastName  | Patil                 |
      | email     | amortori785@gmail.com |
      | telephone |             123456565 |
      | password  |                 12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email

  Scenario: User creates an account without filling any details
    Given User navigates to Register Account Page
    When User dont enter any details into fields
    And User clicks on Continue button
    Then User should get proper warning messages for every mandatory field
      | First Name must be between 1 and 32 characters! |
      | Last Name must be between 1 and 32 characters!  |
      | E-Mail Address does not appear to be valid!     |
      | Telephone must be between 3 and 32 characters!  |
      | Password must be between 4 and 20 characters!   |
