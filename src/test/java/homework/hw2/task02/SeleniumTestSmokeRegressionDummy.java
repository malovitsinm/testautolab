package homework.hw2.task02;

import org.openqa.selenium.WebDriver;
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
        driver.navigate().to("https://jdi-framework.github.io/tests");
        Assert.assertEquals(driver.getTitle(), "Index Page");
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
