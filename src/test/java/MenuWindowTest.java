import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuWindowTest extends TestsStarter {
    CloseAppMassage closeApp;
    SettingsWindow settingsWindow = new SettingsWindow(driver);
    CVSettingsWindow cVSettingsWindow = new CVSettingsWindow(driver);
    DepthMapWindow depthMapWindow = new DepthMapWindow(driver);
    AboutDeviceWindow aboutDeviceWindow = new AboutDeviceWindow(driver);
    MenuWindow menuWindow = new MenuWindow(driver);
    ScreenKeyboard screenKeyboard;
    TopPanel topPanel = new TopPanel(driver);
    boolean result, newResult, oldResult, aResult;

    @BeforeEach
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(600);
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow.waitOpenMenuWindow();
    }

    @Step("Открытие окна «Настройки»")
    public void openSettingsWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
    }

    @Step("Открытие окна «Настройки CV»")
    public void openCVSettingsWindow() {
        openSettingsWindow();
        settingsWindow.clickOnCVSettingsButton();
        cVSettingsWindow.waitOpenCVSettingsWindow();
    }

    @Step("Открытие окна «Карта глубины»")
    public void openDepthMapWindow() {
        openCVSettingsWindow();
        cVSettingsWindow.clickOnDepthMapButton();
        depthMapWindow.waitOpenDepthMapWindow();
    }

    @Step("Открытие окна «Об устройстве»")
    public void openAboutDeviceWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnAboutButton();
        aboutDeviceWindow.waitOpenAboutDeviceWindow();
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
        aResult = menuWindow.menuWindowIsOpen();
        menuWindow.clickOnXButton();
        assertTrue(result);
        assertTrue(aResult);
    }

    @Test
    @DisplayName("Нажатие на кнопку «Выйти из аккаунта»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-424")
    public void clickOnLogOutAccountButtonAndLogInTest() {
        // todo приспособить под новое меню
        menuWindow.clickOnLogOutAccountButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        result = loginWindow.loginWindowIsOpen();

/*     loginWindow.enterTextInLoginInput("briocloud");
        //Не работает ввод непосредственно в эти поля ввода.
        //Связано с тем, что экранная клавиатура перехватывает фокус
        loginWindow.enterTextInPasswordInput("123");*/

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
    @DisplayName("Открыть окно «Настройки CV»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-677")
    public void openCVSettingsWindowTest() {
        openCVSettingsWindow();
        result = cVSettingsWindow.cVSettingsWindowIsOpen();
        //cVSettingsWindow.clickOnXButton();
        cVSettingsWindow.clickOnGoBackButton();
        aResult = settingsWindow.settingsWindowIsOpen();
        settingsWindow.clickOnXButton();
        assertTrue(result);
        assertTrue(aResult);
    }

    @Test
    @DisplayName("Нажать на кнопку «Карта глубины»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnDepthMapButtonOpenDepthMapWindowTest() {
        openDepthMapWindow();
        result = depthMapWindow.depthMapWindowIsOpen();
        depthMapWindow.clickOnGoBackButton();
        aResult = cVSettingsWindow.cVSettingsWindowIsOpen();
        cVSettingsWindow.clickOnXButton();
        assertTrue(result);
        assertTrue(aResult);
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
        cVSettingsWindow.clickOnXButton();
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
        depthMapWindow.clickOnXButton();
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
        depthMapWindow.clickOnXButton();
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
        depthMapWindow.clickOnXButton();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Нажать на кнопку «Об устройстве» открывает окно «Об устройстве»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void clickOnAboutDeviceButtonOpenAboutDeviceWindowTest() {
        openAboutDeviceWindow();
        result = aboutDeviceWindow.aboutDeviceWindowIsOpen();
        aboutDeviceWindow.clickOnGoBackButton();
        aResult = settingsWindow.settingsWindowIsOpen();
        settingsWindow.clickOnXButton();
        assertTrue(result);
        assertTrue(aResult);
    }

    @Test
    @DisplayName("Проверяем что серийный номер и дата изготовления не пусты в окне «Об устройстве»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-678")
    public void checkThatTheSerialNumberAndDateOfManufactureAreNotEmptyTest() {
        openAboutDeviceWindow();
        String serN = aboutDeviceWindow.readSerialNumberText();
        String dateM = aboutDeviceWindow.readDateOfManufactureText();
        aboutDeviceWindow.clickOnXButton();
        assertNotNull(serN);
        assertNotNull(dateM);
    }

}

