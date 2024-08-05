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

    public static final By YES_BUTTON_CLOSE_APPLICATION = By.xpath("//Button[.//TextBlock[@Text='Да']]");
    public static final By NO_BUTTON_CLOSE_APPLICATION = By.xpath("//Button[.//TextBlock[@Text='Нет']]");
    public static final By NOTIFICATION_DIALOG_CLOSE_APPLICATION =
            By.xpath("//TextBlock[@Text='Вы действительно хотите закрыть программу?']/parent::*");

    @Step("Ожидаем открытия окна «Вы действительно хотите закрыть программу?»")
    public static void waitOpenCloseAppMassage() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_DIALOG_CLOSE_APPLICATION));
    }
    @Step("Окно «Закрыть приложение» открыто?")
    public void waitOpenCloseAppWindow() {
        waitOpenCloseAppMassage();
        driver.findElement(NOTIFICATION_DIALOG_CLOSE_APPLICATION).isDisplayed();
    }

    @Step("Нажимаем на кнопку «Да»")
    public static void clickOnYesButton() {
        waitOpenCloseAppMassage();
        driver.findElement(YES_BUTTON_CLOSE_APPLICATION).click();
    }

    @Step("Нажимаем на кнопку «Нет»")
    public static void clickOnNoButton() {
        waitOpenCloseAppMassage();
        driver.findElement(NO_BUTTON_CLOSE_APPLICATION).click();
    }


}
