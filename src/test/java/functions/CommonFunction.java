package functions;

import configuration.Config;
import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonFunction {

    public WebDriver driver;


    public WebDriver launchBrowser () {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if(OS.isFamilyMac()) {
            chromeDriverLocation = currentProjectLocation.concat(Config.CHROMEDRIVER_PATH_MAC) + "/chromedriver";
        }

        if (OS.isFamilyWindows()) {
            chromeDriverLocation = currentProjectLocation.concat(Config.CHROMEDRIVER_PATH_WIN) + "\\chromedriver.exe";
        }

        if (chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS type!");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigate (String url) {
        driver.get(url);
    }

    public List<String> getHandleWindows() {
        return new ArrayList<>(driver.getWindowHandles());
    }
    public void switchToAnotherTabs(String tab) {
        driver.switchTo().window(tab);
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void waitForLoad(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public List<WebElement> findElements(By elements) {
        return driver.findElements(elements);
    }

    public void touchOnElement(WebElement element) {
        element.click();
    }

    public void click(By element) {
        find(element).click();
    }

    public void sendkeys(By element, String keyword) {
        find(element).clear();
        find(element).sendKeys(keyword);
    }

    public boolean isDisplayed(By element) {
        boolean isDisplayed;
        try {
            isDisplayed = find(element).isDisplayed();
        } catch (Exception e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String getText(By element) {
        return driver.findElement(element).getText().trim();
    }

    public List extractNumberChar(String oldString) {
        char[] charArray = oldString.toCharArray();
        List<Character> newCharArray = new ArrayList<>();
        for (char character : charArray) {
            if (Character.isDigit(character)) {
                newCharArray.add(character);
            }
        }
        return newCharArray;
    }

    public String convertCharToString(List<Character> charArray) {
        String newString = "";
        for (char character: charArray) {
            newString += character;
        }
        return newString;
    }

    public String getOTP(String message) {
        String OtpCode = "";
        try {
            int beginIndex = message.indexOf("code: ");
            String OTP = message.substring(beginIndex,(beginIndex + 12));
            OtpCode = convertCharToString(extractNumberChar(OTP));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OtpCode;
    }
}
