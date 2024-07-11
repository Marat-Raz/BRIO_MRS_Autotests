package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ScreenNumericKeyboard {
    public static AppiumDriver driver;
    private static final By SCREEN_NUMERIC_KEYBOARD = By.xpath("//KeyboardOverlayView/Border/" +
            "ContentPresenter/Canvas/Border/ContentControl/Border/ContentPresenter");
    public ScreenNumericKeyboard(AppiumDriver driver) {
        this.driver = driver;
    }
    public void waitOpenScreenNumericKeyboard() {
        driver.findElement(SCREEN_NUMERIC_KEYBOARD).isDisplayed();
    }
    public boolean ScreenNumericKeyboardIsOpen() {
        return driver.findElement(SCREEN_NUMERIC_KEYBOARD).isDisplayed();
    }
}
