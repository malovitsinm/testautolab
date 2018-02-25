package homework.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.hw4.diff_elements.CheckboxTextEnum;
import enums.hw4.diff_elements.DropdownTextEnum;
import enums.hw4.diff_elements.LogEntriesEnum;
import enums.hw4.diff_elements.RadiobuttonTextEnum;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection natureForceCheckboxCollection;

    @FindBy(css = ".label-radio input")
    private ElementsCollection metalRadioBtnCollection;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdownColorsMenu;

    @FindBy(css = ".colors .uui-form-element option")
    private ElementsCollection dropdownColorsOptions;

    @FindBy(css = ".logs li")
    private ElementsCollection logsCollection;

    @FindBy(css = "aside ._mCS_1")
    private SelenideElement leftSection;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttonCollection;

    public void clickOnCheckbox(CheckboxTextEnum checkboxValue) {
        natureForceCheckboxCollection.get(checkboxValue.ordinal()).click();
    }

    public void clickMetalRadioBtn(RadiobuttonTextEnum radioValue) {
        metalRadioBtnCollection.get(radioValue.ordinal()).click();
    }

    public void selectColorOption(DropdownTextEnum colorValue) {
        dropdownColorsMenu.click();
        dropdownColorsOptions.get(colorValue.ordinal()).click();
    }

    public void isChecked(CheckboxTextEnum checkboxValue, boolean isChecked) {
        Condition condition = isChecked ? checked : not(checked);
        natureForceCheckboxCollection.get(checkboxValue.ordinal()).should(condition);
    }

    public void checkLogs(int startIndex, int logLength) {
        LogEntriesEnum[] enumValue = LogEntriesEnum.values();
        for (int i = startIndex; i < logLength; i++) {
            assertEquals(
                    logsCollection.get(i).getText().substring(9).replaceAll(" .* ",""),
                    enumValue[startIndex + i].text);
        }
    }

    public void checkElementsExistence() {
        natureForceCheckboxCollection.shouldHave(size(CheckboxTextEnum.values().length));
        natureForceCheckboxCollection.forEach(
                s -> assertTrue(CheckboxTextEnum.getTextList().contains(s.getText())));
        metalRadioBtnCollection.shouldHave(size(RadiobuttonTextEnum.values().length));
        metalRadioBtnCollection.forEach(
                s -> assertTrue(RadiobuttonTextEnum.getTextList().contains(s.getText())));
        buttonCollection.shouldHave(size(2));
        rightSection.should(be(visible));
        leftSection.should(be(visible));
    }

}
