package com.jsystems.testautomation.frontendBDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEmail extends BasePage {

    public LoginPageEmail(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id="usernameOrEmail")
    public WebElement emailField;

    @FindBy(css="button.form-button.is-primary")
    public WebElement continueButton;

}
