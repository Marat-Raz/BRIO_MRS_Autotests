package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloseAppMassage {
    public static AppiumDriver driver;
    public CloseAppMassage(AppiumDriver driver) {
        this.driver = driver;
    }
    public static final By YES_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[1]/" +
            "Button/Grid/ContentPresenter/TextBlock");
    public static final By NO_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[2]/" +
            "Button/Grid/ContentPresenter/TextBlock");
    public static final By NOTIFICATION_DIALOG_CLOSE_APPLICATION = By.xpath("//NotificationDialog/" +
            "Border/ContentPresenter/ContentControl/Border/ContentPresenter");
    @Step("Нажимаем на кнопку «Да»")
    public static void clickOnYesButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_DIALOG_CLOSE_APPLICATION));
        driver.findElement(YES_BUTTON_CLOSE_APPLICATION).click();
    }
    @Step("Нажимаем на кнопку «Нет»")
    public static void clickOnNoButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_DIALOG_CLOSE_APPLICATION));
        driver.findElement(NO_BUTTON_CLOSE_APPLICATION).click();
    }
    @Step("Окно «Закрыть приложение» открыто")
    public void waitOpenCloseAppWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_DIALOG_CLOSE_APPLICATION));
        driver.findElement(NOTIFICATION_DIALOG_CLOSE_APPLICATION).isDisplayed();
    }
}
