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

    public static final By SETTINGS_WINDOW = By.name("settingsPageContainer");
    public static final By SETTINGS_GO_BACK = By.name("settingsReturnBtn");
    public static final By PROFILE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Профиль']]");
    public static final By INTERFACE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Интерфейс']]");
    public static final By CV_SETTINGS_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]");
    public static final By ABOUT_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Об устройстве']]");
    public static void waitSettingsWindowOpen() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
    }
    public boolean settingsWindowIsOpen() {
        waitSettingsWindowOpen();
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «<Настройки»")
    public static void clickOnBackButton() {
        waitSettingsWindowOpen();
        driver.findElement(SETTINGS_GO_BACK).click();
    }
    public void waitOpenSettingsWindow() {
        waitSettingsWindowOpen();
        driver.findElement(SETTINGS_GO_BACK).isDisplayed();
    }
    @Step("Нажимаем на кнопку «Профиль»")
    public static void clickOnProfileButton() {
        waitSettingsWindowOpen();
        driver.findElement(PROFILE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Интерфейс»")
    public static void clickOnInterfaceButton() {
        waitSettingsWindowOpen();
        driver.findElement(INTERFACE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnCVSettingsButton() {
        waitSettingsWindowOpen();
        driver.findElement(CV_SETTINGS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Об устройстве»")
    public static void clickOnAboutButton() {
        waitSettingsWindowOpen();
        driver.findElement(ABOUT_BUTTON).click();
    }

}

