package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

import static mrs_elements.TotalConstants.*;
import static mrs_elements.TotalConstants.NO_BUTTON_CLOSE_APPLICATION;

public class CloseApp {
    public static AppiumDriver driver;
    public CloseApp(AppiumDriver driver) {
        this.driver = driver;
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
