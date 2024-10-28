package mrs_elements.scene.modelview;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BimViewerView {
    public static AppiumDriver driver;

    public static final By BIM_VIEWER_VIEW = By.className("BimViewerView");
    public static final By EXPANDER_WITHOUT_HEADER = By.className("ExpanderWithoutHeader");

    public BimViewerView(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenBimViewerView() {
        (new WebDriverWait(driver, Duration.ofSeconds(25)))
                .until(ExpectedConditions.visibilityOfElementLocated(BIM_VIEWER_VIEW));
    }

    public boolean bimViewerViewIsOpen() {
        waitOpenBimViewerView();
        return driver.findElement(BIM_VIEWER_VIEW).isDisplayed();
    }

    public static void waitOpenExpanderWithoutHeader() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(EXPANDER_WITHOUT_HEADER));
    }

    public boolean expanderWithoutHeaderIsOpen() {
        waitOpenExpanderWithoutHeader();
        return driver.findElement(EXPANDER_WITHOUT_HEADER).isDisplayed();
    }


}
