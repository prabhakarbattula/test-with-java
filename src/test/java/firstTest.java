import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTest {

    @Test
    public void firstTest1() {
        System.setProperty("webdriver.chrome.driver","/Users/prabhakarbattula/Desktop/selenium-java-4.6.0/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

          Elements element = new Elements();
          Constants constant = new Constants();
          driver.get(constant.baseUrl);
          driver.findElementByXPath(element.userName).sendKeys(constant.userName);
          driver.findElementByXPath(element.password).sendKeys(constant.password);
          driver.findElementByXPath(element.loginButton).click();
          driver.quit();
    }
}
