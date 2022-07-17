package functions;

import configuration.Config;
import objects.LoginGithubPageObjects;

import java.util.List;

public class LoginGithubFunction extends LoginGithubPageObjects {
    private CommonFunction commonFunction;

    public LoginGithubFunction(CommonFunction commonFunction) {
        this.commonFunction = commonFunction;
    }

    public void login() {
        try {
            //Signin github account on Github page
            commonFunction.click(SIGNIN_BUTTON);
            commonFunction.sendkeys(LOGIN_FIELD, Config.USERNAME);
            commonFunction.sendkeys(PASSWORD_FIELD, Config.PASSWORD);
            commonFunction.click(SUBMIT_SIGNIN_BUTTON);
            commonFunction.waitForLoad(5);

            //If the verification popup is appeared
            if (commonFunction.isDisplayed(OTP_INPUT_FIELD)) {
                //Get OTP from the email page
                commonFunction.openNewTab();
                commonFunction.navigate(Config.EMAIL_URL);
                commonFunction.click(FIRST_EMAIL);
                String message = commonFunction.getText(MESSAGE);
                String otpCode = commonFunction.getOTP(message);
                commonFunction.waitForLoad(5);
                //Input OTP code to access github page
                List<String> tabs = commonFunction.getHandleWindows();
                commonFunction.switchToAnotherTabs(tabs.get(0));
                commonFunction.sendkeys(OTP_INPUT_FIELD, otpCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
