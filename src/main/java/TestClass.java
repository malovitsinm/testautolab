import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
@Test
public class TestClass {
    @Test
    public void chromeTest(){
        //setProperty("webdriver.chrome.driver", "%FILEPATH%"); // ситуация, в которой драйвер лежит бог знает где
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        WebElement element = driver.findElement(By.cssSelector(".header-search__button")); // Можно коллекцией через List
        element.click();
        driver.close();
    }

    @Test
    public void simpleTest(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://epam.com");
        driver.close(); // закрыть конкретное окно
        //driver.quit(); // убить драйвер
    }


    @Test(enabled = false)
    public void capabilitiesTest(){
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer(); // пресет каких-то спецефичных предварительных параметров
        cap.setBrowserName("");
        cap.setVersion("");
        new InternetExplorerDriver(cap);
    }
}
