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
    public static final By SETTINGS_X_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Настройки' or @Text='Settings']]/following-sibling::*");
    public static final By INTERFACE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Интерфейс' or @Text='Interface']]");
    public static final By CV_SETTINGS_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]");
    public static final By ABOUT_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Об устройстве']]");
    public static final By DEVELOPMENT_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Разработка']]");

    public static void waitOpenSettingsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_WINDOW));
    }

    public boolean settingsWindowIsOpen() {
        waitOpenSettingsWindow();
        return driver.findElement(SETTINGS_WINDOW).isDisplayed();
    }
    public boolean developmentButtonOnSettingsWindowIsDisplayed() {
        waitOpenSettingsWindow();
        return driver.findElement(DEVELOPMENT_BUTTON).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Настройки»")
    public static void clickOnGoBackButton() {
        waitOpenSettingsWindow();
        driver.findElement(SETTINGS_GO_BACK).click();
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

    @Step("Нажимаем на кнопку Х")
    public void clickOnXButton() {
        waitOpenSettingsWindow();
        driver.findElement(SETTINGS_X_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Разработка»")
    public void clickOnDevelopmentButton() {
        waitOpenSettingsWindow();
        driver.findElement(DEVELOPMENT_BUTTON).click();
    }
}

