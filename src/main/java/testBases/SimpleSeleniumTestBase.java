package testBases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;

public abstract class SimpleSeleniumTestBase {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        driver.close();
    }


}

