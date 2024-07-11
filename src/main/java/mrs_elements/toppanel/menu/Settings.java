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
    public static final By PROFILE_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/ScrollViewer/Border/Grid/" +
            "ScrollContentPresenter/ItemsControl/Border/ItemsPresenter/StackPanel/ContentPresenter[1]/Button");
    public static final By INTERFACE_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/ScrollViewer/Border/Grid/" +
            "ScrollContentPresenter/ItemsControl/Border/ItemsPresenter/StackPanel/ContentPresenter[2]/Button");
    public static final By CV_SETTINGS_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/ScrollViewer/Border/Grid/" +
            "ScrollContentPresenter/ItemsControl/Border/ItemsPresenter/StackPanel/ContentPresenter[3]/Button");
    public static final By ABOUT_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/ScrollViewer/Border/Grid/" +
            "ScrollContentPresenter/ItemsControl/Border/ItemsPresenter/StackPanel/ContentPresenter[4]/Button");
    public boolean settingsWindowIsOpen() {
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «<Настройки»")
    public static void clickOnBackButton() {
        driver.findElement(SETTINGS_GO_BACK).click();
    }
    public void waitOpenSettingsWindow() {
        driver.findElement(SETTINGS_GO_BACK).isDisplayed();
    }
    @Step("Нажимаем на кнопку «Профиль»")
    public static void clickOnProfileButton() {
        driver.findElement(PROFILE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Интерфейс»")
    public static void clickOnInterfaceButton() {
        driver.findElement(INTERFACE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnCVSettingsButton() {
        driver.findElement(CV_SETTINGS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnAboutButton() {
        driver.findElement(ABOUT_BUTTON).click();
    }

}

