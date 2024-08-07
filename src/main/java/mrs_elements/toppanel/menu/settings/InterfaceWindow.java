package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mrs_elements.toppanel.menu.settings.InterfaceWindowLocators.*;

public class InterfaceWindow {
    public static AppiumDriver driver;

    public InterfaceWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    MethodsForElements methodsForElements = new MethodsForElements(driver);

    public static void waitOpenInterfaceWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_INTERFACE_BUTTON));
    }

    public boolean interfaceWindowIsOpen() {
        waitOpenInterfaceWindow();
        return driver.findElement(GO_BACK_INTERFACE_BUTTON).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Интерфейс»")
    public static void clickOnGoBackButton() {
        waitOpenInterfaceWindow();
        driver.findElement(GO_BACK_INTERFACE_BUTTON).click();
    }

    @Step("Считываем язык системы")
    public String systemLanguageIs() {
        String systemLanguage = driver.findElement(INTERFACE_LANGUAGE_TOGGLE_BUTTON).getText();
        return systemLanguage;
    }

    @Step("Выбор элемента «Русский» выпадающего списка «Язык»")
    public void selectLanguageRussian() {
        methodsForElements.clickingOnListAndSelectListItem(INTERFACE_LANGUAGE_TOGGLE_BUTTON, LANGUAGE_POPUP_RUSSIAN);
    }

    @Step("Выбор элемента «English (US)» выпадающего списка «Язык»")
    public void selectLanguageEnglish() {
        methodsForElements.clickingOnListAndSelectListItem(INTERFACE_LANGUAGE_TOGGLE_BUTTON, LANGUAGE_POPUP_ENGLISH);
    }

    @Step("Считываем сторону интерфейса")
    public String interfaceSideIs() {
        String interfaceSide = driver.findElement(INTERFACE_SIDE_TOGGLE_BUTTON).getText();
        return interfaceSide;
    }

    @Step("Выбор элемента «Левая» выпадающего списка «Сторона интерфейса»")
    public void selectInterfaceSideLeft() {
        methodsForElements.clickingOnListAndSelectListItem(INTERFACE_SIDE_TOGGLE_BUTTON, INTERFACE_SIDE_POPUP_LEFT);
    }

    @Step("Выбор элемента «Правая» выпадающего списка «Сторона интерфейса»")
    public void selectInterfaceSideRight() {
        methodsForElements.clickingOnListAndSelectListItem(INTERFACE_SIDE_TOGGLE_BUTTON, INTERFACE_SIDE_POPUP_RIGHT);
    }

    @Step("Считываем состояние переключателя «Показывать видовой куб»")
    public boolean showViewCubeToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_VIEW_CUBE_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать видовой куб»")
    public static void clickOnShowViewCubeToggleButton() {
        driver.findElement(SHOW_VIEW_CUBE_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Показывать миникарту»")
    public boolean showMinimapToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_MINIMAP_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать миникарту»")
    public static void clickOnShowMinimapToggleButton() {
        driver.findElement(SHOW_MINIMAP_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Показывать местоположение на карте»")
    public boolean showLocationOnTheMapToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_LOCATION_ON_MAP_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать местоположение на карте»")
    public static void clickOnShowLocationOnTheMapToggleButton() {
        driver.findElement(SHOW_LOCATION_ON_MAP_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Показывать кнопку панели карт»")
    public boolean showShowMapPaneButtonToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_MAP_PANE_BUTTON_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать кнопку панели карт»")
    public static void clickOnShowMapPaneButtonToggleButton() {
        driver.findElement(SHOW_MAP_PANE_BUTTON_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Прилипание рулетки к углам модели»")
    public boolean stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(STICKING_TAPE_MEASURE_TO_CORNERS_OF_MODEL_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Прилипание рулетки к углам модели»")
    public static void clickOnStickingTapeMeasureToCornersOfModelToggleButton() {
        driver.findElement(STICKING_TAPE_MEASURE_TO_CORNERS_OF_MODEL_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Отображать метки задач, находящихся вне поля зрения»")
    public boolean displayTaskOutOfSightToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(DISPLAY_TASK_OUT_OF_SIGHT_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Отображать метки задач, находящихся вне поля зрения»")
    public static void clickOnDisplayTaskOutOfSightToggleButton() {
        driver.findElement(DISPLAY_TASK_OUT_OF_SIGHT_TOGGLE_BUTTON).click();
    }

    @Step("Двигаем слайдер «Дальность видимости объектов»")
    public void moveSliderVisibilityRangeOfObjectsSlider(int percent) {
        WebElement slider = driver.findElement(VISIBILITY_RANGE_OF_OBJECTS_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Дальность видимости объектов»")
    public String readValueOfVisibilityRangeOfObjectsField() {
        return driver.findElement(VISIBILITY_RANGE_OF_OBJECTS_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Уровень детализации отрисовки»")
    public void moveSliderRenderingLevelOfDetail(int percent) {
        WebElement slider = driver.findElement(RENDERING_LEVEL_OF_DETAIL_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Уровень детализации отрисовки»")
    public String readValueRenderingLevelOfDetail() {
        return driver.findElement(RENDERING_LEVEL_OF_DETAIL_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Дальняя отсекающая плоскость»")
    public void moveSliderFarClippingPlane(int percent) {
        WebElement slider = driver.findElement(FAR_CLIPPING_PLANE_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Дальняя отсекающая плоскость»")
    public String readValueFarClippingPlane() {
        return driver.findElement(FAR_CLIPPING_PLANE_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Максимальная дальность отрисовки меток»")
    public void moveSliderMaximumRenderingDistanceLabels(int percent) {
        WebElement slider = driver.findElement(MAXIMUM_RENDERING_DISTANCE_LABELS_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Максимальная дальность отрисовки меток»")
    public String readValueOfMaximumRenderingDistanceLabelsField() {
        return driver.findElement(MAXIMUM_RENDERING_DISTANCE_LABELS_OUTPUT).getText();
    }

    @Step("Нажимаем на переключатель «Отображать метки задач, находящихся вне поля зрения»")
    public static void clickOnUseDrawDistanceToggleButton() {
        driver.findElement(USE_DRAW_DISTANCE_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Отображать метки задач, находящихся вне поля зрения»")
    public boolean useDrawDistanceToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(USE_DRAW_DISTANCE_TOGGLE_BUTTON);
    }
}
