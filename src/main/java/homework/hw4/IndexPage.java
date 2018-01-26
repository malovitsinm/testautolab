package homework.hw4;

import com.codeborne.selenide.*;
import enums.IndexPageServiceOptionsEnum;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class IndexPage {
    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement dropdownBtn;

    @FindBy(css = ".form-horizontal [type = 'submit']")
    private SelenideElement loginFormSubmit;

    @FindBy(css = ".profile-photo > span")
    private SelenideElement userNameLogged;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeaderButton;

    @FindBy(css = ".m-l8 .dropdown-menu li")
    private ElementsCollection serviceMenuDropdownItems;

    @FindBy(css = ".sub-menu")
    private SelenideElement serviceAsideButton;

    @FindBy(css = ".sub-menu li")
    private ElementsCollection serviceSubmenuItems;

    @FindBy(css = ".m-l8 .dropdown-menu li [href ^= 'page8']")
    private SelenideElement differentPageLink;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection benefitImages;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection benefitImagesTexts;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainTitleText;


    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    public void performLogin(String login, String password) {
        dropdownBtn.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginFormSubmit.click();
    }

    public void checkLoggedUserName(String userName) {
        userNameLogged.shouldHave(exactText(userName));
    }

    public void checkServiceHeaderDropdownMenuText(IndexPageServiceOptionsEnum[] textValues) {
        for (int i = 0; i < serviceMenuDropdownItems.size(); i++) {
            serviceMenuDropdownItems.get(i).shouldHave(text(textValues[i].text));
        }
    }

    public void checkServiceSubmenuText(IndexPageServiceOptionsEnum[] textValues) {
        for (int i = 0; i < serviceSubmenuItems.size(); i++) {
            serviceSubmenuItems.get(i).shouldHave(text(textValues[i].text));
        }
    }

    public void checkBenefitImageCount(int count) {
        benefitImages.shouldHave(size(count));
    }

    public void checkBenefitImageTextCount(int count) {
        benefitImagesTexts.shouldHave(size(count));
    }

    public void checkTitleText() {
        mainTitle.should(be(visible));
        mainTitleText.should(be(visible));
    }

    public void openServiceHeaderDropdown() {
        serviceHeaderButton.click();
    }

    public void openServiceAsideMenu() {
        serviceAsideButton.click();
    }

    public void redirectToServiceMenuItemPage(IndexPageServiceOptionsEnum menuItem) {
        openServiceHeaderDropdown();
        serviceMenuDropdownItems.get(menuItem.ordinal()).click();
    }
}
