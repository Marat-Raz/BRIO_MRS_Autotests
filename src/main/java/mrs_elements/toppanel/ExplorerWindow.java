package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplorerWindow {
    public static AppiumDriver driver;
    public static final By EXPLORER_ITEMS = By.xpath("//ExplorerItemsControl/Border/ScrollViewer/Border/" +
                    "Grid/ScrollContentPresenter/AdornerLayer");
    public static final By EXPLORER_GO_BACK_BUTTON = By.xpath("//ExplorerGoBackActionView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public ExplorerWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public boolean explorerWindowIsOpen() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(EXPLORER_ITEMS));
        return driver.findElement(EXPLORER_ITEMS).isDisplayed();
    }
    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(EXPLORER_ITEMS));
        driver.findElement(EXPLORER_GO_BACK_BUTTON).click();
    }
}
