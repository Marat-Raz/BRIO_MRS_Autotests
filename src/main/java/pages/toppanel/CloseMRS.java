package pages.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pages.TotalConstants.*;
import static pages.TotalConstants.NO_BUTTON_CLOSE_APPLICATION;

public class CloseMRS {
    public static AppiumDriver driver;// = null;
    public CloseMRS (AppiumDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем на кнопку «Главное меню»")
    public static void clickOnMainMenu() {
        driver.findElement(MENU_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Закрыть приложение»")
    public static void clickOnCloseApplicationButton() {
        driver.findElement(CLOSE_APPLICATION_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Да»")
    public static void clickOnYesButton() {
        driver.findElement(YES_BUTTON_CLOSE_APPLICATION).click();
    }
    @Step("Нажимаем на кнопку «Нет»")
    public static void clickOnNoButton() {
        driver.findElement(NO_BUTTON_CLOSE_APPLICATION).click();
    }
}
