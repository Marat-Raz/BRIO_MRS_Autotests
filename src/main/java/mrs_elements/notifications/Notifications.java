package mrs_elements.notifications;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Notifications {
    public static AppiumDriver driver;
    private static final By NOTIFICATION_BUTTON = By.name("NotificationButton");
    public Notifications(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenNotifications() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION_BUTTON));
    }

    public boolean notificationsWindowIsOpen() {
        waitOpenNotifications();
        return driver.findElement(NOTIFICATION_BUTTON).isDisplayed();
    }
    public String textFromNotifications() {
        return driver.findElement(NOTIFICATION_BUTTON).getText();
    }
}
