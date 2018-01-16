package homework.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.*;

public class Task01 {
    WebDriver driver;
    List<String> expectedImageTextValues = Arrays.asList(
            "To include good practices and ideas from successful EPAM projec",
            "To be flexible and customizable",
            "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void indexPageLoginContentsTest() {
        //2 Open test site by URL
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal [type = 'submit']")).click();

        //5 Assert User name in the left-top side of screen that user is loggined
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String userName = (String)js.executeScript(
                "return document.querySelector('.profile-photo > span:nth-child(3)').innerHTML;");
        assertEquals(userName,"Piter Chailovskii");
        /* NOTE TO REVIEWER:
           I've encountered some problems while trying to get capitalized name string using variations of the
           following code:
               WebElement userName = driver.findElement(By.cssSelector(".profile-photo > span:nth-child(3)")).getText();
           Does using jsExecutor make a suitable workaround?
        * */

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> imageTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(images.size(), 4);
        for (int i = 0; i < imageTexts.size(); i++) {
            assertTrue(imageTexts.get(i).isDisplayed());
            assertEquals(
                    imageTexts.get(i).getText().replaceAll("\n"," "),
                    expectedImageTextValues.get(i));
        }

        //9 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());

        //10 Close browser
        driver.close();
    }
}
