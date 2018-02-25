package homework.hw4;

import com.codeborne.selenide.*;
import entities.hw4.User;
import enums.hw4.page.BenefitTextEnum;
import enums.hw4.page.ServiceOptionsEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    @Step
    public void login(User user) {
        dropdownBtn.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginFormSubmit.click();
    }

    @Step
    public void checkLoggedUserName(User user) {
        userNameLogged.shouldHave(exactText(user.getName()));
    }

    @Step
    public void checkServiceHeaderDropdownMenuText() {
        ServiceOptionsEnum[] textValues = ServiceOptionsEnum.values();
        for (int i = 0; i < serviceMenuDropdownItems.size(); i++) {
            serviceMenuDropdownItems.get(i).shouldHave(text(textValues[i].text));
        }
    }

    @Step
    public void checkServiceSubmenuText() {
        ServiceOptionsEnum[] textValues = ServiceOptionsEnum.values();
        for (int i = 0; i < serviceSubmenuItems.size(); i++) {
            serviceSubmenuItems.get(i).shouldHave(text(textValues[i].text));
        }
    }

    @Step
    public void checkBenefitsImgs(){
        benefitImages.shouldHave(size(BenefitTextEnum.values().length));
        benefitImagesTexts.shouldHave(size(BenefitTextEnum.values().length));
        for(int i = 0; i < benefitImagesTexts.size(); i++) {
            //A bit of regex shamanism to clean up all html tags and line breaks
            String formatted = benefitImagesTexts.get(i).getText().replaceAll("<[^>]*>","").replaceAll("\n", " ");
            Assert.assertEquals(formatted, BenefitTextEnum.values()[i].text);
        }
    }

    @Step
    public void checkTitleText() {
        mainTitle.should(be(visible));
        mainTitleText.should(be(visible));
    }
    @Step
    public void openServiceHeaderDropdown() {
        serviceHeaderButton.click();
    }

    @Step
    public void openServiceAsideMenu() {
        serviceAsideButton.click();
    }

    @Step
    public void openPage(ServiceOptionsEnum menuItem) {
        openServiceHeaderDropdown();
        serviceMenuDropdownItems.get(menuItem.ordinal()).click();
    }
}
