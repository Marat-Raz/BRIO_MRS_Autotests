package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mrs_elements.toppanel.menu.DeveloperModeLocators.*;
import static mrs_elements.toppanel.menu.DeveloperModeLocators.SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON;

public class ComputerVisionWindow {
    public static AppiumDriver driver;

    public ComputerVisionWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public static final By GO_BACK_COMPUTER_VISION_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Компьютерное зрение']]");
    public static final By CAMERA_PRESET =
            By.xpath("//TextBlock[@Text='Пресет камеры (требуется аппаратная карта глубины)']" +
                    "/parent::*/descendant::ToggleButton");
    public static final By CAMERA_PRESET_POPUP_DEFAULT_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='DefaultPreset.json']");
    public static final By CAMERA_PRESET_POPUP_HIGH_RES_HIGH_ACCURACY_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='HighResHighAccuracyPreset.json']");
    public static final By CAMERA_PRESET_POPUP_HIGH_RES_HIGH_DENSITY_PRESET =
            By.xpath("//Popup/descendant::TextBlock[@Text='HighResHighDensityPreset.json']");
    public static final By ARUCO_SEARCH_ALGORITHM =
            By.xpath("//TextBlock[@Text='Алгоритм поиска Aruco']/parent::*/descendant::ToggleButton");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_OPEN_CV_STANDARD =
            By.xpath("//Popup/descendant::TextBlock[@Text='OpenCV (стандартный)']");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_BRIO =
            By.xpath("//Popup/descendant::TextBlock[@Text='Brio']");
    public static final By ARUCO_SEARCH_ALGORITHM_POPUP_CUSTOM =
            By.xpath("//Popup/descendant::TextBlock[@Text='Custom']");
    public static final By OBJECT_DETECTION_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Обнаружение объектов']/following-sibling::*");
    public static final By GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Коррекция метки по гироскопу']/following-sibling::*");
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
    public boolean switchEnabled(By by) {
        waitOpenComputerVisionWindow();
        String attr = driver.findElement(by).getAttribute("IsChecked");
        boolean IsChecked = Boolean.parseBoolean(attr);
        return IsChecked;
    }

    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        waitOpenComputerVisionWindow();
        driver.findElement(GO_BACK_COMPUTER_VISION_BUTTON).click();
    }

    @Step("Считываем установленное значение для «Пресет камеры»")
    public String cameraPresetIs() {
        String cameraPresetIs = driver.findElement(CAMERA_PRESET).getText();
        return cameraPresetIs;
    }

    @Step("Выбор элемента «DefaultPreset» выпадающего списка «Пресет камеры»")
    public void selectCameraPresetDefaultPreset() {
        driver.findElement(CAMERA_PRESET).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(CAMERA_PRESET_POPUP_DEFAULT_PRESET));
        driver.findElement(CAMERA_PRESET_POPUP_DEFAULT_PRESET).click();
    }

    @Step("Выбор элемента «HighResHighAccuracyPreset» выпадающего списка «Пресет камеры»")
    public void selectCameraPresetHighResHighAccuracyPreset() {
        driver.findElement(CAMERA_PRESET).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(CAMERA_PRESET_POPUP_HIGH_RES_HIGH_ACCURACY_PRESET));
        driver.findElement(CAMERA_PRESET_POPUP_HIGH_RES_HIGH_ACCURACY_PRESET).click();
    }

    @Step("Выбор элемента «HighResHighDensityPreset» выпадающего списка «Пресет камеры»")
    public void selectCameraPresetHighResHighDensityPreset() {
        driver.findElement(CAMERA_PRESET).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(CAMERA_PRESET_POPUP_HIGH_RES_HIGH_DENSITY_PRESET));
        driver.findElement(CAMERA_PRESET_POPUP_HIGH_RES_HIGH_DENSITY_PRESET).click();
    }

    @Step("Считываем установленное значение для «Алгоритм поиска Aruco»")
    public String arucoSearchAlgorithmIs() {
        return driver.findElement(ARUCO_SEARCH_ALGORITHM).getText();
    }

    @Step("Выбор элемента «OpenCV (стандартный)» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmOpenCvStandard() {
        driver.findElement(ARUCO_SEARCH_ALGORITHM).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(ARUCO_SEARCH_ALGORITHM_POPUP_OPEN_CV_STANDARD));
        driver.findElement(ARUCO_SEARCH_ALGORITHM_POPUP_OPEN_CV_STANDARD).click();
    }

    @Step("Выбор элемента «Brio» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmBrio() {
        driver.findElement(ARUCO_SEARCH_ALGORITHM).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(ARUCO_SEARCH_ALGORITHM_POPUP_BRIO));
        driver.findElement(ARUCO_SEARCH_ALGORITHM_POPUP_BRIO).click();
    }

    @Step("Выбор элемента «Custom» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmCustom() {
        driver.findElement(ARUCO_SEARCH_ALGORITHM).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(ARUCO_SEARCH_ALGORITHM_POPUP_CUSTOM));
        driver.findElement(ARUCO_SEARCH_ALGORITHM_POPUP_CUSTOM).click();
    }

    @Step("Нажимаем на переключатель «Обнаружение объектов»")
    public static void clickOnObjectDetectionToggleButton() {
        driver.findElement(OBJECT_DETECTION_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Обнаружение объектов»")
    public boolean objectDetectionToggleButtonIsEnabled() {
        return switchEnabled(OBJECT_DETECTION_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Коррекция метки по гироскопу»")
    public static void clickOnGyroscopeMarkCorrectionsToggleButton() {
        driver.findElement(GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Коррекция метки по гироскопу»")
    public boolean gyroscopeMarkCorrectionsToggleButtonIsEnabled() {
        return switchEnabled(GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Заморозка карты глубины»")
    public static void clickOnDepthMapFreezeToggleButton() {
        driver.findElement(DEPTH_MAP_FREEZE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Заморозка карты глубины»")
    public boolean depthMapFreezeToggleButtonIsEnabled() {
        return switchEnabled(DEPTH_MAP_FREEZE_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Контур объектов всегда виден»")
    public static void clickOnOutlineOfObjectsIsAlwaysVisibleToggleButton() {
        driver.findElement(OUTLINE_OF_OBJECTS_IS_ALWAYS_VISIBLE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Контур объектов всегда виден»")
    public boolean outlineOfObjectsIsAlwaysVisibleToggleButtonIsEnabled() {
        return switchEnabled(OUTLINE_OF_OBJECTS_IS_ALWAYS_VISIBLE_TOGGLE_BUTTON);
    }

}
