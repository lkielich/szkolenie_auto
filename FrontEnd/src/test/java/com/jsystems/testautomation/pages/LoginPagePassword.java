package com.jsystems.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePassword extends BasePage {

    public LoginPagePassword(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(css="button.button.form-button.is-primary")
    public WebElement logInButton;
}
