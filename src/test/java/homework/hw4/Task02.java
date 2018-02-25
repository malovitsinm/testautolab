package homework.hw4;

import enums.hw4.page.ServiceOptionsEnum;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testBases.SelenideBase;

import static com.codeborne.selenide.Selenide.page;
import static entities.hw4.User.PITER;

@Listeners(AllureAttachmentListener.class)
@Features({"HW4: Selenide Test Suite"})
@Stories({"\"Dates page\" slider tests"})
public class Task02 extends SelenideBase {
    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeMethod
    public void initPageObjects() {
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void datePageSliderTest() {
        //2 Open test site by URL
        indexPage.open();

        //3 Perform login
        indexPage.login(PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLoggedUserName(PITER);

        //5 Open Service -> Dates
        indexPage.openPage(ServiceOptionsEnum.DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position	left - 0, right - 100
        // Check sliders values.	Assertion for sliders values must be implemented by 1 unified method
        datesPage.setAndCheckSliderJS(0, 100);
//        datesPage.setAndCheckSliders(0, 100);

        //7 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider -
        // the most left position.	left - 0, right - 0
        datesPage.setAndCheckSliderJS(0, 0);
//        datesPage.setAndCheckSlider(0, 0);

        //8 Using drag-and-drop set Range sliders. left sliders - the most right position,
        // right slider - the most right position.	 left - 100, right - 100
        datesPage.setAndCheckSliderJS(100, 100);
//        datesPage.setAndCheckSlider(100, 100);

        //9 Using drag-and-drop set Range sliders.	left - 30, right - 70
        datesPage.setAndCheckSliderJS(30, 70);
//        datesPage.setAndCheckSlider(30, 70);
    }
}
