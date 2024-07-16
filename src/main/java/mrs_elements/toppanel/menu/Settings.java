package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

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
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «<Настройки»")
    public static void clickOnBackButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(SETTINGS_GO_BACK).click();
    }
    public void waitOpenSettingsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(SETTINGS_GO_BACK).isDisplayed();
    }
    @Step("Нажимаем на кнопку «Профиль»")
    public static void clickOnProfileButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(PROFILE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Интерфейс»")
    public static void clickOnInterfaceButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(INTERFACE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnCVSettingsButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(CV_SETTINGS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnAboutButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
        driver.findElement(ABOUT_BUTTON).click();
    }

}

