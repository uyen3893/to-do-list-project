package testCases;

import configuration.Config;
import functions.LoginFunction;
import functions.LoginGithubFunction;
import functions.MainPageFunction;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MainFlowTest extends TestBase{

    public LoginFunction loginFuntion;
    public MainPageFunction mainPageFuntion;
    public LoginGithubFunction loginGithubFunction;

    @Test
    public void testCase () {
        //Initialize three objects
        loginGithubFunction = new LoginGithubFunction(commonFuntion);
        loginFuntion = new LoginFunction(commonFuntion);
        mainPageFuntion = new MainPageFunction(commonFuntion);
        //Login github account
        loginGithubFunction.login();
        //login to the to do list page
        loginFuntion.login();
        //add 10 random strings into the list
        mainPageFuntion.addList(Config.NUMBER_OF_STRING);
        mainPageFuntion.verifyExistedList(Config.NUMBER_OF_STRING);
        //sign out the to do list page
        mainPageFuntion.signOut();
        //login again
        loginFuntion.login();
        //delete the list from 5 - 10
        mainPageFuntion.deleteList(Config.BEGIN_INDEX, Config.END_INDEX);
        mainPageFuntion.verifyExistedList(Config.END_INDEX - Config.BEGIN_INDEX);
        //sign out again
        mainPageFuntion.signOut();
    }

    @AfterMethod
    public void cleanUp() {
        //login again and delete the rest of the list
        loginFuntion.login();
        mainPageFuntion.deleteAllList();
    }
}
