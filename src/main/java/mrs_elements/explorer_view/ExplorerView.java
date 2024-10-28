package mrs_elements.explorer_view;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplorerView {
    public static AppiumDriver driver;
    public static final By EXPLORER_VIEW =
            By.xpath("//ExplorerView//*[starts-with(@Text,'Выберите модели для загрузки')]/parent::*");
    public static final By EXPLORER_GO_BACK_BTN = By.name("explorerGoBackBtn");

    public ExplorerView(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenExplorerView() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(EXPLORER_VIEW));
    }

    public boolean explorerViewIsOpen() {
        waitOpenExplorerView();
        return driver.findElement(EXPLORER_VIEW).isDisplayed();
    }

    public void clickOnBackButton() {
        driver.findElement(EXPLORER_GO_BACK_BTN).click();
    }
}
