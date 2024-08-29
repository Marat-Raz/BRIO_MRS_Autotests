package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectListView {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;

    public ProjectListView(AppiumDriver driver) {
        methodsForElements = new MethodsForElements(driver);
        this.driver = driver;
    }

    public static void waitOpenProjectListView() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated());
    }
}
