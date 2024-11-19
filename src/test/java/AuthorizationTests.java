import static generaldatatests.GeneralDataTests.BRIO_CLOUD_PASSWORD;
import static generaldatatests.GeneralDataTests.BRIO_CLOUD_USERNAME;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import io.qameta.allure.Link;
import mrselements.loggedmainpage.LoggedMainPage;
import mrselements.login.LoginWindow;
import mrselements.notifications.Notifications;
import mrselements.screenkeyboards.ScreenKeyboard;
import mrselements.toppanel.MenuWindow;
import mrselements.toppanel.TopPanel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTests extends TestsStarter {

  TopPanel topPanel = new TopPanel(driver);
  MenuWindow menuWindow = new MenuWindow(driver);
  LoginWindow loginWindow = new LoginWindow(driver);
  ScreenKeyboard screenKeyboard;
  LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
  Notifications notifications = new Notifications(driver);
  String txt;

  @BeforeEach
  public void logOut() throws InterruptedException {
    topPanel.waitOpenTopPanel();
    topPanel.clickOnMainMenuButton();
    menuWindow.clickOnLogOutAccountButton();
    loginWindow.waitOpenLoginWindow();
    String lang = loginWindow.getTitleTextOfChangeLanguageButton();
    while (!lang.equals("РУС")) {
      loginWindow.clickChangeLanguageButton();
      sleep(300);
      lang = loginWindow.getTitleTextOfChangeLanguageButton();
    }
    screenKeyboard = new ScreenKeyboard(driver);
  }

  @AfterEach
  public void logIn() {
    loginWindow.clickLoginInput();
    screenKeyboard.enterTextToScreenKeyboardInput(BRIO_CLOUD_USERNAME);
    loginWindow.clickPasswordInput();
    screenKeyboard.enterTextToScreenKeyboardInput(BRIO_CLOUD_PASSWORD);
    loginWindow.clickContinueButton();
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
    screenKeyboard.enterTextToScreenKeyboardInput(BRIO_CLOUD_USERNAME);
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
    screenKeyboard.enterTextToScreenKeyboardInput(BRIO_CLOUD_USERNAME);
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

  @Test
  @DisplayName("Нажимаем на кнопку смены языка")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-2036")
  public void changeLanguageTest() throws InterruptedException {
    String oldValue = loginWindow.getTitleTextOfChangeLanguageButton();
    loginWindow.clickChangeLanguageButton();
    String newValue = loginWindow.getTitleTextOfChangeLanguageButton();
    String value = "";
    while (!value.equals("РУС")) {
      loginWindow.clickChangeLanguageButton();
      sleep(300);
      value = loginWindow.getTitleTextOfChangeLanguageButton();
    }
    assertNotEquals(oldValue, newValue);
  }
}
