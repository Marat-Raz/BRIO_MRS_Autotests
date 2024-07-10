package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Settings {
    public static AppiumDriver driver;

    public Settings(AppiumDriver driver) {
        this.driver = driver;
    }

    public static final By SETTINGS_WINDOW = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid");
    public static final By SETTINGS_GO_BACK = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/Button");
    public boolean settingsWindowIsOpen() {
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        driver.findElement(SETTINGS_GO_BACK).click();
    }
}

