package mrs_elements.scene.bim_viewer_view.toolbar;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FloorMapListView {
    public static AppiumDriver driver;

    public static final By FLOOR_MAP_LIST_VIEW = By.className("FloorMapListView");
    public static final By X_BTN = By.xpath("//TextBlock[@Text='Карты этажей']/following-sibling::Button");


    public FloorMapListView(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenFloorMapListView() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(FLOOR_MAP_LIST_VIEW));
    }

    public boolean floorMapListViewIsOpen() {
        try {
            return driver.findElement(FLOOR_MAP_LIST_VIEW).isDisplayed();
        } catch (TimeoutException | NoSuchElementException ex)  {
            return false;
        }
    }

    @Step("Нажимаем на кнопку «Х»")
    public void clickOnXBtn() {
        driver.findElement(X_BTN).click();
    }


}
