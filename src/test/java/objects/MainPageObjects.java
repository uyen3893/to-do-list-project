package objects;

import org.openqa.selenium.By;

public class MainPageObjects {

    protected final By INPUT_LIST_FIELD = By.xpath("//div[contains(text(),'Todo Lists')]/following-sibling::div/div/input");
    protected final By ADD_LIST_BUTTON = By.xpath("//div[contains(text(),'Todo Lists')]/following-sibling::div/div/button");
    protected final By REMOVE_BUTTON = By.xpath("//button[contains(@class,'remove')]");
    protected final By LOGOUT_BUTTON = By.xpath("//button[@class='btn btn-default']");

}
