package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuWindow {
    public static AppiumDriver driver;
    private static final By SETTINGS_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Настройки']]");
    private static final By RETURN_TO_MAIN_PAGE_BUTTON = By.name("returnToMainPageBtn");
    private static final By MINIMIZE_BUTTON = By.name("minimizeBtn");
    private static final By CLOSE_APPLICATION_BUTTON = By.name("closeAppBtn");
    private static final By BRIO_MRS_VERSION_BUTTON = By.name("versionBtn");
    private static final By MENU_WINDOW = By.name("menuPanelContainer");
    private static final By BUTTON_X = By.name("closeMenuBtn");

    public MenuWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenMenuWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(MENU_WINDOW));
    }

    public boolean menuWindowIsOpen() {
        waitOpenMenuWindow();
        return driver.findElement(MENU_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «Настройки»")
    public static void clickOnSettingsButton() {
        waitOpenMenuWindow();
        driver.findElement(SETTINGS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «На главную»")
    public static void clickOnReturnToMainPageButton() {
        waitOpenMenuWindow();
        driver.findElement(RETURN_TO_MAIN_PAGE_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Свернуть окно»")
    public static void clickOnMinimizeButton() {
        waitOpenMenuWindow();
        driver.findElement(MINIMIZE_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Закрыть приложение»")
    public static void clickOnCloseApplicationButton() {
        waitOpenMenuWindow();
        driver.findElement(CLOSE_APPLICATION_BUTTON).click();
    }

    @Step("Нажимаем на надписи с версией приложения")
    public static void clickFiveOnBrioMrsVersionButton() {
        waitOpenMenuWindow();
        WebElement brioMrsVersionButton = driver.findElement(BRIO_MRS_VERSION_BUTTON);
        for (int i = 0; i < 5; i++) {
            brioMrsVersionButton.click();
        }
    }

    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        waitOpenMenuWindow();
        driver.findElement(BUTTON_X).click();
    }

}
