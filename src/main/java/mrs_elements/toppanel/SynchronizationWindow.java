package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationWindow {
    public static AppiumDriver driver;
    public static final By SYNCHRONIZATION_DIALOG = By.xpath("//SynchronizationDialog/Border/" +
            "ContentPresenter/ContentControl/Border/ContentPresenter/Border/Grid/Grid[1]");
    public static final By CLOSE_SYNCHRONIZATION_DIALOG_BUTTON = By.xpath("//SynchronizationDialog/" +
            "Border/ContentPresenter/ContentControl/Border/ContentPresenter/Border/Grid/Grid[1]/Button");

    public SynchronizationWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenSynchronizationWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.visibilityOfElementLocated(SYNCHRONIZATION_DIALOG));
    }

    public boolean synchronizationDialogIsOpen() {
        waitOpenSynchronizationWindow();
        return driver.findElement(SYNCHRONIZATION_DIALOG).isDisplayed();
    }

    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        waitOpenSynchronizationWindow();
        driver.findElement(CLOSE_SYNCHRONIZATION_DIALOG_BUTTON).click();
    }
}
