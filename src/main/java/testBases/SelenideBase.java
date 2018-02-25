package testBases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {


    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        //The following parameters are critical for making a stable testing model
        Configuration.timeout = 15000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
    }
}
