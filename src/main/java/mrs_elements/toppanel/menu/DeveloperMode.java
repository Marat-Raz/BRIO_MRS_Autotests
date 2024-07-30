package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeveloperMode {
    public static AppiumDriver driver;

    public DeveloperMode(AppiumDriver driver) {
        this.driver = driver;
    }

    public static final By DEVELOPER_MODE_WINDOW = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter"); // todo By.name
    public static final By DEVELOPER_MODE_GO_BACK = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/Button"); // todo By.name
    public static void waitOpenDeveloperModeWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(DEVELOPER_MODE_WINDOW));
    }
    public boolean developerModeWindowIsOpen() {
        waitOpenDeveloperModeWindow();
        return driver.findElement(DEVELOPER_MODE_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        waitOpenDeveloperModeWindow();
        driver.findElement(DEVELOPER_MODE_GO_BACK).click();
    }
}

