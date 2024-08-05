package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mrs_elements.toppanel.menu.settings.InterfaceWindowLocators.GO_BACK_INTERFACE_BUTTON;

public class TopPanel {
    public static AppiumDriver driver;
    public static final By MENU_BUTTON = By.name("menuBtn");
    public static final By SYNCHRONIZATION_BUTTON = By.name("syncBtn");
    public static final By NOTIFICATIONS_BUTTON = By.name("notificationBtn");
    public static final By AXES_BUTTON = By.name("toggleGridsBtn");
    public static final By EXPLORER_BUTTON = By.name("explorerBtn");
    public static final By HIERARCHY_BUTTON = By.name("hierarchyBtn");
    public static final By AR_BUTTON = By.name("switchToARBtn");
    public static final By MR_BUTTON = By.name("switchToMRBtn");
    public static final By AMR_BUTTON = By.name("switchToAMRBtn");

    public TopPanel(AppiumDriver driver) {
        this.driver = driver;
    }
    public static void waitOpenTopPanel() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(MENU_BUTTON));
    }

    @Step("Нажимаем на кнопку «Синхронизация»")
    public static void clickOnSynchronizationButton() {
        driver.findElement(SYNCHRONIZATION_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Уведомления»")
    public static void clickOnNotificationsButton() {
        driver.findElement(NOTIFICATIONS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Оси»")
    public static void clickOnAxesButton() {
        driver.findElement(AXES_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Проводник»")
    public static void clickOnExplorerButton() {
        driver.findElement(EXPLORER_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Уровни»")
    public static void clickOnHierarchyButton() {
        driver.findElement(HIERARCHY_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Меню»")
    public static void clickOnMainMenuButton() {
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
