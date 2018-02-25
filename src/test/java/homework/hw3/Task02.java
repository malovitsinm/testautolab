package homework.hw3;

import enums.hw4.page.TextEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class Task02 {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        //10 Close browser
        driver.close();
    }

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void indexPageLoginContentsTest() {
        //2 Open test site by URL
        indexPage.open();

        //3 Assert Browser title
        indexPage.checkBrowserTitle("Index Page");

        //4 Perform login
        indexPage.performLogin("epam", "1234");

        //5 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkUserName("PITER CHAILOVSKII");

        //6 Assert Browser title
        indexPage.checkBrowserTitle("Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkBenefitImagesCount(4);
        indexPage.checkBenefitImagesDisplay(true);

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkBenefitImagesTextsCount(4);
        indexPage.checkBenefitImagesTexts(TextEnum.values());

        //9 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkHeaderDisplayed(true);
        indexPage.checkHeaderTextDisplayed(true);
    }
}
