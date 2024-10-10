package mrs_elements.scene.modelview;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModelView {
    public static AppiumDriver driver;
    public static final By COMPASS_VIEW_IN_SCENE = By.xpath("//CompassView/Border/ContentPresenter/Grid"); // todo By.name

    public static final By MODEL_VIEW = By.xpath("//BimViewerView/Border/ContentPresenter/Grid/" +
            "SceneViewControl/Grid"); // todo By.name

    public ModelView(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenModelView() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.visibilityOfElementLocated(MODEL_VIEW));
    }

    public boolean interfaceWindowIsOpen() {
        waitOpenModelView();
        return driver.findElement(MODEL_VIEW).isDisplayed();
    }
}
