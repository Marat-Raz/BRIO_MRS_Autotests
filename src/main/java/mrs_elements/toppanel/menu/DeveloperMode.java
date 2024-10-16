package mrs_elements.toppanel.menu;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static mrs_elements.toppanel.menu.DeveloperModeLocators.*;

public class DeveloperMode {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;
    public DeveloperMode(AppiumDriver driver) {
        this.driver = driver;
        methodsForElements = new MethodsForElements(driver);
    }

    public static void waitOpenDeveloperModeWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOfElementLocated(DEVELOPER_MODE_WINDOW));
    }

    public boolean developerModeWindowIsOpen() {
        waitOpenDeveloperModeWindow();
        return driver.findElement(DEVELOPER_MODE_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «◄»")
    public static void clickOnGoBackButton() {
        // todo проверить работу этой кнопки
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
        return methodsForElements.switchEnabled(VERTICAL_SYNC_TOGGLE_BUTTON);
    }

    @Step("Нажимаем на переключатель «Показывать статистику»")
    public static void clickOnShowStatisticsToggleButton() {
        driver.findElement(SHOW_STATISTICS_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Показывать статистику»")
    public boolean showStatisticsToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_STATISTICS_TOGGLE_BUTTON);
    }
    @Step("Нажимаем на переключатель «Показывать карту глубины вместо изображения с камеры»")
    public static void clickOnShowDepthMapInsteadOfCameraImageToggleButton() {
        driver.findElement(SHOW_DEPTH_MAP_INSTEAD_OF_CAMERA_IMAGE_TOGGLE_BUTTON).click();
    }
    @Step("Считываем состояние переключателя «Показывать карту глубины вместо изображения с камеры»")
    public boolean showDepthMapInsteadOfCameraImageToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(SHOW_DEPTH_MAP_INSTEAD_OF_CAMERA_IMAGE_TOGGLE_BUTTON);
    }
    @Step("Считываем установленное значение для «Режим миникарты»")
    public String minimapModeIs() {
        String minimapModeIs = driver.findElement(MINIMAP_MODE_TOGGLE_BUTTON).getText();
        return minimapModeIs;
    }

    @Step("Выбор элемента «Вращение карты» выпадающего списка «Режим миникарты»")
    public void selectMinimapModeMapRotation() {
        methodsForElements.clickingOnListAndSelectListItem(MINIMAP_MODE_TOGGLE_BUTTON, MINIMAP_MODE_POPUP_MAP_ROTATION);
    }

    @Step("Выбор элемента «Вращение маркера» выпадающего списка «Режим миникарты»")
    public void selectMinimapModeRotateMarker() {
        methodsForElements.clickingOnListAndSelectListItem(MINIMAP_MODE_TOGGLE_BUTTON, MINIMAP_MODE_POPUP_ROTATE_MARKER);
    }

    @Step("Считываем установленное значение для «Тип виртуальной клавиатуры»")
    public String virtualKeyboardTypeIs() {
        String virtualKeyboardTypeIs = driver.findElement(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON).getText();
        return virtualKeyboardTypeIs;
    }

    @Step("Выбор элемента «Встроенная в MRS» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeBuiltIntoMrs() {
        methodsForElements.clickingOnListAndSelectListItem(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON, VIRTUAL_KEYBOARD_TYPE_POPUP_BUILT_INTO_MRS);
    }

    @Step("Выбор элемента «Системная (Windows)» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeSystemWindows() {
        methodsForElements.clickingOnListAndSelectListItem(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON, VIRTUAL_KEYBOARD_TYPE_POPUP_SYSTEM_WINDOWS);
    }

    @Step("Выбор элемента «Без виртуальной клавиатуры» выпадающего списка «Тип виртуальной клавиатуры»")
    public void selectVirtualKeyboardTypeNoVirtualKeyboard() {
        methodsForElements.clickingOnListAndSelectListItem(VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON, VIRTUAL_KEYBOARD_TYPE_POPUP_NO_VIRTUAL_KEYBOARD);
    }

    @Step("Клик на выпадающий список «Устройство голосового ввода» открывает Popup")
    public boolean clickingOnVoiceInputDeviceToggleButtonOpensPopup() {
        // methodsForElements не применить, т.к. метод просто проверяет что список есть.
        driver.findElement(VOICE_INPUT_DEVICE_TOGGLE_BUTTON).click();
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(VOICE_INPUT_DEVICE_POPUP));
        boolean isDisplayed = driver.findElement(VOICE_INPUT_DEVICE_POPUP).isDisplayed();
        driver.findElement(VOICE_INPUT_DEVICE_TOGGLE_BUTTON).click();
        return isDisplayed;
    }

    @Step("Нажимаем на переключатель «Перемещать камеру модели за реальной камерой»")
    public static void clickOnMoveTheModelSCameraBehindRealCameraToggleButton() {
        driver.findElement(MOVE_THE_MODEL_S_CAMERA_BEHIND_REAL_CAMERA_TOGGLE_BUTTON).click();
    }

    @Step("Считываем состояние переключателя «Перемещать камеру модели за реальной камерой»")
    public boolean theModelSCameraBehindRealCameraToggleButtonIsEnabled() {
        return methodsForElements.switchEnabled(MOVE_THE_MODEL_S_CAMERA_BEHIND_REAL_CAMERA_TOGGLE_BUTTON);
    }

    @Step("Двигаем слайдер «Скорость анимации камеры»")
    public void moveSliderCameraAnimationSpeedSlider(int percent) {
        WebElement slider = driver.findElement(CAMERA_ANIMATION_SPEED_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
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
        return methodsForElements.switchEnabled(SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON);
    }

    @Step("Слайдер «Расстояние до совпадения объектов» появился?")
    public boolean sliderDistanceToCoincidentFeaturesIsAppear() {
        String attr = driver.findElement(DISTANCE_TO_COINCIDENT_FEATURES_SLIDER).getAttribute("IsVisible");
        boolean IsVisible = Boolean.parseBoolean(attr);
        return IsVisible;
    }

    @Step("Двигаем слайдер «Расстояние до совпадения объектов»")
    public void moveSliderDistanceToCoincidentFeatures(int percent) {
        WebElement slider = driver.findElement(DISTANCE_TO_COINCIDENT_FEATURES_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Расстояние до совпадения объектов»")
    public String readValueOfDistanceToCoincidenceOfObjectsField() {
        return driver.findElement(DISTANCE_TO_COINCIDENT_FEATURES_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Прозрачность объекта пересечения»")
    public void moveTransparencyOfAnIntersectionObjectSlider(int percent) {
        WebElement slider = driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
    }

    @Step("Считываем состояние слайдера «Прозрачность объекта пересечения»")
    public String readValueOfTransparencyOfAnIntersectionObjectField() {
        return driver.findElement(TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_OUTPUT).getText();
    }

    @Step("Двигаем слайдер «Размер линии пересечения»")
    public void moveIntersectionLineSizeSlider(int percent) {
        WebElement slider = driver.findElement(INTERSECTION_LINE_SIZE_SLIDER);
        methodsForElements.moveSliderToPercent(slider, percent);
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
        (new WebDriverWait(driver, Duration.ofSeconds(3))).
                until(ExpectedConditions.visibilityOfElementLocated(STATISTICS_WINDOW));
    }

    public boolean statisticsWindowIsOpen() {
        waitOpenStatisticsWindow();
        return driver.findElement(STATISTICS_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку Х")
    public void clickOnXButton() {
        waitOpenDeveloperModeWindow();
        driver.findElement(DEVELOPER_MODE_X_BUTTON).click();
    }
}

