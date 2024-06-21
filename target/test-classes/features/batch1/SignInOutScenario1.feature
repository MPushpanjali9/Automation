Feature: Sign In and Sign Out Functionality

Scenario: User Sign-In and Sign-Out with Excel data
  Given the user is on the login page
  When the user enters credentials from the excel file
  Then the user should be signed in successfully
  And the user should see the dashboard page
  When the user clicks the sign-out button
  Then the user should be signed out successfully
  And the user should see the login page

