package mrs_elements.screenkeyboards;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenKeyboard {
    public static AppiumDriver driver;
    private static final By SCREEN_KEYBOARD = By.xpath("//TextKeyboardWithMicView/Border/" +
            "ContentPresenter/Grid/Border[2]");
    private static final By SCREEN_KEYBOARD_INPUT = By.xpath("//TextKeyboardWithMicView/Border/ContentPresenter/Grid/" +
        "Border[2]/Grid/Decorator/Grid/TextBox");

    public ScreenKeyboard(AppiumDriver driver) {
        this.driver = driver;
    }
    public void waitOpenScreenKeyboard() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(SCREEN_KEYBOARD));
    }
    public boolean ScreenKeyboardIsOpen() {
        waitOpenScreenKeyboard();
        return driver.findElement(SCREEN_KEYBOARD).isDisplayed();
    }
    @Step("Ввод текста в поле ввода клавиатуры")
    public void enterTextToScreenKeyboardInput(String text) {
        waitOpenScreenKeyboard();
        driver.findElement(SCREEN_KEYBOARD_INPUT).sendKeys(text);
    }

}
