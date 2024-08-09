package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsWindow {
    public static AppiumDriver driver;

    public SettingsWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static final By SETTINGS_WINDOW = By.name("settingsPageContainer");
    public static final By SETTINGS_GO_BACK = By.xpath("//Button[.//TextBlock[@Text='Настройки' or @Text='Settings']]");
    public static final By PROFILE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Профиль' or @Text='Profile']]");
    public static final By INTERFACE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Интерфейс' or @Text='Interface']]");
    public static final By CV_SETTINGS_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]");
    public static final By ABOUT_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Об устройстве']]");

    public static void waitOpenSettingsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
    }

    public boolean settingsWindowIsOpen() {
        waitOpenSettingsWindow();
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Настройки»")
    public static void clickOnGoBackButton() {
        waitOpenSettingsWindow();
        driver.findElement(SETTINGS_GO_BACK).click();
    }

    @Step("Нажимаем на кнопку «Профиль»")
    public static void clickOnProfileButton() {
        waitOpenSettingsWindow();
        driver.findElement(PROFILE_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Интерфейс»")
    public static void clickOnInterfaceButton() {
        waitOpenSettingsWindow();
        driver.findElement(INTERFACE_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Настройки CV»")
    public static void clickOnCVSettingsButton() {
        waitOpenSettingsWindow();
        driver.findElement(CV_SETTINGS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Об устройстве»")
    public static void clickOnAboutButton() {
        waitOpenSettingsWindow();
        driver.findElement(ABOUT_BUTTON).click();
    }

}

