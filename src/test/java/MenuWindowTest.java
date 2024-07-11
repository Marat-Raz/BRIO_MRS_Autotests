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
    static MenuWindow menuWindow;
    static TopPanel topPanel;
    CloseAppMassage closeApp;
    ProfileWindow profileWindow;
    DeveloperMode developerMode;
    ScreenNumericKeyboard screenNumericKeyboard;
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
        Settings settings = new Settings(driver);
        settings.waitOpenSettingsWindow();
        settings.clickOnProfileButton();
        profileWindow = new ProfileWindow(driver);
        profileWindow.waitOpenProfileWindow();
    }

    @Step("Возврат из окна «Профиль» в главное окно «Меню»")
    public void returnToMainMenuWindowFromProfile() {
        profileWindow.clickOnGoBackButton();
        Settings settings = new Settings(driver);
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
    }
    @Step("Возврат из окна «Для разработчиков» в главное окно «Меню»")
    public void returnToMainMenuWindowFromDeveloperMode() {
        developerMode.clickOnBackButton();
        Settings settings = new Settings(driver);
        settings.waitOpenSettingsWindow();
        settings.clickOnBackButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
    }

    @Test
    @DisplayName("Нажать 5 раз на надпись с версией приложения")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnBRIO_MRSVersionTest() {
        menuWindow.clickFiveOnBrioMrsVersionButton();
        developerMode = new DeveloperMode(driver);
        developerMode.waitOpenDeveloperModeWindow();

            assertTrue(developerMode.developerModeWindowIsOpen());

        returnToMainMenuWindowFromDeveloperMode();
    }
    @Test
    @DisplayName("Нажать на «Закрыть приложение» и в запросе нажать на «Нет»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCloseApplicationButtonTest() {
        menuWindow.clickOnCloseApplicationButton();
        closeApp = new CloseAppMassage(driver);
        closeApp.waitOpenCloseAppWindow();
        closeApp.clickOnNoButton();

            assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажать на «Настройки»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnSettingsButtonTest() {
        menuWindow.clickOnSettingsButton();
        Settings settings = new Settings(driver);
        settings.waitOpenSettingsWindow();

            assertTrue(settings.settingsWindowIsOpen());

        settings.clickOnBackButton();
    }
/*    @Test
    @Muted
    @DisplayName("Нажать на «Свернуть окно»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnMinimizeButtonTest() {
        menuWindow.clickOnMinimizeButton();
    }*/

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

            assertEquals(origNumber - 1, changedNumber);

        returnToMainMenuWindowFromProfile();
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

            assertEquals(origNumber + 1, changedNumber);

        returnToMainMenuWindowFromProfile();
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

            assertEquals(origNumber, savedNumber);

        returnToMainMenuWindowFromProfile();
    }
    @Test
    @DisplayName("Нажатие на поле «Время на устранение задачи по умолчанию, дней» открывает экранную клавиатуру")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCounterOpenScreenKeyboardTest() {
        openProfileWindow();
        profileWindow.clickOnCounter();
        screenNumericKeyboard = new ScreenNumericKeyboard(driver);
        screenNumericKeyboard.waitOpenScreenNumericKeyboard();

            assertTrue(screenNumericKeyboard.ScreenNumericKeyboardIsOpen());

        returnToMainMenuWindowFromProfile();
    }
// TODO Нажатие на кнопку "На главную" тестировать, "Свернуть окно", на надпись версии БРИО МРС



}
