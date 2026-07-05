Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address "<emailAddress>" into the email field
And User has entered valid password "<password>" into password field
And User clicks on Login button
Then User should get successfully logged in

Examples:

|emailAddress 								 |password |
|utkarsh1783197765848@gmail.com|12345		 |
|utkarsh1783197771499@gmail.com|12345    |
|utkarsh1783197938103@gmail.com|12345    |
|utkarsh1783197931929@gmail.com|12345    |

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567654" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "123utkarsh@gmail.com" into the email field
And User enters invalid password "1234567654" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User has entered valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
