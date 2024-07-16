import io.qameta.allure.Link;
import io.qameta.allure.Step;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.Settings;
import mrs_elements.toppanel.menu.settings.ProfileWindow;
import mrs_elements.toppanel.menu.settings.ScreenNumericKeyboard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.TopPanel;
import static org.junit.jupiter.api.Assertions.*;

public class MenuWindowTest extends TestsStarter {
    static TopPanel topPanel;
    CloseAppMassage closeApp;
    DeveloperMode developerMode;
    ScreenNumericKeyboard screenNumericKeyboard = new ScreenNumericKeyboard(driver);
    Settings settings = new Settings(driver);
    ProfileWindow profileWindow = new ProfileWindow(driver);
    static MenuWindow menuWindow;
    boolean result;

    @BeforeAll
    public static void clickOnMenuButton() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
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
        menuWindow.waitOpenMenuWindow();
    }
    @Step("Возврат из окна «Для разработчиков» в главное окно «Меню»")
    public void returnToMainMenuWindowFromDeveloperMode() {
        developerMode.clickOnBackButton();
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow.waitOpenMenuWindow();
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
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnSettingsButtonTest() throws InterruptedException {
        menuWindow.clickOnSettingsButton();
        result = settings.settingsWindowIsOpen();
        settings.clickOnBackButton();

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
    @DisplayName("Нажатие на поле «Время на устранение задачи по умолчанию, дней» открывает экранную клавиатуру")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCounterOpenScreenKeyboardTest() {
        openProfileWindow();
        profileWindow.clickOnCounter();
        screenNumericKeyboard = new ScreenNumericKeyboard(driver);
        result = screenNumericKeyboard.ScreenNumericKeyboardIsOpen();
        returnToMainMenuWindowFromProfile();

            assertTrue(result);
    }




}
