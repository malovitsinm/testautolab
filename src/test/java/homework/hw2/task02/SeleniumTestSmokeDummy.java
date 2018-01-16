package homework.hw2.task02;

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
public class SeleniumTestSmokeDummy {
    @Test(groups = {"Smoke"})
    public void chromeTest(){
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        WebElement element = driver.findElement(By.cssSelector(".header-search__button")); // Можно коллекцией через List
        element.click();
        driver.close();
    }

    @Test(groups = {"Smoke"})
    public void smokeEqualsAssert(){
        Assert.assertEquals("Smoke!", "Smoke!");
    }

}
