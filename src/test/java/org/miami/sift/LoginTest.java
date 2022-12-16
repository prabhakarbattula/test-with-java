package org.miami.sift;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.miami.sift.constants.Constants;
import org.miami.sift.pageobjects.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;

//class Name starts with Capital Letter
// public class name needs to match File Name
public class LoginTest {
    ChromeDriver driver;
    LoginPage page;
    Constants constant = new Constants();

    @Before
    public void initPage() {
        driver = new ChromeDriver();
        page = new LoginPage(driver);
    }

    @After
    public void closePage() {
        driver.quit();
    }

    @Test
    public void wrongPassword() {
        driver.get(constant.baseUrl);
        page.login(constant.userName, constant.wrongPassword);
        Assert.assertEquals(constant.errorMessage, page.getCurrentErrorMessage());
    }

    @Test
    public void successfulLogin() {
        driver.get(constant.baseUrl);
        page.login(constant.userName, constant.password);

        Assert.assertEquals(constant.titleText, page.landingText());
    }
}
