package mrs_elements.scene.bim_viewer_view;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Minimap {
    public static AppiumDriver driver;
    public static final By MINIMAP = By.xpath("//FloorMinimapView/Border/ContentPresenter/Border/Border/Grid");
    public static final By MINUS_BTN = By.xpath("//FloorMinimapView//Button[1]");
    public static final By PLUS_BTN = By.xpath("//FloorMinimapView//Button[2]");
    public static final By RESIZE_BTN = By.xpath("//FloorMinimapView//Button[3]");

    public Minimap(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenMinimap() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(MINIMAP));
    }

    public boolean minimapIsOpen() {
        waitOpenMinimap();
        return driver.findElement(MINIMAP).isDisplayed();
    }

    @Step("Нажимаем на кнопку «-»")
    public void clickOnMinusBtn() {
        driver.findElement(MINUS_BTN).click();
    }

    @Step("Нажимаем на кнопку «+»")
    public void clickOnPlusBtn() {
        driver.findElement(PLUS_BTN).click();
    }

    @Step("Нажимаем на кнопку изменения размера миникарты")
    public void clickOnResizeBtn() {
        driver.findElement(RESIZE_BTN).click();
    }

}
