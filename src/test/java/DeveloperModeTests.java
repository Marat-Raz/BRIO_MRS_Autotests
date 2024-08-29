import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.ComputerVisionWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.SettingsWindow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperModeTests extends TestsStarter {
    TopPanel topPanel = new TopPanel(driver);
    MenuWindow menuWindow = new MenuWindow(driver);
    SettingsWindow settingsWindow = new SettingsWindow(driver);
    DeveloperMode developerMode = new DeveloperMode(driver);
    ComputerVisionWindow computerVisionWindow =  new ComputerVisionWindow(driver);
    boolean result, newResult, oldResult;
    String minValue, maxValue, medValue, oldValue, newValue, thirdValue;

    @BeforeEach
    public void clickOnMenuButton() {
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow.waitOpenMenuWindow();
        menuWindow.clickFiveOnBrioMrsVersionButton();
        developerMode.waitOpenDeveloperModeWindow();
    }

    @AfterEach
    public void closeMenu() throws InterruptedException {
        developerMode.clickOnBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
        menuWindow.waitOpenMenuWindow();
        menuWindow.clickOnXButton();
        topPanel.waitOpenTopPanel();
        Thread.sleep(600);

    }

    @Step("Открытие окна «Компьютерное зрение»")
    public void openComputerVisionWindow() {
        developerMode.clickOnComputerVisionButton();
        computerVisionWindow.waitOpenComputerVisionWindow();
    }

    @Step("Возврат из окна «Компьютерное зрение» в главное окно «Меню»")
    public void returnToMainMenuWindowFromComputerVisionWindow() {
        computerVisionWindow.clickOnBackButton();
    }

    @Test
    @DisplayName("Нажать 5 раз на надпись с версией приложения")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnBRIO_MRSVersionTest() {
        result = developerMode.developerModeWindowIsOpen();
        assertTrue(result);
    }

    @Test
    @DisplayName("Нажатие на кнопку «Компьютерное зрение» открывает окно «Компьютерное зрение»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void computerVisionButtonDeveloperModeTest() {
        openComputerVisionWindow();
        result = computerVisionWindow.computerVisionWindowIsOpen();
        returnToMainMenuWindowFromComputerVisionWindow();
        assertTrue(result);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Вертикальная синхронизация»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-683")
    public void clickOnVerticalSyncToggleButtonDeveloperModeTest() {
        oldResult = developerMode.verticalSyncToggleButtonIsEnabled();
        developerMode.clickOnVerticalSyncToggleButton();
        newResult = developerMode.verticalSyncToggleButtonIsEnabled();
        developerMode.clickOnVerticalSyncToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // todo проверить fps считывая данные из окна статистики
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать статистику»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-649")
    public void clickOnShowStatisticsToggleButtonDeveloperModeTest() {
        oldResult = developerMode.showStatisticsToggleButtonIsEnabled();
        developerMode.clickOnShowStatisticsToggleButton();
        result = developerMode.statisticsWindowIsOpen();
        newResult = developerMode.showStatisticsToggleButtonIsEnabled();
        developerMode.clickOnShowStatisticsToggleButton();
        assertEquals(oldResult, !newResult);
        assertTrue(result);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать карту глубины вместо изображения с камеры»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-651")
    public void clickOnShowDepthMapInsteadOfCameraImageToggleButtonDeveloperModeTest() {
        oldResult = developerMode.showDepthMapInsteadOfCameraImageToggleButtonIsEnabled();
        developerMode.clickOnShowDepthMapInsteadOfCameraImageToggleButton();
        newResult = developerMode.showDepthMapInsteadOfCameraImageToggleButtonIsEnabled();
        developerMode.clickOnShowDepthMapInsteadOfCameraImageToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим камеры не протестить на автотестах.
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Смена режима миникарты")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-652")
    public void changeMinimapModeDeveloperModeTest() {
        developerMode.selectMinimapModeMapRotation();
        newValue = developerMode.minimapModeIs();
        developerMode.selectMinimapModeRotateMarker();
        oldValue = developerMode.minimapModeIs();
        assertEquals("Вращение карты", newValue);
        assertEquals("Вращение маркера", oldValue);
    }

    @Test
    @DisplayName("Смена режима миникарты")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-653")
    public void changeVirtualKeyboardTypeDeveloperModeTest() {
        developerMode.selectVirtualKeyboardTypeNoVirtualKeyboard();
        thirdValue = developerMode.virtualKeyboardTypeIs();
        developerMode.selectVirtualKeyboardTypeSystemWindows();
        oldValue = developerMode.virtualKeyboardTypeIs();
        developerMode.selectVirtualKeyboardTypeBuiltIntoMrs();
        newValue = developerMode.virtualKeyboardTypeIs();
        assertEquals("Встроенная в MRS", newValue);
        assertEquals("Системная (Windows)", oldValue);
        assertEquals("Без виртуальной клавиатуры", thirdValue);
        // todo позже проверить работу этих режимов
    }

    @Test
    @DisplayName("Клик на выпадающий список «Устройство голосового ввода» открывает Popup")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-654")
    public void clickingOnVoiceInputDeviceToggleButtonOpensPopupDeveloperModeTest() {
        result = developerMode.clickingOnVoiceInputDeviceToggleButtonOpensPopup();
        assertTrue(result);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Перемещать камеру модели за реальной камерой»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-655")
    public void clickOnMoveTheModelSCameraBehindRealCameraToggleButtonDeveloperModeTest() {
        oldResult = developerMode.theModelSCameraBehindRealCameraToggleButtonIsEnabled();
        developerMode.clickOnMoveTheModelSCameraBehindRealCameraToggleButton();
        newResult = developerMode.theModelSCameraBehindRealCameraToggleButtonIsEnabled();
        developerMode.clickOnMoveTheModelSCameraBehindRealCameraToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Двигать ползунок «Скорость анимации камеры»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-656")
    public void cameraAnimationSpeedDeveloperModeTest() {
        developerMode.moveSliderCameraAnimationSpeedSlider(50);
        medValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        developerMode.moveSliderCameraAnimationSpeedSlider(0);
        minValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        developerMode.moveSliderCameraAnimationSpeedSlider(100);
        maxValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        assertNotNull(medValue, "Значение не считано");
        assertEquals("0,00 с", minValue, "Значение отличается от ожидаемого");
        assertEquals("1,50 с", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Выделять совпадающие объекты»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-666")
    public void clickOnSelectCoincidentFeaturesToggleButtonDeveloperModeTest() {
        oldResult = developerMode.selectCoincidentFeaturesToggleButtonIsEnabled();
        developerMode.clickOnSelectCoincidentFeaturesToggleButton();
        newResult = developerMode.selectCoincidentFeaturesToggleButtonIsEnabled();
        developerMode.clickOnSelectCoincidentFeaturesToggleButton();
        if (oldResult | newResult) {
            result = developerMode.sliderDistanceToCoincidentFeaturesAppear();
        }
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        assertEquals(oldResult, !newResult);
        assertTrue(result);
    }

    @Test
    @DisplayName("Двигать ползунок «Расстояние до совпадения объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-668")
    public void distanceToCoincidentFeaturesDeveloperModeTest() {
        if (!developerMode.selectCoincidentFeaturesToggleButtonIsEnabled()) {
            developerMode.clickOnSelectCoincidentFeaturesToggleButton();
        }
        developerMode.moveSliderDistanceToCoincidentFeatures(50);
        medValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        developerMode.moveSliderDistanceToCoincidentFeatures(0);
        minValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        developerMode.moveSliderDistanceToCoincidentFeatures(100);
        maxValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        assertEquals("10,0 см", medValue, "Значение отличается от ожидаемого");
        assertEquals("0,1 см", minValue, "Значение отличается от ожидаемого");
        assertEquals("20,0 см", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Прозрачность объекта пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-675")
    public void transparencyOfAnIntersectionObjectDeveloperModeTest() {
        developerMode.clickOnRepeatButtonByScrollBar();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(50);
        medValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(0);
        minValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(100);
        maxValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        assertEquals("50%", medValue, "Значение отличается от ожидаемого");
        assertEquals("0%", minValue, "Значение отличается от ожидаемого");
        assertEquals("100%", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Размер линии пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-676")
    public void intersectionLineSizeDeveloperModeTest() {
        developerMode.clickOnRepeatButtonByScrollBar();
        // todo переделать метод перемещения для этого ползунка
        developerMode.moveIntersectionLineSizeSlider(50);
        medValue = developerMode.readValueOfIntersectionLineSizeField();
        developerMode.moveIntersectionLineSizeSlider(0);
        minValue = developerMode.readValueOfIntersectionLineSizeField();
        developerMode.moveIntersectionLineSizeSlider(100);
        maxValue = developerMode.readValueOfIntersectionLineSizeField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        assertNotNull(medValue, "Значение не считано");
        assertNotNull(minValue, "Значение не считано");
        assertNotNull(maxValue, "Значение не считано");
    }

    @Test
    @DisplayName("Проверяем активность кнопки «Начать» «Запись датасета»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-659")
    public void checkingActivityBeginButtonDeveloperModeTest() {
        developerMode.clickOnRepeatButtonByScrollBar();
        result = developerMode.beginButtonIsActive();
        assertFalse(result);
// todo перейти в режим камеры проверить нажатие и смену названия,
//  проверить что был создан файл

    }

    @Test
    @DisplayName("Проверяем что, запись датасета произошел при нажатии на кнопку «Начать»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-659")
    public void checkThatDatasetWasRecordedWhenClickOnStartButtonDeveloperModeTest() throws InterruptedException {
        // todo выйти из меню, перейти в режим камеры, нажать на кнопку меню...
        developerMode.clickOnRepeatButtonByScrollBar();
        oldValue = developerMode.getTextBeginButton();
        developerMode.clickBeginButton();
        Thread.sleep(3000);
        developerMode.clickBeginButton();
        result = developerMode.datasetFileWasCreatedAndThenDeleted(1);
        assertEquals("Начать", oldValue);
        assertEquals("Остановить", oldValue);
        assertFalse(result);

    }

    @Test
    @DisplayName("Проверяем работу кнопки «Собрать» из «Собрать логи в архив»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-660")
    public void collectLogsToArchiveDeveloperModeTest() {
        developerMode.clickOnRepeatButtonByScrollBar();
        developerMode.clickCollectButton();
        result = developerMode.checkingForFilesInFolderThenDeletingThem();
        assertTrue(result);
    }

    @Test
    @DisplayName("Нажать на раскрывающийся список «Пресет камеры (требуется аппаратная карта глубины)» и смена значений")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void changeCameraPresetComputerVisionTest() {
        openComputerVisionWindow();
        computerVisionWindow.selectCameraPresetDefaultPreset();
        oldValue = computerVisionWindow.cameraPresetIs();
        computerVisionWindow.selectCameraPresetHighResHighAccuracyPreset();
        newValue = computerVisionWindow.cameraPresetIs();
        computerVisionWindow.selectCameraPresetHighResHighDensityPreset();
        thirdValue = computerVisionWindow.cameraPresetIs();
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals("DefaultPreset.json", oldValue);
        assertEquals("HighResHighAccuracyPreset.json", newValue);
        assertEquals("HighResHighDensityPreset.json", thirdValue);
    }

    @Test
    @DisplayName("Нажать на раскрывающийся список «Алгоритм поиска Aruco» и смена значений")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void changeArucoSearchAlgorithmComputerVisionTest() {
        openComputerVisionWindow();
        computerVisionWindow.selectArucoSearchAlgorithmOpenCvStandard();
        oldValue = computerVisionWindow.arucoSearchAlgorithmIs();
        computerVisionWindow.selectArucoSearchAlgorithmBrio();
        newValue = computerVisionWindow.arucoSearchAlgorithmIs();
        computerVisionWindow.selectArucoSearchAlgorithmCustom();
        thirdValue = computerVisionWindow.arucoSearchAlgorithmIs();
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals("OpenCV (стандартный)", oldValue);
        assertEquals("Brio", newValue);
        assertEquals("Custom", thirdValue);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Обнаружение объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void clickOnObjectDetectionToggleButtonComputerVisionTest() {
        openComputerVisionWindow();
        oldResult = computerVisionWindow.objectDetectionToggleButtonIsEnabled();
        computerVisionWindow.clickOnObjectDetectionToggleButton();
        newResult = computerVisionWindow.objectDetectionToggleButtonIsEnabled();
        computerVisionWindow.clickOnObjectDetectionToggleButton();
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Коррекция метки по гироскопу»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void clickOnGyroscopeMarkCorrectionsToggleButtonComputerVisionTest() {
        openComputerVisionWindow();
        oldResult = computerVisionWindow.gyroscopeMarkCorrectionsToggleButtonIsEnabled();
        computerVisionWindow.clickOnGyroscopeMarkCorrectionsToggleButton();
        newResult = computerVisionWindow.gyroscopeMarkCorrectionsToggleButtonIsEnabled();
        computerVisionWindow.clickOnGyroscopeMarkCorrectionsToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Заморозка карты глубины»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void clickOnDepthMapFreezeToggleButtonComputerVisionTest() {
        openComputerVisionWindow();
        oldResult = computerVisionWindow.depthMapFreezeToggleButtonIsEnabled();
        computerVisionWindow.clickOnDepthMapFreezeToggleButton();
        newResult = computerVisionWindow.depthMapFreezeToggleButtonIsEnabled();
        computerVisionWindow.clickOnDepthMapFreezeToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Контур объектов всегда виден»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void clickOnOutlineOfObjectsIsAlwaysVisibleToggleButtonComputerVisionTest() {
        openComputerVisionWindow();
        oldResult = computerVisionWindow.outlineOfObjectsIsAlwaysVisibleToggleButtonIsEnabled();
        computerVisionWindow.clickOnOutlineOfObjectsIsAlwaysVisibleToggleButton();
        newResult = computerVisionWindow.outlineOfObjectsIsAlwaysVisibleToggleButtonIsEnabled();
        computerVisionWindow.clickOnOutlineOfObjectsIsAlwaysVisibleToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromComputerVisionWindow();
        assertEquals(oldResult, !newResult);
    }
}
