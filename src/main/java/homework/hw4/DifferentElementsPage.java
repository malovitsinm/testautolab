package homework.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DifferentElementsCheckboxTextEnum;
import enums.DifferentElementsDropdownTextEnum;
import enums.DifferentElementsLogEntriesEnum;
import enums.DifferentElementsRadiobuttonTextEnum;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxCollection;

    @FindBy(css = ".label-radio input")
    private ElementsCollection radioBtnCollection;

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

    public void setCheckboxInput(DifferentElementsCheckboxTextEnum checkboxValue) {
        checkboxCollection.get(checkboxValue.ordinal()).click();
    }

    public void setRadioInput(DifferentElementsRadiobuttonTextEnum radioValue) {
        radioBtnCollection.get(radioValue.ordinal()).click();
    }

    public void selectColorOption(DifferentElementsDropdownTextEnum colorValue) {
        dropdownColorsMenu.click();
        dropdownColorsOptions.get(colorValue.ordinal()).click();
    }

    public void checkIfCheckboxChecked(DifferentElementsCheckboxTextEnum checkboxValue, boolean isChecked) {
        Condition condition = isChecked ? checked : not(checked);
        checkboxCollection.get(checkboxValue.ordinal()).should(condition);
    }

    public void checkLogs(DifferentElementsLogEntriesEnum[] enumValue, int startIndex, int logLength) {
        for (int i = startIndex; i < logLength; i++) {
            assertEquals(
                    logsCollection.get(i).getText().substring(9).replaceAll(" .* ",""),
                    enumValue[startIndex + i].text);
        }
    }

    public void checkElementsExistence() {
        checkboxCollection.shouldHave(size(4));
        radioBtnCollection.shouldHave(size(4));
        buttonCollection.shouldHave(size(2));
        rightSection.should(be(visible));
        leftSection.should(be(visible));
    }

}
