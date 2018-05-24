Feature: Test of content AddToYourOrder page
#  Sekcja background gdy stepy sie powtarzaja w kazdym tescie

#  Background:
#    Given User is on Wordpress site "https://wordpress.com"
#    When User clicks on login button
#    Then Email login page is displayed

    @wordpress @login
  Scenario: Checking of CartSubtotal content
    Given User is on Wordpress website "https://wordpress.com"
    When User clicks on login button
    Then Email login page is displayed
    When User enters email and clicks continue button
    Then Password login page is displayed
    When User enters password and presses Log in button
    Then Main logged page is displayed
#    When User press avatar
#    Then Personal page is displayed
#    When User clicks notifications icon
#    Then Notification page is displayed
#    When User presses checkbox
#    Then Checkbox is deselected
