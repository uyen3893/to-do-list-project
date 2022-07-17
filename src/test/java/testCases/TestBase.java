package testCases;

import configuration.Config;
import functions.CommonFunction;
import functions.LoginGithubFunction;
import objects.LoginGithubPageObjects;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public CommonFunction commonFuntion;

    @BeforeMethod
    public void setup() {
        commonFuntion = new CommonFunction();
        commonFuntion.launchBrowser();
        commonFuntion.navigate(Config.GITHUB_URL);
        commonFuntion.maximizeWindow();
    }

    @AfterMethod
    public void quit() {
        commonFuntion.closeBrowser();
    }
}
