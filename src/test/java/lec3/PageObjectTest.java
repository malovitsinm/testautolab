package lec3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.IndexPage;

import static java.lang.System.setProperty;


public class PageObjectTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass
    public void setUp(){
        setProperty("webdriver.chrome.driver", "src\\main\\resourses\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void indexPageLoginContentsTest() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        indexPage.login("epam", "1234");
    }
}
