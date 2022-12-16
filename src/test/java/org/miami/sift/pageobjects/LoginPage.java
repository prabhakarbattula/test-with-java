package org.miami.sift.pageobjects;

import org.miami.sift.constants.SelectorConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final String USER_NAME = "//*[(@id = \"user-name\")]";
    private static final String PASSWORD = "//*[(@id = \"password\")]";
    private static final String LOGIN_BUTTON = "//*[(@id = \"login-button\")]";
    @FindBy(xpath = USER_NAME)
    private WebElement userName;

    @FindBy(xpath = PASSWORD)
    private WebElement password;
    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userNameValue, String passwordValue) {
        userName.sendKeys(userNameValue);
        password.sendKeys(passwordValue);
        loginButton.click();
    }

    public String getCurrentErrorMessage() {
        return driver.findElement(By.xpath(SelectorConstants.ERROR_HEADER)).getText();
    }
}
