package functions;

import configuration.Config;
import objects.LoginPageObjects;

public class LoginFunction extends LoginPageObjects {
    private CommonFunction commonFunction;

    public LoginFunction(CommonFunction common) {
        this.commonFunction = common;
    }

    public void login() {
        try {
            //Navigate to the to do list page
            commonFunction.navigate(Config.URL);
            commonFunction.click(LOGIN_GITHUB_BUTTON);

            //If the sign in github is appeared
            if (commonFunction.isDisplayed(LOGIN_FIELD)) {
                commonFunction.sendkeys(LOGIN_FIELD, Config.USERNAME);
                commonFunction.sendkeys(PASSWORD_FIELD, Config.PASSWORD);
                commonFunction.click(SIGNIN_BUTTON);
                commonFunction.waitForLoad(5);
            }

            //If the Authorize popup is appeared
            if (commonFunction.isDisplayed(AUTHORIZE_BUTTON)) {
                commonFunction.click(AUTHORIZE_BUTTON);
            }
            commonFunction.waitForLoad(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
