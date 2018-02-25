package homework.hw4;

import com.codeborne.selenide.*;
import entities.hw4.User;
import enums.hw4.page.BenefitTextEnum;
import enums.hw4.page.ServiceOptionsEnum;
import org.openqa.selenium.support.FindBy;

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

    public void login(User user) {
        dropdownBtn.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        loginFormSubmit.click();
    }

    public void checkLoggedUserName(User user) {
        userNameLogged.shouldHave(exactText(user.getName()));
    }

    public void checkServiceHeaderDropdownMenuText() {
        ServiceOptionsEnum[] textValues = ServiceOptionsEnum.values();
        for (int i = 0; i < serviceMenuDropdownItems.size(); i++) {
            serviceMenuDropdownItems.get(i).shouldHave(text(textValues[i].text));
        }
    }

    public void checkServiceSubmenuText() {
        ServiceOptionsEnum[] textValues = ServiceOptionsEnum.values();
        for (int i = 0; i < serviceSubmenuItems.size(); i++) {
            serviceSubmenuItems.get(i).shouldHave(text(textValues[i].text));
        }
    }


    public void checkBenefitsImgs(){
        benefitImages.shouldHave(size(BenefitTextEnum.values().length));
        benefitImagesTexts.shouldHave(size(BenefitTextEnum.values().length));
        for(int i = 0; i < benefitImagesTexts.size(); i++) {
            benefitImagesTexts.get(i).shouldHave(text(BenefitTextEnum.values()[i].text));
        }
    }

    private void checkBenefitImageCount() {
        benefitImages.shouldHave(size(BenefitTextEnum.values().length));
    }

//    public void checkBenefitImageTextCount(int count) {
//        benefitImagesTexts.shouldHave(size(count));
//    }

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

    public void openPage(ServiceOptionsEnum menuItem) {
        openServiceHeaderDropdown();
        serviceMenuDropdownItems.get(menuItem.ordinal()).click();
    }
}
