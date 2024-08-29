import io.qameta.allure.Link;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.login.LoginWindow;
import mrs_elements.notifications.Notifications;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.ProfileWindow;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTests extends TestsStarter {
     static TopPanel topPanel;
     static MenuWindow menuWindow;
     static SettingsWindow settingsWindow;
     static ProfileWindow profileWindow;
     static LoginWindow loginWindow;
     static ScreenKeyboard screenKeyboard;
     static LoggedMainPage loggedMainPage;
    Notifications notifications = new Notifications(driver);
    String txt;

    @BeforeAll
    public static void logOut() {
        topPanel = new TopPanel(driver);
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.clickOnSettingsButton();
        settingsWindow = new SettingsWindow(driver);
        settingsWindow.clickOnProfileButton();
        profileWindow = new ProfileWindow(driver);
        profileWindow.clickOnLogOutAccountButton();
        loginWindow = new LoginWindow(driver);
        loginWindow.waitOpenLoginWindow();
        screenKeyboard = new ScreenKeyboard(driver);
    }

    @AfterAll
    public static void logIn() {
        loginWindow.clickLoginInput();
        screenKeyboard.enterTextToScreenKeyboardInput("briocloud");
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("123");
        loginWindow.clickContinueButton();
        loggedMainPage = new LoggedMainPage(driver);
        loggedMainPage.waitOpenLoggedMainPage();
    }

    @Test
    @DisplayName("Вход в систему без учетных данных")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-165")
    public void logInWithoutCredentialsTest() {
        loginWindow.clickContinueButton();
        notifications.notificationsWindowIsOpen();
        txt = notifications.textFromNotifications();
        assertEquals("Ошибка\n" +
                "Вход не выполнен: Пaроль не должен быть пустым", txt);
    }

    @Test
    @DisplayName("Вход в систему используя только логин")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-163")
    public void loginUsingOnlyYourLoginTest() {
        loginWindow.clickLoginInput();
        screenKeyboard.enterTextToScreenKeyboardInput("briocloud");
        loginWindow.clickPasswordInput();
        screenKeyboard.clickClearButton();
        loginWindow.clickContinueButton();
        notifications.notificationsWindowIsOpen();
        txt = notifications.textFromNotifications();
        assertEquals("Ошибка\n" +
                "Вход не выполнен: Пaроль не должен быть пустым", txt);
    }

    @Test
    @DisplayName("Вход в систему с верным логином и неверным паролем")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-161")
    public void logInWithCorrectUsernameAndWrongPassTest() {
        loginWindow.clickLoginInput();
        screenKeyboard.enterTextToScreenKeyboardInput("briocloud");
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("1");
        loginWindow.clickContinueButton();
        notifications.notificationsWindowIsOpen();
        txt = notifications.textFromNotifications();
        assertEquals("Ошибка\n" +
                "Вход не выполнен: Неправильный пароль", txt);
    }

    @Test
    @DisplayName("Вход в систему используя только пароль")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-164")
    public void passwordOnlyLoginTest() {
        loginWindow.clickLoginInput();
        screenKeyboard.clickClearButton();
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("123");
        loginWindow.clickContinueButton();
        notifications.notificationsWindowIsOpen();
        txt = notifications.textFromNotifications();
        assertEquals("Ошибка\n" +
                "Вход не выполнен: Ключ не может быть пустым", txt);
    }

    @Test
    @DisplayName("Вход в систему с неверным логином и верным паролем")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-162")
    public void loggInWithWrongUsernameAndPassTest() {
        loginWindow.clickLoginInput();
        screenKeyboard.enterTextToScreenKeyboardInput("Буратино");
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("123");
        loginWindow.clickContinueButton();
        notifications.notificationsWindowIsOpen();
        txt = notifications.textFromNotifications();
        assertEquals("Ошибка\n" +
                "Вход не выполнен: Не удалось найти пользователя", txt);
    }

}
