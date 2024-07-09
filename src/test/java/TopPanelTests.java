import io.qameta.allure.Link;
import mrs_elements.toppanel.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopPanelTests extends TestsStarter{
    TopPanel topPanel = new TopPanel(driver);
    @Test
    @DisplayName("Нажатие кнопки «Синхронизация» открывает окно «Синхронизация»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnSynchronizationButtonTest() {
        topPanel.clickOnSynchronizationButton();
        SynchronizationWindow synchronizationWindow = new SynchronizationWindow(driver);
            assertTrue(synchronizationWindow.synchronizationDialogIsOpen());
        synchronizationWindow.clickOnXButton();
    }
    @Test
    @DisplayName("Нажатие кнопки «Уведомления» открывает окно «Уведомления»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnNotificationsButtonTest() {
        topPanel.clickOnNotificationsButton();
        NotificationsWindow notificationsWindow = new NotificationsWindow(driver);
            assertTrue(notificationsWindow.notificationsWindowIsOpen());
        notificationsWindow.clickOnXButton();
    }
/*    @Test
    @DisplayName("Нажатие кнопки «Оси» включает/выключает отображение осей на сцене")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnAxesButtonTest() {
        topPanel.clickOnAxesButton();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    } */
    @Test
    @DisplayName("Нажатие кнопки «Проводник» открывает окно «Проводник»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnExplorerButtonTest() {

        topPanel.clickOnExplorerButton();
        ExplorerWindow explorerWindow = new ExplorerWindow(driver);
        assertTrue(explorerWindow.explorerWindowIsOpen());
    }
  /*  @Test
    @DisplayName("Нажатие кнопки «Уровни» открывает окно «Уровни»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnHierarchyButtonTest() {
        topPanel.clickOnHierarchyButton();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажатие кнопки «Меню» открывает окно «Меню»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnMainMenuButtonTest() {
        topPanel.clickOnMainMenuButton();
        MenuWindow menuWindow = new MenuWindow(driver);
            assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажатие кнопки «AR» включает режим «AR»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnARTest() {
        topPanel.clickOnAR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажатие кнопки «MR» включает режим «MR»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnMRTest() {
        topPanel.clickOnMR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
    @Test
    @DisplayName("Нажатие кнопки «AMR» включает режим «AMR»")
    @Link(name = "Ссылка на тест-кейс отсуствует", url = " ")
    public void clickOnAMRTest() {
        topPanel.clickOnAMR();
        MenuWindow menuWindow = new MenuWindow(driver);
        assertTrue(menuWindow.menuWindowIsOpen());
    }
*/
}
