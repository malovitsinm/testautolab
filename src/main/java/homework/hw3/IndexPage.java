package homework.hw3;

import enums.hw4.page.TextEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class IndexPage {
    private WebDriver driver;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement dropdownBtn;

    @FindBy(css = ".form-horizontal [type = 'submit']")
    private WebElement loginFormSubmit;

    @FindBy(css = ".profile-photo > span")
    private WebElement userNameLogged;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainTitleText;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitImagesTexts;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public void performLogin(String login, String password) {
        dropdownBtn.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginFormSubmit.click();
    }

    public void checkBrowserTitle(String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void checkUserName(String expectedUserName) {
        assertEquals(userNameLogged.getText(), expectedUserName);
    }

    public void checkBenefitImagesCount(int count) {
        assertEquals(count, benefitImages.size());
    }

    public void checkBenefitImagesDisplay(boolean isDisplayed) {
        for (WebElement image : benefitImages) {
            assertEquals(image.isDisplayed(), isDisplayed);
        }
        benefitImages.forEach(i -> assertTrue(i.isDisplayed()));
    }

    public void checkBenefitImagesTextsCount(int count) {
        assertEquals(count, benefitImagesTexts.size());
    }

    public void checkBenefitImagesTexts(TextEnum[] textEnum) {
        for (int i = 0; i < 4; i++) {
            assertEquals(textEnum[i].text, benefitImagesTexts.get(i).getText().replaceAll("\n", " "));
        }
    }

    public void checkHeaderDisplayed(boolean isDisplayed) {
        assertEquals(mainTitle.isDisplayed(), isDisplayed);
    }

    public void checkHeaderTextDisplayed(boolean isDisplayed) {
        assertEquals(mainTitleText.isDisplayed(), isDisplayed);
    }
}
