package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplorerWindow {
    public static AppiumDriver driver;
    public static final By EXPLORER_VIEW = By.name("ExplorerView");
    public static final By EXPLORER_GO_BACK_BUTTON = By.name("explorerGoBackBtn");
    public static final By EXPLORER_SEARCH_BOX = By.name("searchTextBox");

    public ExplorerWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitExplorerWindowOpen() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(EXPLORER_VIEW));
    }

    public boolean explorerWindowIsOpen() {
        waitExplorerWindowOpen();
        return driver.findElement(EXPLORER_VIEW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnGoBackButton() {
        waitExplorerWindowOpen();
        driver.findElement(EXPLORER_GO_BACK_BUTTON).click();
    }
}
