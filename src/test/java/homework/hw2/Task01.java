package homework.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBases.SimpleSeleniumTestBase;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task01 extends SimpleSeleniumTestBase {

    @DataProvider(parallel = true)
    public Object[][] dpImagesTextContentTest() {
        return new Object[][]{
                {"To include good practices and ideas from successful EPAM projec"},
                {"To be flexible and customizable"},
                {"To be multiplatform"},
                {"Already have good base (about 20 internal and some external projects), wish to get more…"}};
    }

    @Test(dataProvider = "dpImagesTextContentTest")
    public void imagesTextContentTest(String expectedString) {
        List<String> imagesTexts = driver.findElements(By.cssSelector(".benefit-txt"))
                .stream()
                .map(e -> e.getText().replaceAll("\n", " "))
                .collect(Collectors.toList());
        Assert.assertTrue(imagesTexts.contains(expectedString));
    }
}
