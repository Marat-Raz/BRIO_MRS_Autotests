import io.qameta.allure.Link;
import mrs_elements.login.LoginWindow;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.CloseAppMassage;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.InterfaceWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriverException;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestartMRSTests extends TestsStarter {
    TopPanel topPanel;
    MenuWindow menuWindow;
    CloseAppMassage closeApp;
    SettingsWindow settingsWindow;
    InterfaceWindow interfaceWindow;
    LoginWindow loginWindow;
    ScreenKeyboard screenKeyboard;
    boolean result;
    String oldValue, newValue;

    @BeforeEach
    public void clickOnMenuButton() throws InterruptedException {
        sleep(600);
        topPanel = new TopPanel(driver);
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
    }

    private void goToInterfaceWindow() {
        menuWindow.clickOnSettingsButton();
        settingsWindow = new SettingsWindow(driver);
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnInterfaceButton();
        interfaceWindow = new InterfaceWindow(driver);
        interfaceWindow.waitOpenInterfaceWindow();
    }

    @Test
    @DisplayName("Нажать на «Закрыть приложение» и в запросе нажать на «Да»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1792")
    public void clickOnCloseApplicationButtonTest() throws InterruptedException {
        menuWindow.clickOnCloseApplicationButton();
        closeApp = new CloseAppMassage(driver);
        try {
            closeApp.clickOnYesButton();
            driver.quit();

        } catch (WebDriverException ex) {
            // ignore exception because MRS is dead
        }
        result = (driver == null);
        //super.startNewMRS();
        assertTrue(result); // todo необходимо сравнить в assert закрытие МРС

    }

    @Test
    @DisplayName("Смена языка после перезапуска программы")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1574")
    public void changeLanguageInterfaceWindowTest() throws InterruptedException {
        goToInterfaceWindow();
        interfaceWindow.selectLanguageEnglish();
        oldValue = interfaceWindow.systemLanguageIs();
        try {
            driver.quit();
            driver = null;
        } catch (WebDriverException ex) {
            // ignore exception because MRS is dead
        }

        super.startNewMRS();
        clickOnMenuButton();
        goToInterfaceWindow();
        newValue = interfaceWindow.systemLanguageIs();
        interfaceWindow.selectLanguageRussian();
        assertEquals(newValue, oldValue);
    }

    @Test
    @DisplayName("Автовход в приложение, если был сделан выход из системы")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1565")
    public void clickOnLogOutAccountButtonTest() throws InterruptedException {
        menuWindow.clickOnLogOutAccountButton();
        Thread.sleep(2000);
        try {
            driver.quit();
        } catch (WebDriverException ex) {
            // ignore exception because MRS is dead
        }
        startNewMRS();
        loginWindow = new LoginWindow(driver);
        result = loginWindow.loginWindowIsOpen();

        loginWindow.clickLoginInput();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.enterTextToScreenKeyboardInput("Autotests");
        loginWindow.clickPasswordInput();
        screenKeyboard.enterTextToScreenKeyboardInput("Autotests123456");
        loginWindow.clickContinueButton();

        assertTrue(result);

    }

    // todo добавить другие тесты связанные с закрытием приложения МРС
}
