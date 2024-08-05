import io.qameta.allure.Link;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.NotificationsWindow;
import mrs_elements.toppanel.SynchronizationWindow;
import mrs_elements.toppanel.TopPanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopPanelTests extends TestsStarter {
    TopPanel topPanel = new TopPanel(driver);
    boolean result;

    @Test
    @DisplayName("Нажатие кнопки «Синхронизация» открывает окно «Синхронизация»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnSynchronizationButtonTest() {
        topPanel.clickOnSynchronizationButton();
        SynchronizationWindow synchronizationWindow = new SynchronizationWindow(driver);
        result = synchronizationWindow.synchronizationDialogIsOpen();
        synchronizationWindow.clickOnXButton();
        assertTrue(result);
    }

    @Test
    @DisplayName("Нажатие кнопки «Уведомления» открывает окно «Уведомления»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnNotificationsButtonTest() {
        topPanel.clickOnNotificationsButton();
        NotificationsWindow notificationsWindow = new NotificationsWindow(driver);
        notificationsWindow.waitOpenNotificationsWindow();
        result = notificationsWindow.notificationsWindowIsOpen();
        notificationsWindow.clickOnXButton();
        assertTrue(result);
    }
    // FIXME

    /*    @Test
    @DisplayName("Нажатие кнопки «Оси» включает/выключает отображение осей на сцене")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnAxesButtonTest() {
        topPanel.clickOnAxesButton();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    } */
    // FIXME

    /*    @Test
        @DisplayName("Нажатие кнопки «Проводник» открывает окно «Проводник»")
        @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
        public void clickOnExplorerButtonTest() {
            topPanel.clickOnExplorerButton();
            ExplorerWindow explorerWindow = new ExplorerWindow(driver);
            result = explorerWindow.explorerWindowIsOpen();
            explorerWindow.clickOnBackButton();
                assertTrue(result);

        }*/
    // FIXME
  /*  @Test
    @DisplayName("Нажатие кнопки «Уровни» открывает окно «Уровни»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnHierarchyButtonTest() {
        topPanel.clickOnHierarchyButton();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
    */
    @Test
    @DisplayName("Нажатие кнопки «Меню» открывает окно «Меню»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnMainMenuButtonTest() throws InterruptedException {
        topPanel.clickOnMainMenuButton();
        MenuWindow menuWindow = new MenuWindow(driver);
        result = menuWindow.menuWindowIsOpen();
        menuWindow.clickOnXButton();
        assertTrue(result);
    }
    // FIXME
    /*
    @Test
    @DisplayName("Нажатие кнопки «AR» включает режим «AR»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnARTest() {
        topPanel.clickOnAR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
        // FIXME

    @Test
    @DisplayName("Нажатие кнопки «MR» включает режим «MR»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnMRTest() {
        topPanel.clickOnMR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
        // FIXME

    @Test
    @DisplayName("Нажатие кнопки «AMR» включает режим «AMR»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = " ")
    public void clickOnAMRTest() {
        topPanel.clickOnAMR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
*/
}
