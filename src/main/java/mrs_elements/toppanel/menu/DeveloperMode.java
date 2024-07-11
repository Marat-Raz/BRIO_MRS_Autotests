package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeveloperMode {
    public static AppiumDriver driver;

    public DeveloperMode(AppiumDriver driver) {
        this.driver = driver;
    }

    public static final By DEVELOPER_MODE_WINDOW = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid");
    public static final By DEVELOPER_MODE_GO_BACK = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/Button");
    public void waitOpenDeveloperModeWindow() {
        driver.findElement(DEVELOPER_MODE_WINDOW).isDisplayed();
    }
    public boolean developerModeWindowIsOpen() {
        return driver.findElement(DEVELOPER_MODE_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        driver.findElement(DEVELOPER_MODE_GO_BACK).click();
    }
}

