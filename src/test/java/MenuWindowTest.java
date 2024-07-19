import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.Settings;
import mrs_elements.toppanel.menu.settings.InterfaceWindow;
import mrs_elements.toppanel.menu.settings.ProfileWindow;
import mrs_elements.screenkeyboards.ScreenNumericKeyboard;
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
    static MenuWindow menuWindow;
    boolean result;
    static TopPanel topPanel;
    ScreenKeyboard screenKeyboard;
    @BeforeAll
    public static void clickOnMenuButton() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindowOpen();
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
    @Step("Возврат из окна «Для разработчиков» в главное окно «Меню»")
    public void returnToMainMenuWindowFromInterfaceWindow() {
        interfaceWindow.clickOnGoBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindowOpen();
    }
    /*    @Test
        @Muted
        @DisplayName("Нажать на «Свернуть окно»")
        @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
        public void clickOnMinimizeButtonTest() {
            menuWindow.clickOnMinimizeButton();
        }*/
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
    public void clickOnSettingsButtonTest() throws InterruptedException {
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
        int origNumber = Integer.parseInt(originalText.trim());
        int changedNumber = Integer.parseInt(changedText.trim());
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
        int origNumber = Integer.parseInt(originalText.trim());
        int changedNumber = Integer.parseInt(changedText.trim());
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
        int origNumber = Integer.parseInt(originalText.trim());
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

/*      loginWindow.enterTextInLoginInput("briocloud"); Не работает ввод непосредственно в эти поля ввода.
Связано с тем, что экранная клавиатура перехватывает фокус
        loginWindow.enterTextInPasswordInput("123");*/

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
    @DisplayName("Включить и выключить переключатель «Показывать видовой куб»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-663")
    public void openInterfaceWindowTest() {
        openInterfaceWindow();
        interfaceWindow.clickOnShowViewCubeToggleButton();
        //todo isSelected для элемента ToggleButton всегда возвращает false. Нужно чтобы Данил решил вопрос на своей стороне
        result = interfaceWindow.showViewCubeToggleButtonIsEnabled();
        returnToMainMenuWindowFromInterfaceWindow();
            assertTrue(result);
    }

}
