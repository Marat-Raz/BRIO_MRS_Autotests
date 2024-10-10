package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HierarchyWindow {
    public static AppiumDriver driver;
    public static final By HIERARCHY_WINDOW = By.name("notificationPanelBorder");
    public static final By CLOSE_HIERARCHY_WINDOW_BUTTON = By.name("closeNotificationPanelBtn");

    public HierarchyWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenHierarchyWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.visibilityOfElementLocated(HIERARCHY_WINDOW));
    }

    public boolean notificationsWindowIsOpen() {
        waitOpenHierarchyWindow();
        return driver.findElement(HIERARCHY_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        waitOpenHierarchyWindow();
        driver.findElement(CLOSE_HIERARCHY_WINDOW_BUTTON).click();
    }
}
