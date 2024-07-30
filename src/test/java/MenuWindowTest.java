import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.Settings;
import mrs_elements.toppanel.menu.settings.CVSettingsWindow;
import mrs_elements.toppanel.menu.settings.DepthMapWindow;
import mrs_elements.toppanel.menu.settings.InterfaceWindow;
import mrs_elements.toppanel.menu.settings.ProfileWindow;
import mrs_elements.screenkeyboards.ScreenNumericKeyboard;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.TopPanel;
import static org.junit.jupiter.api.Assertions.*;

public class MenuWindowTest extends TestsStarter {
    CloseAppMassage closeApp;
    DeveloperMode developerMode;
    ScreenNumericKeyboard screenNumericKeyboard = new ScreenNumericKeyboard(driver);
    Settings settings = new Settings(driver);
    ProfileWindow profileWindow = new ProfileWindow(driver);
    InterfaceWindow interfaceWindow = new InterfaceWindow(driver);
    CVSettingsWindow cVSettingsWindow = new CVSettingsWindow(driver);
    DepthMapWindow depthMapWindow = new DepthMapWindow(driver);
    static MenuWindow menuWindow;
    ScreenKeyboard screenKeyboard;
    static TopPanel topPanel;
    boolean result, newResult, oldResult;
    int origNumber, changedNumber;
    String minValue, maxValue, medValue, oldValue, newValue;
    @BeforeAll
    public static void clickOnMenuButton() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindowOpen();
    }
    @AfterAll
    public static void closeMenu() {
        menuWindow.clickOnXButton();
    }
    @Step("Открытие окна «Профиль»")
    public void openProfileWindow() {
        menuWindow.clickOnSettingsButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnProfileButton();
        profileWindow.waitOpenProfileWindow();
    }

    @Step("Возврат из окна «Профиль» в главное окно «Меню»")
    public void returnToMainMenuWindowFromProfile() {
        profileWindow.clickOnGoBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindowOpen();
    }
    @Step("Возврат из окна «Для разработчиков» в главное окно «Меню»")
    public void returnToMainMenuWindowFromDeveloperMode() {
        developerMode.clickOnBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindowOpen();
    }
    @Step("Открытие окна «Интерфейс»")
    public void openInterfaceWindow() {
        menuWindow.clickOnSettingsButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnInterfaceButton();
        interfaceWindow.waitOpenInterfaceWindow();
    }
    @Step("Возврат из окна «Интерфейс» в главное окно «Меню»")
    public void returnToMainMenuWindowFromInterfaceWindow() {
        interfaceWindow.clickOnGoBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindowOpen();
    }
    @Step("Открытие окна «Настройки CV»")
    public void openCVSettingsWindow() {
        menuWindow.clickOnSettingsButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnCVSettingsButton();
        cVSettingsWindow.waitOpenCVSettingsWindow();
    }
    @Step("Возврат из окна «Настройки CV» в главное окно «Меню»")
    public void returnToMainMenuWindowFromCVSettingsWindow() {
        cVSettingsWindow.clickOnGoBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindowOpen();
    }
    @Step("Открытие окна «Карта глубины»")
    public void openDepthMapWindow() {
        openCVSettingsWindow();
        cVSettingsWindow.clickOnDepthMapButton();
        depthMapWindow.waitOpenDepthMapWindow();
    }
    @Step("Возврат из окна «Карта глубины» в главное окно «Меню»")
    public void returnToMainMenuWindowFromDepthMapWindow() {
        depthMapWindow.clickOnGoBackButton();
        returnToMainMenuWindowFromCVSettingsWindow();
    }


    @Test
    @DisplayName("Нажать на «Свернуть окно»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnMinimizeButtonTest() throws InterruptedException {
        menuWindow.clickOnMinimizeButton();
        Thread.sleep(1000);
        driver.manage().window().maximize();
    }
//TIP привет

    @Test
    @DisplayName("Нажать 5 раз на надпись с версией приложения")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnBRIO_MRSVersionTest() {
        menuWindow.clickFiveOnBrioMrsVersionButton();
        developerMode = new DeveloperMode(driver);
        result = developerMode.developerModeWindowIsOpen();
        returnToMainMenuWindowFromDeveloperMode();
            assertTrue(result);
    }
    @Test
    @DisplayName("Нажать на «Закрыть приложение» и в запросе нажать на «Нет»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCloseApplicationButtonTest() {
        menuWindow.clickOnCloseApplicationButton();
        closeApp = new CloseAppMassage(driver);
        closeApp.clickOnNoButton();
        result = menuWindow.menuWindowIsOpen();
            assertTrue(result);
    }
    @Test
    @DisplayName("Нажать на «Настройки»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-558")
    public void clickOnSettingsButtonTest() {
        menuWindow.clickOnSettingsButton();
        result = settings.settingsWindowIsOpen();
        settings.clickOnBackButton();
            assertTrue(result);
    }
    @Test
    @DisplayName("Страница настроек «Профиль» открыта?")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void profileWindowIsOpenTest() {
        menuWindow.clickOnSettingsButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnProfileButton();
        result = profileWindow.profileWindowIsOpen();
        returnToMainMenuWindowFromProfile();
        assertTrue(result);
    }
    @Test
    @DisplayName("Изменение значения поля «Время на устранение задачи по умолчанию, дней» нажатием на «-»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void changingValueOfCounterClickMinusButtonTest() {
        openProfileWindow();
        String originalText = profileWindow.getTextFromCounter();
        profileWindow.clickOnMinusButton();
        String changedText = profileWindow.getTextFromCounter();
        origNumber = Integer.parseInt(originalText.trim());
        changedNumber = Integer.parseInt(changedText.trim());
        returnToMainMenuWindowFromProfile();
            assertEquals(origNumber - 1, changedNumber);
    }
    @Test
    @DisplayName("Изменение значения поля «Время на устранение задачи по умолчанию, дней» нажатием на «+»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void changingValueOfCounterClickPlusButtonTest() {
        openProfileWindow();
        String originalText = profileWindow.getTextFromCounter();
        profileWindow.clickOnPlusButton();
        String changedText = profileWindow.getTextFromCounter();
        origNumber = Integer.parseInt(originalText.trim());
        changedNumber = Integer.parseInt(changedText.trim());
        returnToMainMenuWindowFromProfile();
            assertEquals(origNumber + 1, changedNumber);
    }
    @Test
    @DisplayName("Измененные значения поля «Время на устранение задачи по умолчанию, дней» сохраняются")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void changingValueFromCounterSaveTest() {
        openProfileWindow();
        profileWindow.clickOnPlusButton();
        String originalText = profileWindow.getTextFromCounter();
        origNumber = Integer.parseInt(originalText.trim());
        returnToMainMenuWindowFromProfile();
        openProfileWindow();
        String savedText = profileWindow.getTextFromCounter();
        int savedNumber = Integer.parseInt(savedText.trim());
        returnToMainMenuWindowFromProfile();
            assertEquals(origNumber, savedNumber);
    }
    @Test
    @DisplayName("Нажатие на поле «Время на устранение задачи по умолчанию, дней» открывает экранную цифровую клавиатуру")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCounterOpenScreenKeyboardTest() {
        openProfileWindow();
        profileWindow.clickOnCounter();
        screenNumericKeyboard = new ScreenNumericKeyboard(driver);
        result = screenNumericKeyboard.ScreenNumericKeyboardIsOpen();
        returnToMainMenuWindowFromProfile();
            assertTrue(result);
    }
    @Test
    @DisplayName("Нажатие на кнопку «Выйти из акканта»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-424")
    public void clickOnLogOutAccountButtonAndLogInTest() {
        openProfileWindow();
        profileWindow.clickOnLogOutAccountButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        result = loginWindow.loginWindowIsOpen();

/*     loginWindow.enterTextInLoginInput("briocloud"); Не работает ввод непосредственно в эти поля ввода.
        Связано с тем, что экранная клавиатура перехватывает фокус
        loginWindow.enterTextInPasswordInput("123"); */

        loginWindow.clickLoginInput();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.enterTextToScreenKeyboardInput("briocloud");
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("123");
        loginWindow.clickContinueButton();
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindowOpen();
            assertTrue(result);
    }

    @Test
    @DisplayName("Открылось окно настроек интерфейса")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-673")
    public void openInterfaceWindowTest() {
        openInterfaceWindow();
        result = interfaceWindow.interfaceWindowIsOpen();
        returnToMainMenuWindowFromInterfaceWindow();
            assertTrue(result);
    }
    @Test
    @DisplayName("Смена языка")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-661")
    public void changeLanguageInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.selectLanguageEnglish();
        newValue = interfaceWindow.systemLanguageIs();
        interfaceWindow.selectLanguageRussian();
        oldValue = interfaceWindow.systemLanguageIs();
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals("English (US)", newValue);
            assertEquals("Русский", oldValue);
    }
    @Test
    @DisplayName("Сменить сторону интерфейса")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-662")
    public void changeInterfaceSideInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.selectInterfaceSideLeft();
        newValue = interfaceWindow.interfaceSideIs();
        interfaceWindow.selectInterfaceSideRight();
        oldValue = interfaceWindow.interfaceSideIs();
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals("Левая", newValue);
            assertEquals("Правая", oldValue);    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать видовой куб»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-663")
    public void showViewCubeInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.showViewCubeToggleButtonIsEnabled();
        interfaceWindow.clickOnShowViewCubeToggleButton();
        newResult = interfaceWindow.showViewCubeToggleButtonIsEnabled();
        interfaceWindow.clickOnShowViewCubeToggleButton();
        //todo еще нужно проверять включение видового куба на сцене
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Показывать миникарту»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-664")
    public void showMinimapInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.showMinimapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMinimapToggleButton();
        newResult = interfaceWindow.showMinimapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMinimapToggleButton();
        //todo еще нужно проверять включение миникарты на сцене
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Показывать местоположение на карте»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-665")
    public void showLocationOnTheMapInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.showLocationOnTheMapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowLocationOnTheMapToggleButton();
        newResult = interfaceWindow.showLocationOnTheMapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowLocationOnTheMapToggleButton();
        //todo еще нужно проверять включение на сцене + Включить переключатель "Показывать миникарту"
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Выделять совпадающие объекты»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-666")
    public void selectCoincidentFeaturesInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.selectCoincidentFeaturesToggleButtonIsEnabled();
        interfaceWindow.clickOnSelectCoincidentFeaturesToggleButton();
        newResult = interfaceWindow.selectCoincidentFeaturesToggleButtonIsEnabled();
        interfaceWindow.clickOnSelectCoincidentFeaturesToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Прилипание рулетки к углам модели»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-667")
    public void stickingTapeMeasureToCornersOfModelInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled();
        interfaceWindow.clickOnStickingTapeMeasureToCornersOfModelToggleButton();
        newResult = interfaceWindow.stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled();
        interfaceWindow.clickOnStickingTapeMeasureToCornersOfModelToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями тапами не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Двигать ползунок «Расстояние до совпадения объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-668")
    public void distanceToCoincidentFeaturesInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.moveSliderDistanceToCoincidentFeatures(50);
        medValue = interfaceWindow.readValueOfDistanceToCoincidenceOfObjectsField();
        interfaceWindow.moveSliderDistanceToCoincidentFeatures(0);
        minValue = interfaceWindow.readValueOfDistanceToCoincidenceOfObjectsField();
        interfaceWindow.moveSliderDistanceToCoincidentFeatures(100);
        maxValue = interfaceWindow.readValueOfDistanceToCoincidenceOfObjectsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals("10,0 см", medValue, "Значение отличается от ожидаемого");
            assertEquals("0,1 см", minValue, "Значение отличается от ожидаемого");
            assertEquals("20,0 см", maxValue, "Значение отличается от ожидаемого");

    }
    @Test
    @DisplayName("Двигать ползунок «Дальность видимости объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-669")
    public void visibilityRangeOfObjectsInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(50);
        medValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(0);
        minValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(100);
        maxValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertNotNull(medValue, "Значение не считано");
            assertEquals("2,000 м", minValue, "Значение отличается от ожидаемого");
            assertEquals("100,000 м", maxValue, "Значение отличается от ожидаемого");
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Отображать метки задач, находящихся вне поля зрения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-670")
    public void displayTaskOutOfSightInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.displayTaskOutOfSightToggleButtonIsEnabled();
        interfaceWindow.clickOnDisplayTaskOutOfSightToggleButton();
        newResult = interfaceWindow.displayTaskOutOfSightToggleButtonIsEnabled();
        interfaceWindow.clickOnDisplayTaskOutOfSightToggleButton();
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
        // todo рассмотреть возможность проверки работы этого переключателя с помощью модели
    }
    @Test
    @DisplayName("Двигать ползунок «Максимальная дальность отрисовки меток задач»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-671")
    public void maximumRenderingDistanceLabelsInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.moveMaximumRenderingDistanceLabelsSlider(50);
        medValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveMaximumRenderingDistanceLabelsSlider(0);
        minValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveMaximumRenderingDistanceLabelsSlider(100);
        maxValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertNotNull(medValue, "Значение не считано");
            assertEquals("1,0 м", minValue, "Значение отличается от ожидаемого");
            assertEquals("100,0 м", maxValue, "Значение отличается от ожидаемого");
    }
    @Test
    @DisplayName("Включить и выключить переключатель «Использовать ограничение дальности " +
            "отрисовки меток задач на виде модели»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-672")
    public void useDrawDistanceLimitForTaskLabelsInModelViewInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.useDrawDistanceToggleButtonIsEnabled();
        interfaceWindow.clickOnUseDrawDistanceToggleButton();
        newResult = interfaceWindow.useDrawDistanceToggleButtonIsEnabled();
        interfaceWindow.clickOnUseDrawDistanceToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Открыть окно «Настройки CV»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-677")
    public void openCVSettingsWindowTest() {
        openCVSettingsWindow();
        result = cVSettingsWindow.CVSettingsWindowIsOpen();
        returnToMainMenuWindowFromCVSettingsWindow();
            assertTrue(result);
    }
    @Test
    @DisplayName("Нажать на кнопку «Карта глубины»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnDepthMapButtonOpenDepthMapWindowTest() {
        openDepthMapWindow();
        result = depthMapWindow.depthMapWindowIsOpen();
        returnToMainMenuWindowFromDepthMapWindow();
            assertTrue(result);
    }
    @Test
    @DisplayName("Переключить «Многомаркерное позиционирование»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-674")
    public void clickOnMultiMarkerPositioningToggleButtonCVSettingsWindowTest() {
        openCVSettingsWindow();
        oldResult = cVSettingsWindow.multiMarkerPositioningToggleButtonIsEnabled();
        cVSettingsWindow.clickOnMultiMarkerPositioningToggleButton();
        newResult = cVSettingsWindow.multiMarkerPositioningToggleButtonIsEnabled();
        cVSettingsWindow.clickOnMultiMarkerPositioningToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        returnToMainMenuWindowFromCVSettingsWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Двигать ползунок «Прозрачность объекта пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-675")
    public void transparencyOfAnIntersectionObjectCVSettingsWindowTest() {
        openCVSettingsWindow();
        cVSettingsWindow.moveTransparencyOfAnIntersectionObjectSlider(50);
        medValue = cVSettingsWindow.readValueOfTransparencyOfAnIntersectionObjectField();
        cVSettingsWindow.moveTransparencyOfAnIntersectionObjectSlider(0);
        minValue = cVSettingsWindow.readValueOfTransparencyOfAnIntersectionObjectField();
        cVSettingsWindow.moveTransparencyOfAnIntersectionObjectSlider(100);
        maxValue = cVSettingsWindow.readValueOfTransparencyOfAnIntersectionObjectField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromCVSettingsWindow();
            assertEquals("50%", medValue, "Значение отличается от ожидаемого");
            assertEquals("0%", minValue, "Значение отличается от ожидаемого");
            assertEquals("100%", maxValue, "Значение отличается от ожидаемого");
    }
    @Test
    @DisplayName("Двигать ползунок «Размер линии пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-676")
    public void intersectionLineSizeCVSettingsWindowTest() {
        openCVSettingsWindow();
        cVSettingsWindow.moveIntersectionLineSizeSlider(50);
        medValue = cVSettingsWindow.readValueOfIntersectionLineSizeField();
        cVSettingsWindow.moveIntersectionLineSizeSlider(0);
        minValue = cVSettingsWindow.readValueOfIntersectionLineSizeField();
        cVSettingsWindow.moveIntersectionLineSizeSlider(100);
        maxValue = cVSettingsWindow.readValueOfIntersectionLineSizeField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromCVSettingsWindow();
            assertEquals("11.000", medValue, "Значение отличается от ожидаемого");
            assertEquals("2.000", minValue, "Значение отличается от ожидаемого");
            assertEquals("20.000", maxValue, "Значение отличается от ожидаемого");
    }
    @Test
    @DisplayName("Переключить «Аппаратная карта глубины»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnHardwareDepthMapToggleButtonDepthMapWindowTest() {
        openDepthMapWindow();
        oldResult = depthMapWindow.hardwareDepthMapToggleButtonIsEnabled();
        depthMapWindow.clickOnHardwareDepthMapToggleButton();
        newResult = depthMapWindow.hardwareDepthMapToggleButtonIsEnabled();
        depthMapWindow.clickOnHardwareDepthMapToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        returnToMainMenuWindowFromDepthMapWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Переключить «Фильтрация»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnFiltrationToggleButtonDepthMapWindowTest() {
        openDepthMapWindow();
        oldResult = depthMapWindow.filtrationToggleButtonIsEnabled();
        depthMapWindow.clickOnFiltrationToggleButton();
        newResult = depthMapWindow.filtrationToggleButtonIsEnabled();
        depthMapWindow.clickOnFiltrationToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        returnToMainMenuWindowFromDepthMapWindow();
            assertEquals(oldResult, !newResult);
    }
    @Test
    @DisplayName("Переключить «Усреднение»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnAveragingToggleButtonDepthMapWindowTest() {
        openDepthMapWindow();
        oldResult = depthMapWindow.averagingToggleButtonIsEnabled();
        depthMapWindow.clickOnAveragingToggleButton();
        newResult = depthMapWindow.averagingToggleButtonIsEnabled();
        depthMapWindow.clickOnAveragingToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        returnToMainMenuWindowFromDepthMapWindow();
            assertEquals(oldResult, !newResult);
    }
}

