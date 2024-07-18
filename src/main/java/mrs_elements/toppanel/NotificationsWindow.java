package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationsWindow {
    public static AppiumDriver driver;
    public static final By NOTIFICATIONS_WINDOW = By.xpath("//NotificationPanelView/Grid/" +
            "ContentPresenter/Grid/ExpanderWithoutHeader/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/" +
            "Border/ContentPresenter/Border/Grid");
    public static final By CLOSE_NOTIFICATIONS_BUTTON = By.xpath("//NotificationPanelView/Grid/" +
            "ContentPresenter/Grid/ExpanderWithoutHeader/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/" +
            "Border/ContentPresenter/Border/Grid/Grid/Button");
    public NotificationsWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public static void waitOpenNotificationsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATIONS_WINDOW));
        driver.findElement(NOTIFICATIONS_WINDOW).isDisplayed();
    }
    public boolean notificationsWindowIsOpen() {
        waitOpenNotificationsWindow();
        return driver.findElement(NOTIFICATIONS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        waitOpenNotificationsWindow();
        driver.findElement(CLOSE_NOTIFICATIONS_BUTTON).click();
    }


}
