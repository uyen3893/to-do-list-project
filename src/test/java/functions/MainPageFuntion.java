package functions;

import objects.MainPageObjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class MainPageFuntion extends MainPageObjects {

    private CommonFunction commonFunction;

    public MainPageFuntion(CommonFunction common) {
        this.commonFunction = common;
    }

    public String generateRandomString() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        String randomStr = "";
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomStr = randomStr + alphabet.charAt(new SecureRandom().nextInt(alphabet.length()));
        }
        return randomStr;
    }

    public void addList(int strNumber) {
        try {
            for (int i = 0; i < strNumber; i++) {
                commonFunction.sendkeys(INPUT_LIST_FIELD, generateRandomString());
                commonFunction.click(ADD_LIST_BUTTON);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteList(int startWith, int endWith) {
        try {
            List<WebElement> removeBtnList = commonFunction.findElements(REMOVE_BUTTON);
            for (int i = startWith; i < endWith; i++) {
                commonFunction.touchOnElement(removeBtnList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllList() {
        try {
            List<WebElement> removeBtnList = commonFunction.findElements(REMOVE_BUTTON);
            for (int i = 0; i < removeBtnList.size(); i++) {
                commonFunction.touchOnElement(removeBtnList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signOut() {
        try {
            commonFunction.click(LOGOUT_BUTTON);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyExistedList(int strNumber) {
        try {
            Assert.assertEquals(commonFunction.findElements(REMOVE_BUTTON).size(), strNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
