package lec4;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import testBases.SelenideBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Test
public class SelenideTest extends SelenideBase {

    @AfterMethod
    public void closeBrowser() {
        close();
    }

    @Test
    public void chromeTest0() {
        open("https://jdi-framework.github.io/tests");
        assertEquals(getWebDriver().getTitle(), "Index Page");

        $(".icon-search").click(); // Можно коллекцией через List

        $(".search-active").should(text("Search this Site"));
    }


    @Test
    public void chromeTest1() {
        open("https://jdi-framework.github.io/tests");
        assertEquals(getWebDriver().getTitle(), "Index Page");
        $(".icon-search").click(); // Можно коллекцией через List
        SelenideElement searchBar = $(".search-active");
        searchBar.should(text("Search this Site"));
    }


    @Test
    public void chromeTest2() {
        open("https://jdi-framework.github.io/tests");
        assertEquals(getWebDriver().getTitle(), "Index Page");
        $(".icon-search").click(); // Можно коллекцией через List
        SelenideElement searchBar = $(".search-active");
        searchBar.should(text("Search this Site"));
    }
}
