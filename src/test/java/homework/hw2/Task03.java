package homework.hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.System.setProperty;

public class Task03 {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
    }

    @BeforeTest
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void displaySysTime() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterMethod
    public void displayTitle() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @AfterSuite
    public void tearDown() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void navigateToSetURL() {
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(),
                "EPAM | Software Product Development Services");

    }
}
