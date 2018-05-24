package com.jsystems.testautomation.tests;

import com.jsystems.testautomation.Configuration;
import com.jsystems.testautomation.FrontendConfig;
import com.jsystems.testautomation.pages.LoginPageEmail;
import com.jsystems.testautomation.pages.LoginPagePassword;
import com.jsystems.testautomation.pages.MainLoggedPage;
import com.jsystems.testautomation.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrontendMainPageTest extends FrontendConfig {

    MainPage mainPage;
    LoginPageEmail loginPageEmail;
    LoginPagePassword loginPagePassword;
    MainLoggedPage mainLoggedPage;

    @Test
    @DisplayName("Main page content test")
    public void contentMainPageTest() {
        driver.get("https://wordpress.com/");
        mainPage = new MainPage(driver);
        mainPage.isContentPresent();
    }

    @Test
    @DisplayName("Login test")
    public void loginTest(){
        driver.get(Configuration.WORDPRESS_URL);
        mainPage=new MainPage(driver);
        mainPage.loginButton.click();
        loginPageEmail = new LoginPageEmail(driver);
        loginPageEmail.emailField.sendKeys(Configuration.WORDPRESS_EMAIL);
        //loginPageEmail.waitForVisibilityOfElement(loginPageEmail.continueButton,15);
        loginPageEmail.continueButton.click();
        loginPagePassword = new LoginPagePassword(driver);
        loginPagePassword.passwordField.sendKeys(Configuration.WORDPRESS_PASSWD);
        loginPagePassword.logInButton.click();
        mainLoggedPage= new MainLoggedPage(driver);
        mainLoggedPage.isContentPresent();

    }


}
