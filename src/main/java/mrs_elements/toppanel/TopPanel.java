package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

import static mrs_elements.TotalConstants.*;

public class TopPanel {
    public static AppiumDriver driver;
    public TopPanel(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку «Синхронизация»")
    public static void clickOnSynchronization() {
        driver.findElement(SYNCHRONIZATION_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Уведомления»")
    public static void clickOnNotifications() {
        driver.findElement(NOTIFICATIONS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Оси»")
    public static void clickOnAxes() {
        driver.findElement(AXES_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Проводник»")
    public static void clickOnExplorer() {
        driver.findElement(EXPLORER_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Уровни»")
    public static void clickOnHierarchy() {
        driver.findElement(HIERARCHY_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Меню»")
    public static void clickOnMainMenu() {
        driver.findElement(MENU_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «AR»")
    public static void clickOnAR() {
        driver.findElement(AR_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «MR»")
    public static void clickOnMR() {
        driver.findElement(MR_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «AMR»")
    public static void clickOnAMR() {
        driver.findElement(AMR_BUTTON).click();
    }

}
