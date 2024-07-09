package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

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
    public boolean notificationsWindowIsOpen() {
        return driver.findElement(NOTIFICATIONS_WINDOW).isDisplayed();
    }
    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        driver.findElement(CLOSE_NOTIFICATIONS_BUTTON).click();
    }

}
