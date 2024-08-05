package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static mrs_elements.toppanel.menu.DeveloperModeLocators.*;

public class DeveloperMode {
    public static AppiumDriver driver;

    public DeveloperMode(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenDeveloperModeWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).
                until(ExpectedConditions.visibilityOfElementLocated(DEVELOPER_MODE_WINDOW));
    }

    public boolean developerModeWindowIsOpen() {
        waitOpenDeveloperModeWindow();
        return driver.findElement(DEVELOPER_MODE_WINDOW).isDisplayed();
    }

    public boolean switchEnabled(By by) {
        waitOpenDeveloperModeWindow();
        String attr = driver.findElement(by).getAttribute("IsChecked");
        boolean IsChecked = Boolean.parseBoolean(attr);
        return IsChecked;
    }

    public void moveSliderToPercent(WebElement slider, int percent) {
        Actions builder = new Actions(this.driver);
        Action dragAndDrop;
        int height = slider.getSize().getHeight();
        int width = slider.getSize().getWidth();
        int xHeight = (int) ((height * percent) / 100);
        int xWidth = (int) ((width * percent) / 100);

        if (width > height) {
            //highly likely a horizontal slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(-(width / 2), 0).
                    moveByOffset(xWidth, 0).
                    release().build();
        } else {
            //highly likely a vertical slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(0, -(height / 2)).
                    moveByOffset(0, xHeight).
                    release().build();
        }
        dragAndDrop.perform();
    }

    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnBackButton() {
        waitOpenDeveloperModeWindow();
        driver.findElement(DEVELOPER_MODE_GO_BACK).click();
    }
    @Step("Нажимаем на кнопку «Компьютерное зрение»")
    public static void clickOnComputerVisionButton() {
        waitOpenDeveloperModeWindow();
        driver.findElement(COMPUTER_VISION_BUTTON).click();
    }
    @Step("Нажимаем на переключатель «Вертикальная синхронизация»")
    public static void clickOnVerticalSyncToggleButton() {
        driver.findElement(VERTICAL_SYNC_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Вертикальная синхронизация»")
    public boolean verticalSyncToggleButtonIsEnabled() {
        return switchEnabled(VERTICAL_SYNC_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать статистику»")
    public static void clickOnShowStatisticsToggleButton() {
        driver.findElement(SHOW_STATISTICS_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Показывать статистику»")
    public boolean showStatisticsToggleButtonIsEnabled() {
        return switchEnabled(SHOW_STATISTICS_TOGGLE_BUTTON);
    }
    @Step("Нажимаем на переключатель «Показывать карту глубины вместо изображения с камеры»")
    public static void clickOnShowDepthMapInsteadOfCameraImageToggleButton() {
        driver.findElement(SHOW_DEPTH_MAP_INSTEAD_OF_CAMERA_IMAGE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Показывать карту глубины вместо изображения с камеры»")
    public boolean showDepthMapInsteadOfCameraImageToggleButtonIsEnabled() {
        return switchEnabled(SHOW_DEPTH_MAP_INSTEAD_OF_CAMERA_IMAGE_TOGGLE_BUTTON);
    }
    @Step("Считываем установленное значение для «Режим миникарты»")
    public String minimapModeIs() {
        String systemLanguage = driver.findElement(MINIMAP_MODE_TOGGLE_BUTTON).getText();
        return systemLanguage;
    }

    @Step("Выбор элемента «Вращение карты» выпадающего списка «Режим миникарты»")
    public void selectMinimapModeMapRotation() {
        driver.findElement(MINIMAP_MODE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(MINIMAP_MODE_POPUP_MAP_ROTATION));
        driver.findElement(MINIMAP_MODE_POPUP_MAP_ROTATION).click();
    }

    @Step("Выбор элемента «Вращение маркера» выпадающего списка «Режим миникарты»")
    public void selectMinimapModeRotateMarker() {
        driver.findElement(MINIMAP_MODE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(MINIMAP_MODE_POPUP_ROTATE_MARKER));
        WebElement popup = driver.findElement(MINIMAP_MODE_POPUP_ROTATE_MARKER);
        popup.click();
    }

    @Step("Считываем установленное значение для «Тип виртуальной клавиатуры»")
    public String virtualKeyboardTypeIs() {
        String systemLanguage = driver.findElement(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON).getText();
        return systemLanguage;
    }

    @Step("Выбор элемента «Встроенная в MRS» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeBuiltIntoMrs() {
        driver.findElement(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(VIRTUAL_KEYBOARD_TYPE_POPUP_BUILT_INTO_MRS));
        driver.findElement(VIRTUAL_KEYBOARD_TYPE_POPUP_BUILT_INTO_MRS).click();
    }

    @Step("Выбор элемента «Системная (Windows)» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeSystemWindows() {
        driver.findElement(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(VIRTUAL_KEYBOARD_TYPE_POPUP_SYSTEM_WINDOWS));
        WebElement popup = driver.findElement(VIRTUAL_KEYBOARD_TYPE_POPUP_SYSTEM_WINDOWS);
        popup.click();
    }

    @Step("Выбор элемента «Без виртуальной клавиатуры» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeNoVirtualKeyboard() {
        driver.findElement(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(VIRTUAL_KEYBOARD_TYPE_POPUP_NO_VIRTUAL_KEYBOARD));
        WebElement popup = driver.findElement(VIRTUAL_KEYBOARD_TYPE_POPUP_NO_VIRTUAL_KEYBOARD);
        popup.click();
    }
    @Step("Клик на выпадающий список «Устройство голосового ввода» открывает Popup")
    public boolean clickingOnVoiceInputDeviceToggleButtonOpensPopup() {
        driver.findElement(VOICE_INPUT_DEVICE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(VOICE_INPUT_DEVICE_POPUP));
        return driver.findElement(VOICE_INPUT_DEVICE_POPUP).isDisplayed();
    }
    @Step("Нажимаем на переключатель «Перемещать камеру модели за реальной камерой»")
    public static void clickOnMoveTheModelSCameraBehindRealCameraToggleButton() {
        driver.findElement(MOVE_THE_MODEL_S_CAMERA_BEHIND_REAL_CAMERA_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Перемещать камеру модели за реальной камерой»")
    public boolean theModelSCameraBehindRealCameraToggleButtonIsEnabled() {
        return switchEnabled(MOVE_THE_MODEL_S_CAMERA_BEHIND_REAL_CAMERA_TOGGLE_BUTTON);
    }
    @Step("Двигаем слайдер «Скорость анимации камеры»")
    public void moveSliderCameraAnimationSpeedSlider(int percent) {
        WebElement slider = driver.findElement(CAMERA_ANIMATION_SPEED_SLIDER);
        moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Скорость анимации камеры»")
    public String readValueOfCameraAnimationSpeedOutputField() {
        return driver.findElement(CAMERA_ANIMATION_SPEED_OUTPUT).getText();
    }
    @Step("Нажимаем на переключатель «Выделять совпадающие объекты»")
    public static void clickOnSelectCoincidentFeaturesToggleButton() {
        driver.findElement(SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Выделять совпадающие объекты»")
    public boolean selectCoincidentFeaturesToggleButtonIsEnabled() {
        return switchEnabled(SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON);
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

    @Step("Двигаем слайдер «Прозрачность объекта пересечения»")
    public void moveTransparencyOfAnIntersectionObjectSlider(int percent) {
        WebElement slider = driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_SLIDER);
        moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Прозрачность объекта пересечения»")
    public String readValueOfTransparencyOfAnIntersectionObjectField() {
        return driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Размер линии пересечения»")
    public void moveIntersectionLineSizeSlider(int percent) {
        WebElement slider = driver.findElement(INTERSECTION_LINE_SIZE_SLIDER);
        moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Размер линии пересечения»")
    public String readValueOfIntersectionLineSizeField() {
        return driver.findElement(INTERSECTION_LINE_SIZE_OUTPUT).getText();
    }

    @Step("Нажимаем вниз в полосе прокрутки")
    public static void clickOnRepeatButtonByScrollBar() {
        driver.findElement(REPEAT_BUTTON_BY_SCROLL_BAR).click();
    }

    @Step("Считываем состояние кнопки «Запись датасета»")
    public boolean beginButtonIsActive() {
        String attr = driver.findElement(DATASET_BTN).getAttribute("IsEnabled");
        boolean IsEnabled = Boolean.parseBoolean(attr);
        return IsEnabled;
    }

    @Step("Нажимаем на кнопку записи датасета")
    public static void clickBeginButton() {
        driver.findElement(DATASET_BTN).click();
    }
    @Step("Считываем текст с кнопки «Начать» записи датасета")
    public String getTextBeginButton() {
        return driver.findElement(DATASET_BTN).getText();
    }

    @Step("Проверяем что, файл датасета был создан (а затем удаляем его)")
    public boolean datasetFileWasCreatedAndThenDeleted(int minutesBack) {
        //на входе количество последних минут, за которое созданы файлы
        File f = new File("D:\\BRIO MRS 2.1.3-gui-tests\\Modules\\CVCore\\Datasets\\Brio");
        List<File> files = new ArrayList<File>();
        if(f.isDirectory()){

            File[] listFiles = f.listFiles();
            long timeAgo = System.currentTimeMillis() - minutesBack * 60 * 1000;

            for(File listFile : listFiles) {
                if(listFile.lastModified() > timeAgo) {
                    System.out.println("Найден файл созданный в течении " + minutesBack + " минут: " + listFile);
                    files.add(listFile);
                    listFile.delete();
                    System.err.println("Файл удален: " + listFile);
                } //else System.out.println("Файл не удовлетворяет условиям");
            }
        }
        if(files.size()>0)
            return true;
        else return false;
    }

    @Step("Нажимаем на кнопку «Собрать» для сбора логов в архив")
    public static void clickCollectButton() {
        driver.findElement(COLLECT_BUTTON).click();
    }

    @Step("Проверяем что, архив с логами создан, затем их удаляем")
    public static boolean checkingForFilesInFolderThenDeletingThem() {
        //проверка наличия файлов в папке, затем их удаление
        boolean result = false;
        String userPath = System.getProperty("user.home");
        File f = new File(userPath + "\\AppData\\LocalLow\\BRIO MRS\\BRIO MRS\\CollectedLogs\\");
        if(f.isDirectory()){
            File[] listFiles = f.listFiles();
            if (listFiles.length > 0) {
                result = true;
            } else result = false;
            for(File listFile : listFiles) {
                System.err.println("Файл удален: " + listFile);
                listFile.delete();
            }
        } return result;
    }

    public static void waitOpenStatisticsWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).
                until(ExpectedConditions.visibilityOfElementLocated(STATISTICS_WINDOW));
    }

    public boolean statisticsWindowIsOpen() {
        waitOpenStatisticsWindow();
        return driver.findElement(STATISTICS_WINDOW).isDisplayed();
    }


}

