package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static mrs_elements.toppanel.menu.settings.InterfaceWindowLocators.*;

public class InterfaceWindow {
    public static AppiumDriver driver;

    public InterfaceWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenInterfaceWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_INTERFACE_BUTTON));
    }

    public boolean interfaceWindowIsOpen() {
        waitOpenInterfaceWindow();
        return driver.findElement(GO_BACK_INTERFACE_BUTTON).isDisplayed();
    }
    public boolean switchEnabled(By by) {
        waitOpenInterfaceWindow();
        String attr = driver.findElement(by).getAttribute("IsChecked");
        boolean IsChecked = Boolean.parseBoolean(attr);
        return IsChecked;
    }
    public void moveSliderToPercent(WebElement slider, int percent){
        Actions builder = new Actions(this.driver);
        Action dragAndDrop;
        int height = slider.getSize().getHeight();
        int width = slider.getSize().getWidth();
        int xHeight = (int)((height*percent)/100);
        int xWidth = (int)((width*percent)/100);

        if(width>height){
            //highly likely a horizontal slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(-(width/2),0).
                    moveByOffset(xWidth,0).
                    release().build();
        }else{
            //highly likely a vertical slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(0, -(height/2)).
                    moveByOffset(0,xHeight).
                    release().build();
        }
        dragAndDrop.perform();
    }
    @Step("Нажимаем на кнопку «<Интерфейс»")
    public static void clickOnGoBackButton() {
        waitOpenInterfaceWindow();
        driver.findElement(GO_BACK_INTERFACE_BUTTON).click();
    }

    //Todo Нужно дождаться доработки кода получения структуры ui от Данила потом продолжить работу с выпадающими списками: Язык и Сторона Интерфейса
    @Step("Считываем язык системы")
    public String systemLanguageIs() {
        String systemLanguage = driver.findElement(INTERFACE_LANGUAGE).getText();
        return systemLanguage;
    }
/*    @Step("Выбор элемента выпадающего списка «Язык»")
    public void changeLanguage() {
        if (systemLanguageIs().equals("Русский") ) {
            driver.findElement(LANGUAGE_TOGGLE_BUTTON_IN_RUSSIAN).click();
            //(new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE_POPUP_ENGLISH));
            driver.findElement(LANGUAGE_POPUP_ENGLISH).click();
        } else {
            driver.findElement(LANGUAGE_TOGGLE_BUTTON_IN_ENGLISH).click();
            //(new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE_POPUP_RUSSIAN));
            driver.findElement(LANGUAGE_POPUP_RUSSIAN).click();
        }
    }*/
    @Step("Выбор элемента «Русский» выпадающего списка «Язык»")
    public void selectLanguageRussian() {
        driver.findElement(INTERFACE_LANGUAGE).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE_POPUP_RUSSIAN));
        driver.findElement(LANGUAGE_POPUP_RUSSIAN).click();
    }
    @Step("Выбор элемента «English (US)» выпадающего списка «Язык»")
    public void selectLanguageEnglish() {
        driver.findElement(INTERFACE_LANGUAGE).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(LANGUAGE_POPUP_ENGLISH));
        WebElement popup = driver.findElement(LANGUAGE_POPUP_ENGLISH);
        popup.click();
    }
    @Step("Считываем сторону интерфейса")
    public String interfaceSideIs() {
        String interfaceSide = driver.findElement(INTERFACE_SIDE).getText();
        return interfaceSide;
    }
    @Step("Выбор элемента «Левая» выпадающего списка «Сторона интерфейса»")
    public void selectInterfaceSideLeft() {
        driver.findElement(INTERFACE_SIDE).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(INTERFACE_SIDE_POPUP_LEFT));
        driver.findElement(INTERFACE_SIDE_POPUP_LEFT).click();
    }
    @Step("Выбор элемента «Правая» выпадающего списка «Сторона интерфейса»")
    public void selectInterfaceSideRight() {
        driver.findElement(INTERFACE_SIDE).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(INTERFACE_SIDE_POPUP_RIGHT));
        driver.findElement(INTERFACE_SIDE_POPUP_RIGHT).click();
    }
    @Step("Считываем состояние переключателя «Показывать видовой куб»")
    public boolean showViewCubeToggleButtonIsEnabled() {
        return switchEnabled(SHOW_VIEW_CUBE_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать видовой куб»")
    public static void clickOnShowViewCubeToggleButton() {
        driver.findElement(SHOW_VIEW_CUBE_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Показывать миникарту»")
    public boolean showMinimapToggleButtonIsEnabled() {
        return switchEnabled(SHOW_MINIMAP_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать миникарту»")
    public static void clickOnShowMinimapToggleButton() {
        driver.findElement(SHOW_MINIMAP_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Показывать местоположение на карте»")
    public boolean showLocationOnTheMapToggleButtonIsEnabled() {
        return switchEnabled(SHOW_LOCATION_ON_MAP_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать местоположение на карте»")
    public static void clickOnShowLocationOnTheMapToggleButton() {
        driver.findElement(SHOW_LOCATION_ON_MAP_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Выделять совпадающие объекты»")
    public boolean selectCoincidentFeaturesToggleButtonIsEnabled() {
        return switchEnabled(SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Выделять совпадающие объекты»")
    public static void clickOnSelectCoincidentFeaturesToggleButton() {
        driver.findElement(SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Прилипание рулетки к углам модели»")
    public boolean stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled() {
        return switchEnabled(STICKING_TAPE_MEASURE_TO_CORNERS_OF_MODEL_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Прилипание рулетки к углам модели»")
    public static void clickOnStickingTapeMeasureToCornersOfModelToggleButton() {
        driver.findElement(STICKING_TAPE_MEASURE_TO_CORNERS_OF_MODEL_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Отображать метки задач, находящихся вне поля зрения»")
    public boolean displayTaskOutOfSightToggleButtonIsEnabled() {
        return switchEnabled(DISPLAY_TASK_OUT_OF_SIGHT_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Отображать метки задач, находящихся вне поля зрения»")
    public static void clickOnDisplayTaskOutOfSightToggleButton() {
        driver.findElement(DISPLAY_TASK_OUT_OF_SIGHT_TOGGLE_BUTTON).click();
    }
    @Step("Двигаем слайдер «Расстояние до совпадения объектов»")
    public void moveSliderDistanceToCoincidentFeatures(int percent) {
        WebElement slider = driver.findElement(DISTANCE_TO_COINCIDENT_FEATURES_SLIDER);
        moveSliderToPercent(slider, percent);
    }
    @Step("Считываем состояние слайдера «Расстояние до совпадения объектов»")
    public String readValueOfDistanceToCoincidenceOfObjectsField() {
        return driver.findElement(DISTANCE_TO_COINCIDENT_FEATURES_OUTPUT).getText();
    }
    @Step("Двигаем слайдер «Дальность видимости объектов»")
    public void moveSliderVisibilityRangeOfObjectsSlider(int percent) {
        WebElement slider = driver.findElement(VISIBILITY_RANGE_OF_OBJECTS_SLIDER);
        moveSliderToPercent(slider, percent);
    }
    @Step("Считываем состояние слайдера «Дальность видимости объектов»")
    public String readValueOfVisibilityRangeOfObjectsField() {
        return driver.findElement(VISIBILITY_RANGE_OF_OBJECTS_OUTPUT).getText();
    }
    @Step("Двигаем слайдер «Максимальная дальность отрисовки меток»")
    public void moveMaximumRenderingDistanceLabelsSlider(int percent) {
        WebElement slider = driver.findElement(MAXIMUM_RENDERING_DISTANCE_LABELS_SLIDER);
        moveSliderToPercent(slider, percent);
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
        return switchEnabled(USE_DRAW_DISTANCE_TOGGLE_BUTTON);
    }
}
