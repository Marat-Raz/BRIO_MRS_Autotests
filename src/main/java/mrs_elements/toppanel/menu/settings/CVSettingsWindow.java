package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CVSettingsWindow {
    public static AppiumDriver driver;

    public CVSettingsWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public static final By GO_BACK_CV_SETTINGS_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Настройки CV']]");
    public static final By DEPTH_MAP_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Карта глубины']]");
    public static final By MULTI_MARKER_POSITIONING_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Многомаркерное позиционирование']/following-sibling::*");
    public static final By TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_OUTPUT =
            By.xpath("//TextBlock[@Text='Прозрачность объекта пересечения']/following-sibling::*");
    public static final By TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_SLIDER =
            By.xpath("//TextBlock[@Text='Прозрачность объекта пересечения']/parent::*/parent::*/child::Slider");
    public static final By INTERSECTION_LINE_SIZE_OUTPUT =
            By.xpath("//TextBlock[@Text='Размер линии пересечения']/following-sibling::*");
    public static final By INTERSECTION_LINE_SIZE_SLIDER =
            By.xpath("//TextBlock[@Text='Размер линии пересечения']/parent::*/parent::*/child::Slider");
    public static void waitOpenCVSettingsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).
                until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_CV_SETTINGS_BUTTON));
    }
    public boolean CVSettingsWindowIsOpen() {
        waitOpenCVSettingsWindow();
        return driver.findElement(GO_BACK_CV_SETTINGS_BUTTON).isDisplayed();
    }
    public boolean switchEnabled(By by) {
        waitOpenCVSettingsWindow();
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
        return switchEnabled(MULTI_MARKER_POSITIONING_TOGGLE_BUTTON);
    }
    @Step("Двигаем слайдер «Прозрачность объекта пересечения»")
    public void moveTransparencyOfAnIntersectionObjectSlider(int percent) {
        WebElement slider = driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_SLIDER);
        moveSliderToPercent(slider, percent);
    }
    @Step("Считываем состояние слайдера «Прозрачность объекта пересечения»")
    public String readValueOfTransparencyOfAnIntersectionObjectField() {
        return driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_OUTPUT).getText();
    }
    @Step("Двигаем слайдер «Прозрачность объекта пересечения»")
    public void moveIntersectionLineSizeSlider(int percent) {
        WebElement slider = driver.findElement(INTERSECTION_LINE_SIZE_SLIDER);
        moveSliderToPercent(slider, percent);
    }
    @Step("Считываем состояние слайдера «Прозрачность объекта пересечения»")
    public String readValueOfIntersectionLineSizeField() {
        return driver.findElement(INTERSECTION_LINE_SIZE_OUTPUT).getText();
    }

}
