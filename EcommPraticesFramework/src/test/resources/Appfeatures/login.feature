Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store1"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "abcrkg@gmail.com"
And user enters password "pa55word"
And user click on login button
Then user gets the title of the page
And page title should be "My account - My Store"
 