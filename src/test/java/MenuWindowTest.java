import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.screenkeyboards.ScreenNumericKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.menu.ComputerVisionWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuWindowTest extends TestsStarter {
    CloseAppMassage closeApp;
    DeveloperMode developerMode;
    ScreenNumericKeyboard screenNumericKeyboard = new ScreenNumericKeyboard(driver);
    SettingsWindow settingsWindow = new SettingsWindow(driver);
    ProfileWindow profileWindow = new ProfileWindow(driver);
    InterfaceWindow interfaceWindow = new InterfaceWindow(driver);
    CVSettingsWindow cVSettingsWindow = new CVSettingsWindow(driver);
    DepthMapWindow depthMapWindow = new DepthMapWindow(driver);
    AboutDeviceWindow aboutDeviceWindow = new AboutDeviceWindow(driver);
    ComputerVisionWindow computerVisionWindow =  new ComputerVisionWindow(driver);
    static MenuWindow menuWindow;
    ScreenKeyboard screenKeyboard;
    static TopPanel topPanel;
    boolean result, newResult, oldResult;
    int origNumber, changedNumber;
    String minValue, maxValue, medValue, oldValue, newValue, newValue1;

    @BeforeAll
    public static void clickOnMenuButton() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
    }

    /*    @AfterAll
        public static void closeMenu() {
            menuWindow.waitOpenMenuWindow();
            menuWindow.clickOnXButton();
        }*/
    @Step("Открытие окна «Профиль»")
    public void openProfileWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnProfileButton();
        profileWindow.waitOpenProfileWindow();
    }

    @Step("Возврат из окна «Профиль» в главное окно «Меню»")
    public void returnToMainMenuWindowFromProfile() {
        profileWindow.clickOnGoBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
    }

    @Step("Открытие окна «Интерфейс»")
    public void openInterfaceWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnInterfaceButton();
        interfaceWindow.waitOpenInterfaceWindow();
    }

    @Step("Возврат из окна «Интерфейс» в главное окно «Меню»")
    public void returnToMainMenuWindowFromInterfaceWindow() {
        interfaceWindow.clickOnGoBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
    }

    @Step("Открытие окна «Настройки CV»")
    public void openCVSettingsWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnCVSettingsButton();
        cVSettingsWindow.waitOpenCVSettingsWindow();
    }

    @Step("Возврат из окна «Настройки CV» в главное окно «Меню»")
    public void returnToMainMenuWindowFromCVSettingsWindow() {
        cVSettingsWindow.clickOnGoBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
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

    @Step("Открытие окна «Для разработчиков»")
    public void openDeveloperMode() {
        menuWindow.clickFiveOnBrioMrsVersionButton();
        developerMode = new DeveloperMode(driver);
        developerMode.waitOpenDeveloperModeWindow();
    }

    @Step("Возврат из окна «Для разработчиков» в главное окно «Меню»")
    public void returnToMainMenuWindowFromDeveloperMode() {
        developerMode.clickOnBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
    }
    @Step("Открытие окна «Компьютерное зрение»")
    public void openComputerVisionWindow() {
        openDeveloperMode();
        developerMode.clickOnComputerVisionButton();
        computerVisionWindow.waitOpenComputerVisionWindow();
    }

    @Step("Возврат из окна «Компьютерное зрение» в главное окно «Меню»")
    public void returnToMainMenuWindowFromComputerVisionWindow() {
        computerVisionWindow.clickOnBackButton();
        returnToMainMenuWindowFromDeveloperMode();
    }

    @Step("Открытие окна «Об устройстве»")
    public void openAboutDeviceWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnAboutButton();
        aboutDeviceWindow.waitOpenAboutDeviceWindow();
    }

    @Step("Возврат из окна «Об устройстве» в главное окно «Меню»")
    public void returnToMainMenuWindowFromAboutDeviceWindow() {
        aboutDeviceWindow.clickOnGoBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
    }

    @Test
    @DisplayName("Нажать на «Свернуть окно»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnMinimizeButtonTest() throws InterruptedException {
        menuWindow.clickOnMinimizeButton();
        Thread.sleep(1000);
        driver.manage().window().maximize();
    }

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
        result = settingsWindow.settingsWindowIsOpen();
        settingsWindow.clickOnGoBackButton();
        assertTrue(result);
    }

    @Test
    @DisplayName("Страница настроек «Профиль» открыта?")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void profileWindowIsOpenTest() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnProfileButton();
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
        profileWindow.clickOnPlusButton();
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
        menuWindow.waitOpenMenuWindow();
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
        assertEquals("Правая", oldValue);
    }

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
    @DisplayName("Включить и выключить переключатель «Показывать кнопку панели карт»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-650")
    public void showMapPaneButtonInterfaceWindowTest() {
        openInterfaceWindow();
        oldResult = interfaceWindow.showShowMapPaneButtonToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMapPaneButtonToggleButton();
        newResult = interfaceWindow.showShowMapPaneButtonToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMapPaneButtonToggleButton();
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
    @DisplayName("Двигать ползунок «Уровень детализации отрисовки»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-657")
    public void RenderingLevelOfDetailInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.moveSliderRenderingLevelOfDetail(50);
        medValue = interfaceWindow.readValueRenderingLevelOfDetail();
        interfaceWindow.moveSliderRenderingLevelOfDetail(0);
        minValue = interfaceWindow.readValueRenderingLevelOfDetail();
        interfaceWindow.moveSliderRenderingLevelOfDetail(100);
        maxValue = interfaceWindow.readValueRenderingLevelOfDetail();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
        assertEquals("52%", medValue, "Значение отличается от ожидаемого");
        assertEquals("5%", minValue, "Значение отличается от ожидаемого");
        assertEquals("100%", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Дальняя отсекающая плоскость»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-658")
    public void farClippingPlaneInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.moveSliderFarClippingPlane(50);
        medValue = interfaceWindow.readValueFarClippingPlane();
        interfaceWindow.moveSliderFarClippingPlane(0);
        minValue = interfaceWindow.readValueFarClippingPlane();
        interfaceWindow.moveSliderFarClippingPlane(100);
        maxValue = interfaceWindow.readValueFarClippingPlane();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromInterfaceWindow();
        assertNotNull(medValue, "Значение не считано");
        assertEquals("20,0 м", minValue, "Значение отличается от ожидаемого");
        assertEquals("10000,0 м", maxValue, "Значение отличается от ожидаемого");
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
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(50);
        medValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(0);
        minValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(100);
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

    @Test
    @DisplayName("Нажать на кнопку «Об устройстве» открывает окно «Об устройстве»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnAboutDeviceButtonOpenAboutDeviceWindowTest() {
        openAboutDeviceWindow();
        result = aboutDeviceWindow.aboutDeviceWindowIsOpen();
        returnToMainMenuWindowFromAboutDeviceWindow();
        assertTrue(result);
    }

    @Test
    @DisplayName("Проверяем что серийный номер и дата изготовления не пусты в окне «Об устройстве»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void checkThatTheSerialNumberAndDateOfManufactureAreNotEmptyTest() {
        openAboutDeviceWindow();
        String serN = aboutDeviceWindow.readSerialNumberText();
        String dateM = aboutDeviceWindow.readDateOfManufactureText();
        returnToMainMenuWindowFromAboutDeviceWindow();
        assertNotNull(serN);
        assertNotNull(dateM);
    }

    @Test
    @DisplayName("Нажатие на кнопку «Компьютерное зрение» открывает окно «Компьютерное зрение»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-648")
    public void computerVisionButtonDeveloperModeTest() {
        openDeveloperMode();
        developerMode.clickOnComputerVisionButton();
        result = computerVisionWindow.computerVisionWindowIsOpen();
        returnToMainMenuWindowFromComputerVisionWindow();
        assertTrue(result);
    } // todo доделать на это окно

    @Test
    @DisplayName("Включить и выключить переключатель «Вертикальная синхронизация»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-683")
    public void clickOnVerticalSyncToggleButtonDeveloperModeTest() {
        openDeveloperMode();
        oldResult = developerMode.verticalSyncToggleButtonIsEnabled();
        developerMode.clickOnVerticalSyncToggleButton();
        newResult = developerMode.verticalSyncToggleButtonIsEnabled();
        developerMode.clickOnVerticalSyncToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // todo проверить fps считывая данные из окна статистики
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать статистику»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-649")
    public void clickOnShowStatisticsToggleButtonDeveloperModeTest() {
        openDeveloperMode();
        oldResult = developerMode.showStatisticsToggleButtonIsEnabled();
        developerMode.clickOnShowStatisticsToggleButton();
        result = developerMode.statisticsWindowIsOpen();
        newResult = developerMode.showStatisticsToggleButtonIsEnabled();
        developerMode.clickOnShowStatisticsToggleButton();
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals(oldResult, !newResult);
        assertTrue(result);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать карту глубины вместо изображения с камеры»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-651")
    public void clickOnShowDepthMapInsteadOfCameraImageToggleButtonDeveloperModeTest() {
        openDeveloperMode();
        oldResult = developerMode.showDepthMapInsteadOfCameraImageToggleButtonIsEnabled();
        developerMode.clickOnShowDepthMapInsteadOfCameraImageToggleButton();
        newResult = developerMode.showDepthMapInsteadOfCameraImageToggleButtonIsEnabled();
        developerMode.clickOnShowDepthMapInsteadOfCameraImageToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Смена режима миникарты")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-652")
    public void changeMinimapModeDeveloperModeTest() {
        openDeveloperMode();
        developerMode.selectMinimapModeMapRotation();
        newValue = developerMode.minimapModeIs();
        developerMode.selectMinimapModeRotateMarker();
        oldValue = developerMode.minimapModeIs();
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals("Вращение карты", newValue);
        assertEquals("Вращение маркера", oldValue);
    }

    @Test
    @DisplayName("Смена режима миникарты")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-653")
    public void changeVirtualKeyboardTypeDeveloperModeTest() {
        openDeveloperMode();
        developerMode.selectVirtualKeyboardTypeBuiltIntoMrs();
        newValue = developerMode.virtualKeyboardTypeIs();
        developerMode.selectVirtualKeyboardTypeSystemWindows();
        oldValue = developerMode.virtualKeyboardTypeIs();
        developerMode.selectVirtualKeyboardTypeNoVirtualKeyboard();
        newValue1 = developerMode.virtualKeyboardTypeIs();
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals("Встроенная в MRS", newValue);
        assertEquals("Системная (Windows)", oldValue);
        assertEquals("Без виртуальной клавиатуры", newValue1);
        // todo позже проверить работу этих режимов
    }

    @Test
    @DisplayName("Клик на выпадающий список «Устройство голосового ввода» открывает Popup")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-654")
    public void clickingOnVoiceInputDeviceToggleButtonOpensPopupDeveloperModeTest() {
        openDeveloperMode();
        developerMode.selectVirtualKeyboardTypeBuiltIntoMrs();
        result = developerMode.clickingOnVoiceInputDeviceToggleButtonOpensPopup();
        returnToMainMenuWindowFromDeveloperMode();
        assertTrue(result);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Перемещать камеру модели за реальной камерой»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-655")
    public void clickOnMoveTheModelSCameraBehindRealCameraToggleButtonDeveloperModeTest() {
        openDeveloperMode();
        oldResult = developerMode.theModelSCameraBehindRealCameraToggleButtonIsEnabled();
        developerMode.clickOnMoveTheModelSCameraBehindRealCameraToggleButton();
        newResult = developerMode.theModelSCameraBehindRealCameraToggleButtonIsEnabled();
        developerMode.clickOnMoveTheModelSCameraBehindRealCameraToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Двигать ползунок «Скорость анимации камеры»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-656")
    public void cameraAnimationSpeedDeveloperModeTest() {
        openDeveloperMode();
        developerMode.moveSliderCameraAnimationSpeedSlider(50);
        medValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        developerMode.moveSliderCameraAnimationSpeedSlider(0);
        minValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        developerMode.moveSliderCameraAnimationSpeedSlider(100);
        maxValue = developerMode.readValueOfCameraAnimationSpeedOutputField();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertNotNull(medValue, "Значение не считано");
        assertEquals("0,00 с", minValue, "Значение отличается от ожидаемого");
        assertEquals("1,50 с", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Выделять совпадающие объекты»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-666")
    public void clickOnSelectCoincidentFeaturesToggleButtonDeveloperModeTest() {
        openDeveloperMode();
        oldResult = developerMode.selectCoincidentFeaturesToggleButtonIsEnabled();
        developerMode.clickOnSelectCoincidentFeaturesToggleButton();
        newResult = developerMode.selectCoincidentFeaturesToggleButtonIsEnabled();
        developerMode.clickOnSelectCoincidentFeaturesToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим сцены не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Двигать ползунок «Расстояние до совпадения объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-668")
    public void distanceToCoincidentFeaturesDeveloperModeTest() {
        openDeveloperMode();
        developerMode.moveSliderDistanceToCoincidentFeatures(50);
        medValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        developerMode.moveSliderDistanceToCoincidentFeatures(0);
        minValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        developerMode.moveSliderDistanceToCoincidentFeatures(100);
        maxValue = developerMode.readValueOfDistanceToCoincidenceOfObjectsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals("10,0 см", medValue, "Значение отличается от ожидаемого");
        assertEquals("0,1 см", minValue, "Значение отличается от ожидаемого");
        assertEquals("20,0 см", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Прозрачность объекта пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-675")
    public void transparencyOfAnIntersectionObjectDeveloperModeTest() {
        openDeveloperMode();
        developerMode.clickOnRepeatButtonByScrollBar();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(50);
        medValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(0);
        minValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        developerMode.moveTransparencyOfAnIntersectionObjectSlider(100);
        maxValue = developerMode.readValueOfTransparencyOfAnIntersectionObjectField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals("50%", medValue, "Значение отличается от ожидаемого");
        assertEquals("0%", minValue, "Значение отличается от ожидаемого");
        assertEquals("100%", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Размер линии пересечения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-676")
    public void intersectionLineSizeDeveloperModeTest() {
        openDeveloperMode();
        developerMode.clickOnRepeatButtonByScrollBar();
        developerMode.moveIntersectionLineSizeSlider(50);
        medValue = developerMode.readValueOfIntersectionLineSizeField();
        developerMode.moveIntersectionLineSizeSlider(0);
        minValue = developerMode.readValueOfIntersectionLineSizeField();
        developerMode.moveIntersectionLineSizeSlider(100);
        maxValue = developerMode.readValueOfIntersectionLineSizeField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        returnToMainMenuWindowFromDeveloperMode();
        assertNotNull(medValue, "Значение не считано");
        assertNotNull(minValue, "Значение не считано");
        assertNotNull(maxValue, "Значение не считано");
    }

    @Test
    @DisplayName("Проверяем активность кнопки «Начать» «Запись датасета»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-659")
    public void checkingActivityBeginButtonDeveloperModeTest() {
        openDeveloperMode();
        developerMode.clickOnRepeatButtonByScrollBar();
        result = developerMode.beginButtonIsActive();
        returnToMainMenuWindowFromDeveloperMode();
        System.out.println(result);
        assertFalse(result);
// todo перейти в режим камеры проверить нажатие и смену названия, проверить что был создан файл

    }

/*    @Test
    @DisplayName("Проверяем что, запись датасета произошел при нажатии на кнопку «Начать»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-659")
    public void checkThatDatasetWasRecordedWhenClickOnStartButtonDeveloperModeTest() throws InterruptedException {
        // todo выйти из меню, перейти в режим камеры, нажать на кнопку меню...
        openDeveloperMode();
        developerMode.clickOnRepeatButtonByScrollBar();
        oldValue = developerMode.getTextBeginButton();
        developerMode.clickBeginButton();
        Thread.sleep(3000);
        developerMode.clickBeginButton();
        result = developerMode.datasetFileWasCreatedAndThenDeleted(1);
        returnToMainMenuWindowFromDeveloperMode();
        assertEquals("Начать", oldValue);
        assertEquals("Остановить", oldValue);
        assertFalse(result);

    }*/

    @Test
    @DisplayName("Проверяем активность кнопки «Начать» «Запись датасета»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-659")
    public void collectLogsToArchiveDeveloperModeTest() {
        openDeveloperMode();
        developerMode.clickOnRepeatButtonByScrollBar();
        developerMode.clickCollectButton();
        result = developerMode.checkingForFilesInFolderThenDeletingThem();
        returnToMainMenuWindowFromDeveloperMode();
        System.out.println(result);
        assertTrue(result);
    }

}

