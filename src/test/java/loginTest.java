import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

    @Test
    public void wrongPassword() {
        System.setProperty("webdriver.chrome.driver","/Users/prabhakarbattula/Desktop/selenium-java-4.6.0/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

          Elements element = new Elements();
          Constants constant = new Constants();
          driver.get(constant.baseUrl);
          driver.findElementByXPath(element.userName).sendKeys(constant.userName);
          driver.findElementByXPath(element.password).sendKeys(constant.wrongPassword);
          driver.findElementByXPath(element.loginButton).click();
          driver.findElementByXPath(element.errorHeader).getText().contentEquals(constant.errorMessage);
          driver.quit();
    }
}
