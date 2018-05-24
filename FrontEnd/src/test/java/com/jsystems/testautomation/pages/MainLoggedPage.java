package com.jsystems.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainLoggedPage extends BasePage {

    WebDriver driver;

    public MainLoggedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "svg.gridicon.gridicons-user-circle")
    public WebElement avatarIcon;

    public boolean isContentPresent(){
        assertTrue(avatarIcon.isDisplayed());
        return true;
    }
}