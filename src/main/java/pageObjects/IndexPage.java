package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement dropdownBtn;

    @FindBy(css = ".form-horizontal [type = 'submit']")
    private WebElement loginFormSubmit;

    public void login(String login, String password){
        dropdownBtn.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginFormSubmit.click();
    }

}
