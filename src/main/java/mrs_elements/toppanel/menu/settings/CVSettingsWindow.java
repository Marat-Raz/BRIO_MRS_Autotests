package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CVSettingsWindow {
    public static AppiumDriver driver;

    public CVSettingsWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    MethodsForElements methodsForElements = new MethodsForElements(driver);

    public static final By GO_BACK_CV_SETTINGS_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]");
    public static final By CV_SETTINGS_X_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]/following-sibling::*");
    public static final By DEPTH_MAP_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Карта глубины']]");
    public static final By MULTI_MARKER_POSITIONING_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Многомаркерное позиционирование']/following-sibling::*");

    public static void waitOpenCVSettingsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_CV_SETTINGS_BUTTON));
    }

    public boolean cVSettingsWindowIsOpen() {
        waitOpenCVSettingsWindow();
        return driver.findElement(GO_BACK_CV_SETTINGS_BUTTON).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Настройки CV»")
    public static void clickOnGoBackButton() {
        waitOpenCVSettingsWindow();
        driver.findElement(GO_BACK_CV_SETTINGS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Карта глубины»")
    public static void clickOnDepthMapButton() {
        waitOpenCVSettingsWindow();
        driver.findElement(DEPTH_MAP_BUTTON).click();
    }

    @Step("Нажимаем на переключатель «Многомаркерное позиционирование»")
    public static void clickOnMultiMarkerPositioningToggleButton() {
        waitOpenCVSettingsWindow();
        driver.findElement(MULTI_MARKER_POSITIONING_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Многомаркерное позиционирование»")
    public boolean multiMarkerPositioningToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(MULTI_MARKER_POSITIONING_TOGGLE_BUTTON);
    }


    public void clickOnXButton() {
        waitOpenCVSettingsWindow();
        driver.findElement(CV_SETTINGS_X_BUTTON).click();
    }
}
