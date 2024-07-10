import io.qameta.allure.Link;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.menu.DeveloperMode;
import mrs_elements.toppanel.menu.Settings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mrs_elements.toppanel.menu.CloseApp;
import mrs_elements.toppanel.TopPanel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuWindowTest extends TestsStarter {
    static MenuWindow menuWindow;
    CloseApp closeApp;
    static TopPanel topPanel;
    @BeforeAll
    public static void clickOnMenuButton() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
    }
    @Test
    @DisplayName("Нажать на надпись с версией приложения")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnBRIO_MRSVersionTest() throws InterruptedException {
        menuWindow.clickFiveOnBrioMrsVersionButton();
        DeveloperMode developerMode = new DeveloperMode(driver);
            assertTrue(developerMode.developerModeWindowIsOpen());
        developerMode.clickOnBackButton();
        Thread.sleep(300);
        Settings settings = new Settings(driver);
        settings.clickOnBackButton();
        Thread.sleep(500);
    }
    @Test
    @DisplayName("Нажать на «Закрыть приложение» и в запросе нажать на «Нет»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnCloseApplicationButtonTest() {
        menuWindow.clickOnCloseApplicationButton();
        closeApp = new CloseApp(driver);
        CloseApp.clickOnNoButton();
            assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажать на «Настройки»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnSettingsButtonTest() {
        menuWindow.clickOnSettingsButton();
        Settings settings = new Settings(driver);
            assertTrue(settings.settingsWindowIsOpen());
        settings.clickOnBackButton();
    }
    @Test
    @DisplayName("Нажать на «Свернуть окно»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnclickOnMinimizeButtonTest() throws InterruptedException {
        menuWindow.clickOnMinimizeButton();
        Thread.sleep(1000);

        System.out.println("Ok");
        //menuWindow.clickOnBackButton();
    }
// TODO Нажатие на кнопку "На главную" тестировать, "Свернуть окно", на надпись версии БРИО МРС



}
