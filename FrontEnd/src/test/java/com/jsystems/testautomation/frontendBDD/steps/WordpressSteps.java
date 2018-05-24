package com.jsystems.testautomation.frontendBDD.steps;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.frontendBDD.pages.LoginPagePassword;
import com.jsystems.testautomation.frontendBDD.pages.MainLoggedPage;
import com.jsystems.testautomation.frontendFactory.pages.LoginPageEmail;
import com.jsystems.testautomation.frontendFactory.pages.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class WordpressSteps extends BaseSteps {
MainPage mainPage;
LoginPageEmail loginPageEmail;
LoginPagePassword loginPagePassword;
MainLoggedPage mainLoggedPage;

    public WordpressSteps(StepsConfig config) {
        super (config);
        try {
            driver = config.setUp();
        } catch (Exception e) {
            e.printStackTrace();
                System.out.println(config.id);
        }
    }

//    @Given("User is on wordpress website \"(.*)\"$")
//    public void userIsOnWordPressWebsite(String website){
//        driver.get(Configuration.WORDPRESS_URL);
//        mainPage = new MainPage(driver);
//
//    }

    @Given("^User is on Wordpress website \"([^\"]*)\"$")
    public void userIsOnWordpressWebsite(String arg0) {
        driver.get(Configuration.WORDPRESS_URL);
        mainPage = new MainPage(driver);
    }

    @When("^User clicks on login button$")
    public void userClicksOnLoginButton(){
        mainPage.loginButton.click();
    }
//
    @Then("^Email login page is displayed$")
    public void emailLoginPageIsDisplayed() {
        loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.emailField.isDisplayed();
    }

    @When("^User enters email and clicks continue button$")
    public void userEntersEmailAndClicksContinueButton() {
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPageEmail.continueButton.click();
    }

    @Then("^Password login page is displayed$")
    public void passwordLoginPageIsDisplayed() {
        loginPagePassword= new LoginPagePassword(driver);
        loginPagePassword.passwordField.isDisplayed();

    }

    @When("^User enters password and presses Log in button$")
    public void userEntersPasswordAndPressesLogInButton() {
        loginPagePassword.passwordField.sendKeys(Configuration.WORDPRESS_PASSWD);
        loginPagePassword.logInButton.click();
    }

    @Then("^Main logged page is displayed$")
    public void mainLoggedPageIsDisplayed() {
        mainLoggedPage = new MainLoggedPage(driver);
        mainLoggedPage.avatarIcon.isDisplayed();
    }

//
//    @When("^User press avatar$")
//    public void userPressAvatar() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Personal page is displayed$")
//    public void personalPageIsDisplayed() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^User clicks notifications icon$")
//    public void userClicksNotificationsIcon() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Notification page is displayed$")
//    public void notificationPageIsDisplayed() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^User presses checkbox$")
//    public void userPressesCheckbox() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^Checkbox is deselected$")
//    public void checkboxIsDeselected() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
