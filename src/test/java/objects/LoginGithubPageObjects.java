package objects;

import org.openqa.selenium.By;

public class LoginGithubPageObjects {
    protected final By SIGNIN_BUTTON = By.xpath("//a[@href='/login']");
    protected final By LOGIN_FIELD = By.xpath("//input[@name='login']");
    protected final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    protected final By SUBMIT_SIGNIN_BUTTON = By.xpath("//input[@type='submit']");
    protected final By OTP_INPUT_FIELD = By.cssSelector("#otp");

    protected final By FIRST_EMAIL = By.xpath("//a[contains(@class,'list-group-item')][1]");
    protected final By MESSAGE = By.xpath("//div[contains(@id,'message_full')][1]");

}
