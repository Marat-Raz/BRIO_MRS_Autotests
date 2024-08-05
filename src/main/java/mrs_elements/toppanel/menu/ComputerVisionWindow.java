package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mrs_elements.toppanel.menu.DeveloperModeLocators.DEVELOPER_MODE_GO_BACK;
import static mrs_elements.toppanel.menu.DeveloperModeLocators.DEVELOPER_MODE_WINDOW;

public class ComputerVisionWindow {
    public static AppiumDriver driver;

    public ComputerVisionWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public static final By GO_BACK_COMPUTER_VISION_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Компьютерное зрение']]");
    public static final By CAMERA_PRESET =
            By.xpath("//SettingsView/Border/ContentPresenter/AnimatedContentControl/Border/Grid/" +
                    "ContentPresenter/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/ItemsControl/Border/" +
                    "ItemsPresenter/StackPanel/ContentPresenter[1]/Grid/ComboBox/Grid/ToggleButton");
    public static final By CAMERA_PRESET_POPUP_DEFAULT_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='DefaultPreset']");
    public static final By CAMERA_PRESET_POPUP_HIGH_RES_HIGH_ACCURACY_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='HighResHighAccuracyPreset']");
    public static final By CAMERA_PRESET_POPUP_HIGH_RES_HIGH_DENSITY_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='HighResHighDensityPreset']");
    public static final By ARUCO_SEARCH_ALGORITHM =
            By.xpath("//SettingsView/Border/ContentPresenter/AnimatedContentControl/Border/Grid/" +
                    "ContentPresenter/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/ItemsControl/Border/" +
                    "ItemsPresenter/StackPanel/ContentPresenter[2]/Grid/ComboBox/Grid/ToggleButton");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_OPEN_CV_STANDARD =
            By.xpath("//Popup/descendant::TextBlock[@Text='OpenCV (Стандартный)']");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_BRIO =
            By.xpath("//Popup/descendant::TextBlock[@Text='Brio']");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_CUSTOM =
            By.xpath("//Popup/descendant::TextBlock[@Text='Custom']");
    public static final By OBJECT_DETECTION_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Обнаружение объектов']/following-sibling::*");
    public static final By GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Коррекции метки по гироскопу']/following-sibling::*");
    public static final By DEPTH_MAP_FREEZE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Заморозка карты глубины']/following-sibling::*");
    public static final By OUTLINE_OF_OBJECTS_IS_ALWAYS_VISIBLE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Контур объектов всегда виден']/following-sibling::*");

    public static void waitOpenComputerVisionWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).
                until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_COMPUTER_VISION_BUTTON));
    }

    public boolean computerVisionWindowIsOpen() {
        waitOpenComputerVisionWindow();
        return driver.findElement(GO_BACK_COMPUTER_VISION_BUTTON).isDisplayed();
    }
    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        waitOpenComputerVisionWindow();
        driver.findElement(GO_BACK_COMPUTER_VISION_BUTTON).click();
    }

}
