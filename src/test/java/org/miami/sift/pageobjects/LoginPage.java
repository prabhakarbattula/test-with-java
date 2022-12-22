package org.miami.sift.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final String USER_NAME = "//*[(@id = \"user-name\")]";
    private static final String PASSWORD = "//*[(@id = \"password\")]";
    private static final String LOGIN_BUTTON = "//*[(@id = \"login-button\")]";
    private static final String ERROR_HEADER = "//h3";

    private static final String TITLE = ".title";

    @FindBy(xpath = USER_NAME)
    private WebElement userName;

    @FindBy(xpath = PASSWORD)
    private WebElement password;
    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(xpath = ERROR_HEADER)
    private WebElement errorHeader;

    @FindBy(css= TITLE)
    private WebElement titleName;

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
        return this.errorHeader.getText();
    }

    public String landingText() {
        return this.titleName.getText();
    }
}
