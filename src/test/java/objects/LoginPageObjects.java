package objects;

import org.openqa.selenium.By;

public class LoginPageObjects {
    protected final By LOGIN_GITHUB_BUTTON = By.xpath("//a[@class='btn btn-social btn-github']");
    protected final By LOGIN_FIELD = By.xpath("//input[@name='login']");
    protected final By PASSWORD_FIELD = By.xpath("//input[@name='password']");
    protected final By SIGNIN_BUTTON = By.xpath("//input[@type='submit']");
    protected final By AUTHORIZE_BUTTON = By.cssSelector("#js-oauth-authorize-btn");
}
