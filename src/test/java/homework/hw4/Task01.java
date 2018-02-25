package homework.hw4;

import listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testBases.SelenideBase;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static entities.hw4.User.PITER;
import static enums.hw4.diff_elements.CheckboxTextEnum.WATER;
import static enums.hw4.diff_elements.CheckboxTextEnum.WIND;
import static enums.hw4.diff_elements.DropdownTextEnum.YELLOW;
import static enums.hw4.diff_elements.RadiobuttonTextEnum.SELEN;
import static enums.hw4.page.ServiceOptionsEnum.*;


@Listeners(AllureAttachmentListener.class)
@Features({"HW4: Selenide Test Suite"})
@Stories({"\"Different elements page\" tests"})
public class Task01 extends SelenideBase {

    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;


    @BeforeMethod
    public void initPageObjects() {
        indexPage = page(IndexPage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void tearDown(){
        close();
    }


    @Test
    public void indexPageLoginServiceTest(){
        //2 Open test site by URL
        indexPage.open();

        //3 Perform login
        indexPage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLoggedUserName(PITER);

        //5 Check interface on Home page, it contains all needed elements
        indexPage.checkBenefitsImgs();
        indexPage.checkTitleText();

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.openServiceHeaderDropdown();
        indexPage.checkServiceHeaderDropdownMenuText();

        //7 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.openServiceAsideMenu();
        indexPage.checkServiceSubmenuText();

        //8 Open through the header menu Service -> Different Elements Page
        indexPage.openPage(DIF_ELEMS);

        //9 Check interface on Service page, it contains all needed elements.
        differentElementsPage.checkElementsExistence();

        //10 Select and assert checkboxes: Water, Wind
        differentElementsPage.checkCheckBox(WATER);
        differentElementsPage.isChecked(WATER, true);
        differentElementsPage.checkCheckBox(WIND);
        differentElementsPage.isChecked(WIND, true);

        //11 Select radio: Selen
        differentElementsPage.selectMetalRadio(SELEN);

        //12 Select in dropdown : Yellow
        differentElementsPage.selectColorOption(YELLOW);

        //13 Check in logs section selected values and status (true|false)
        differentElementsPage.checkLogs(0, 4);

        //14 Unselect and assert checkboxes : Water, Wind
        differentElementsPage.checkCheckBox(WATER);
        differentElementsPage.isChecked(WATER, false);
        differentElementsPage.checkCheckBox(WIND);
        differentElementsPage.isChecked(WIND, false);

        //15 Check in logs section unselected values and status (true|false)
        differentElementsPage.checkLogs(4, 2);
    }

}
