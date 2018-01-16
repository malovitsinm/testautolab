package homework.hw2.task02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

@Test
public class SeleniumTestSmokeRegressionDummy {
    @Test(groups = {"Smoke", "Regression"})
    public void chromeTest(){
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        WebElement element = driver.findElement(By.cssSelector(".header-search__button")); // Можно коллекцией через List
        element.click();
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void trueAssert(){
        Assert.assertTrue(true);
    }

    @Test(groups = {"Smoke"})
    public void falseAssert(){
        Assert.assertFalse(false);
    }


    @Test(groups = {"Regression"})
    public void equalAssert(){
        Assert.assertEquals(1337,1337);
    }
}
