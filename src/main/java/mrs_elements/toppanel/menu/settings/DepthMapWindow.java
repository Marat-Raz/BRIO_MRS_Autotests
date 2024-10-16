package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DepthMapWindow {
    public static AppiumDriver driver;

    public DepthMapWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    MethodsForElements methodsForElements = new MethodsForElements(driver);

    public static final By GO_BACK_DEPTH_MAP_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Карта глубины']]");
    public static final By DEPTH_MAP_X_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Карта глубины']]/following-sibling::*");
    public static final By HARDWARE_DEPTH_MAP_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Аппаратная карта глубины']/following-sibling::*");
    public static final By FILTRATION_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Фильтрация']/following-sibling::*");
    public static final By AVERAGING_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Усреднение']/following-sibling::*");

    public static void waitOpenDepthMapWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_DEPTH_MAP_BUTTON));
    }

    public boolean depthMapWindowIsOpen() {
        waitOpenDepthMapWindow();
        return driver.findElement(GO_BACK_DEPTH_MAP_BUTTON).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Карта глубины»")
    public static void clickOnGoBackButton() {
        // todo добавить тесты на эту кнопку
        waitOpenDepthMapWindow();
        driver.findElement(GO_BACK_DEPTH_MAP_BUTTON).click();
    }

    @Step("Нажимаем на переключатель «Аппаратная карта глубины»")
    public static void clickOnHardwareDepthMapToggleButton() {
        waitOpenDepthMapWindow();
        driver.findElement(HARDWARE_DEPTH_MAP_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Аппаратная карта глубины»")
    public boolean hardwareDepthMapToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(HARDWARE_DEPTH_MAP_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Фильтрация»")
    public static void clickOnFiltrationToggleButton() {
        waitOpenDepthMapWindow();
        driver.findElement(FILTRATION_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Фильтрация»")
    public boolean filtrationToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(FILTRATION_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Усреднение»")
    public static void clickOnAveragingToggleButton() {
        waitOpenDepthMapWindow();
        driver.findElement(AVERAGING_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Усреднение»")
    public boolean averagingToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(AVERAGING_TOGGLE_BUTTON);
    }

    public void clickOnXButton() {
        waitOpenDepthMapWindow();
        driver.findElement(DEPTH_MAP_X_BUTTON).click();
    }
}
