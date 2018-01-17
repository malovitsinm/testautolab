package homework.hw2.task02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;
import static org.testng.Assert.*;

@Test
public class SeleniumTestSmokeDummy {

    @Test(groups = {"Smoke"})
    public void chromeTest(){
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        assertEquals(driver.getTitle(), "Index Page");
        driver.close();
    }

    @Test(groups = {"Smoke"})
    public void smokeEqualsAssert(){
        assertEquals("Smoke!", "Smoke!");
    }

}
