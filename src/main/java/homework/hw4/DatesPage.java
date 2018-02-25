package homework.hw4;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import testBases.SelenideBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DatesPage extends SelenideBase{

    @FindBy(css = ".uui-slider > a")
    private ElementsCollection sliders;

    @Step
    public void setAndCheckSliderJS(Integer leftPos, Integer rightPos) {
        executeJavaScript("scroll(0, document.body.scrollHeight);");

        executeJavaScript("$('.ui-slider').slider('values', 0, '" + leftPos.toString() + "')");
        executeJavaScript("$('.ui-slider').slider('values', 1, '" + rightPos.toString() + "')");

        executeJavaScript("document.querySelector('a.ui-slider-handle:nth-child(1) > span:nth-child(1)').innerHTML = " +
                "$('.ui-slider').slider('values')[0]");
        executeJavaScript("document.querySelector('a.ui-slider-handle:nth-child(3) > span:nth-child(1)').innerHTML = " +
                "$('.ui-slider').slider('values')[1]");

        sliders.get(0).should(text(leftPos.toString()));
        sliders.get(1).should(text(rightPos.toString()));
    }

    @Step
    public void setAndCheckSliders(Integer leftPos, Integer rightPos) {
        executeJavaScript("scroll(0, document.body.scrollHeight);");

        actions().dragAndDropBy(sliders.get(0), -1000, 0).dragAndDropBy(sliders.get(1), 1000, 0).build().perform();

        double step = $(".uui-slider").getSize().getWidth() / 100.0;
        double delta = step / 2.0;

        if (leftPos != 0) {
            actions().dragAndDropBy(sliders.get(0), (int) (leftPos * step - delta), 0).perform();
        }
        if (rightPos != 100) {
            actions().dragAndDropBy(sliders.get(1), (int) ((-100 + rightPos) * step - step), 0).perform();
        }

        sliders.get(0).should(text(leftPos.toString()));
        sliders.get(1).should(text(rightPos.toString()));
    }
}
