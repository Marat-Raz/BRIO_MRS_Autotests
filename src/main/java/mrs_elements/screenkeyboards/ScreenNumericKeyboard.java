package mrs_elements.screenkeyboards;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenNumericKeyboard {
    public static AppiumDriver driver;
    private static final By SCREEN_NUMERIC_KEYBOARD = By.xpath("//KeyboardOverlayView/Border/" +
            "ContentPresenter/Canvas/Border/ContentControl/Border/ContentPresenter/Border");
    public ScreenNumericKeyboard(AppiumDriver driver) {
        this.driver = driver;
    }
    public void waitOpenScreenNumericKeyboard() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(SCREEN_NUMERIC_KEYBOARD));
        driver.findElement(SCREEN_NUMERIC_KEYBOARD).isDisplayed();
    }
    public boolean ScreenNumericKeyboardIsOpen() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SCREEN_NUMERIC_KEYBOARD));
        return driver.findElement(SCREEN_NUMERIC_KEYBOARD).isDisplayed();
    }
}
