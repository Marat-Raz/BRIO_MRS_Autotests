package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SynchronizationWindow {
    public static AppiumDriver driver;
    public static final By SYNCHRONIZATION_DIALOG = By.xpath("//SynchronizationDialog/Border/" +
            "ContentPresenter/ContentControl/Border/ContentPresenter/Border/Grid/Grid[1]");
    public static final By CLOSE_SYNCHRONIZATION_DIALOG_BUTTON = By.xpath("//SynchronizationDialog/" +
            "Border/ContentPresenter/ContentControl/Border/ContentPresenter/Border/Grid/Grid[1]/Button");
    public SynchronizationWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public boolean SynchronizationDialogIsOpen() {
        return driver.findElement(SYNCHRONIZATION_DIALOG).isDisplayed();
    }
    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        driver.findElement(CLOSE_SYNCHRONIZATION_DIALOG_BUTTON).click();
    }
}
