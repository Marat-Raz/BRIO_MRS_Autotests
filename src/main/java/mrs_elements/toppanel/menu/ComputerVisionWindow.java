package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComputerVisionWindow {
    public static AppiumDriver driver;

    public ComputerVisionWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    MethodsForElements methodsForElements = new MethodsForElements(driver);

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
        methodsForElements.clickingOnListAndSelectListItem(CAMERA_PRESET, CAMERA_PRESET_POPUP_DEFAULT_PRESET);
    }

    @Step("Выбор элемента «HighResHighAccuracyPreset» выпадающего списка «Пресет камеры»")
    public void selectCameraPresetHighResHighAccuracyPreset() {
        methodsForElements.clickingOnListAndSelectListItem(CAMERA_PRESET, CAMERA_PRESET_POPUP_HIGH_RES_HIGH_ACCURACY_PRESET);
    }

    @Step("Выбор элемента «HighResHighDensityPreset» выпадающего списка «Пресет камеры»")
    public void selectCameraPresetHighResHighDensityPreset() {
        methodsForElements.clickingOnListAndSelectListItem(CAMERA_PRESET, CAMERA_PRESET_POPUP_HIGH_RES_HIGH_DENSITY_PRESET);
    }

    @Step("Считываем установленное значение для «Алгоритм поиска Aruco»")
    public String arucoSearchAlgorithmIs() {
        return driver.findElement(ARUCO_SEARCH_ALGORITHM).getText();
    }

    @Step("Выбор элемента «OpenCV (стандартный)» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmOpenCvStandard() {
        methodsForElements.clickingOnListAndSelectListItem(ARUCO_SEARCH_ALGORITHM, ARUCO_SEARCH_ALGORITHM_POPUP_OPEN_CV_STANDARD);
    }

    @Step("Выбор элемента «Brio» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmBrio() {
        methodsForElements.clickingOnListAndSelectListItem(ARUCO_SEARCH_ALGORITHM, ARUCO_SEARCH_ALGORITHM_POPUP_BRIO);
    }

    @Step("Выбор элемента «Custom» выпадающего списка «Алгоритм поиска Aruco»")
    public void selectArucoSearchAlgorithmCustom() {
        methodsForElements.clickingOnListAndSelectListItem(ARUCO_SEARCH_ALGORITHM, ARUCO_SEARCH_ALGORITHM_POPUP_CUSTOM);
    }

    @Step("Нажимаем на переключатель «Обнаружение объектов»")
    public static void clickOnObjectDetectionToggleButton() {
        driver.findElement(OBJECT_DETECTION_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Обнаружение объектов»")
    public boolean objectDetectionToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(OBJECT_DETECTION_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Коррекция метки по гироскопу»")
    public static void clickOnGyroscopeMarkCorrectionsToggleButton() {
        driver.findElement(GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Коррекция метки по гироскопу»")
    public boolean gyroscopeMarkCorrectionsToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(GYROSCOPE_MARK_CORRECTIONS_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Заморозка карты глубины»")
    public static void clickOnDepthMapFreezeToggleButton() {
        driver.findElement(DEPTH_MAP_FREEZE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Заморозка карты глубины»")
    public boolean depthMapFreezeToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(DEPTH_MAP_FREEZE_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Контур объектов всегда виден»")
    public static void clickOnOutlineOfObjectsIsAlwaysVisibleToggleButton() {
        driver.findElement(OUTLINE_OF_OBJECTS_IS_ALWAYS_VISIBLE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Контур объектов всегда виден»")
    public boolean outlineOfObjectsIsAlwaysVisibleToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(OUTLINE_OF_OBJECTS_IS_ALWAYS_VISIBLE_TOGGLE_BUTTON);
    }

}
