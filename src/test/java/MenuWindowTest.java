import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.screenkeyboards.ScreenNumericKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuWindowTest extends TestsStarter {
    CloseAppMassage closeApp;
    ScreenNumericKeyboard screenNumericKeyboard = new ScreenNumericKeyboard(driver);
    SettingsWindow settingsWindow = new SettingsWindow(driver);
    ProfileWindow profileWindow = new ProfileWindow(driver);
    CVSettingsWindow cVSettingsWindow = new CVSettingsWindow(driver);
    DepthMapWindow depthMapWindow = new DepthMapWindow(driver);
    AboutDeviceWindow aboutDeviceWindow = new AboutDeviceWindow(driver);
    MenuWindow menuWindow = new MenuWindow(driver);
    ScreenKeyboard screenKeyboard;
    TopPanel topPanel = new TopPanel(driver);
    boolean result, newResult, oldResult;
    int origNumber, changedNumber;
    String originalText, changedText;

    @BeforeEach
    public void clickOnMenuButton() {
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow.waitOpenMenuWindow();
    }

    @AfterEach
    public void closeMenu() throws InterruptedException {
        menuWindow.waitOpenMenuWindow();
        menuWindow.clickOnXButton();
        topPanel.waitOpenTopPanel();
        Thread.sleep(600);
    }

    @Step("Открытие окна «Настройки»")
    public void openSettingsWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
    }

    @Step("Открытие окна «Профиль»")
    public void openProfileWindow() {
        openSettingsWindow();
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

    @Step("Открытие окна «Настройки CV»")
    public void openCVSettingsWindow() {
        openSettingsWindow();
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
        openProfileWindow();
        result = profileWindow.profileWindowIsOpen();
        returnToMainMenuWindowFromProfile();
        assertTrue(result);
    }

    @Test
    @DisplayName("Изменение значения поля «Время на устранение задачи по умолчанию, дней» нажатием на «-» и «+»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void changingValueOfCounterClickMinusButtonTest() {
        openProfileWindow();
        originalText = profileWindow.getTextFromCounter();
        profileWindow.clickOnMinusButton();
        changedText = profileWindow.getTextFromCounter();
        origNumber = Integer.parseInt(originalText.trim());
        changedNumber = Integer.parseInt(changedText.trim());
        profileWindow.clickOnPlusButton();
        String revertedText = profileWindow.getTextFromCounter();
        int revertedNumber = Integer.parseInt(revertedText.trim());
        returnToMainMenuWindowFromProfile();
        assertEquals(origNumber - 1, changedNumber);
        assertEquals(origNumber, revertedNumber);

    }

    @Test
    @DisplayName("Измененные значения поля «Время на устранение задачи по умолчанию, дней» сохраняются")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void changingValueFromCounterSaveTest() {
        openProfileWindow();
        profileWindow.clickOnPlusButton();
        originalText = profileWindow.getTextFromCounter();
        origNumber = Integer.parseInt(originalText.trim());
        returnToMainMenuWindowFromProfile();
        openProfileWindow();
        String savedText = profileWindow.getTextFromCounter();
        int savedNumber = Integer.parseInt(savedText.trim());
        profileWindow.clickOnMinusButton();
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
    @DisplayName("Нажатие на кнопку «Выйти из аккаунта»")
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

}

