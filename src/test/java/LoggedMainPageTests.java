import io.qameta.allure.Link;
import io.qameta.allure.Links;
import mrs_elements.loggedmainpage.CreateNewProjectDialog;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.loggedmainpage.selectedProjectSideView.ObjectivesListView;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class LoggedMainPageTests extends TestsStarter {
    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
    CreateNewProjectDialog createNewProjectDialog = new CreateNewProjectDialog(driver);
    ScreenKeyboard screenKeyboard;
    SelectedProjectSideView selectedProjectSideView;
    DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
    boolean result;
    String actTxt;

    @Test
    @DisplayName("Нажать на кнопку «Создать новый»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1701")
    public void OpenAndCloseProjectCreationWindowTest() {
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        result = createNewProjectDialog.createNewProjectDialogIsOpen();
        createNewProjectDialog.clickOnCancelButton();
        assertTrue(result);
    }

    @Test
    @DisplayName("Открыть и Закрыть окно «Создать проекты из папок»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1461")
    public void OpenAndCloseCreateProjectsFromFoldersWindowTest() {
        loggedMainPage.clickOnCreateProjectsFromFoldersButton();
        result = importLocalProjectsView.importLocalProjectsViewIsOpen();
        importLocalProjectsView.clickOnCancelButton();
        assertTrue(result);
    }

    @Test
    @DisplayName("Нажатие на поле ввода «Поиск» открывает экранную клавиатуру")
    @Link(name = "Ссылка на тест-кейс 1", url = "https://app.qase.io/case/MRS-1700")
    public void clickingOnSearchInputFieldOpensOnScreenKeyboardTest() {
        loggedMainPage.clickOnInputFieldSearch();
        screenKeyboard = new ScreenKeyboard(driver);
        result = screenKeyboard.screenKeyboardIsOpen();
        screenKeyboard.clickHideKeyboardButton();
        assertTrue(result);
    }

    @Test
    @DisplayName("Нажатие на проект открывает окно-меню проекта и меняется текст кнопки «Создать новый»")
    @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1443"),
                    @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-2040")})
    public void clickOnProjectTest() throws InterruptedException {
        if (!loggedMainPage.desiredProjectIsDisplayed("BRIO-Test")) {
            loggedMainPage.clickOnCreateProjectsFromFoldersButton();
            importLocalProjectsView.waitOpenImportLocalProjectsView();
            importLocalProjectsView.moveToElementAndClickOnProject("BRIO-Test");
            importLocalProjectsView.clickOnCreateButton();
            loggedMainPage.waitOpenLoggedMainPage();
            sleep(1000);
        }
        loggedMainPage.findProjectAndClickThem("BRIO-Test");
        sleep(500);
        actTxt = loggedMainPage.getTextOpenOrCreateProjectButton();
        selectedProjectSideView = new SelectedProjectSideView(driver);
        ObjectivesListView objectivesListView = new ObjectivesListView(driver);
        result = selectedProjectSideView.selectedProjectSideViewIsOpen();
        boolean anResult = objectivesListView.projectHasNotObjectives();
        loggedMainPage.findProjectAndClickThem("BRIO-Test");
        if (loggedMainPage.desiredProjectIsDisplayed("BRIO-Test")) {
            loggedMainPage.findProjectAndClickThem("BRIO-Test");
            selectedProjectSideView.waitOpenSelectedProjectSideView();
            sleep(1000);
            selectedProjectSideView.selectMenuItemDeleteProjectItem();
            deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
            deleteProjectDialog.clickOnDeleteButton();
        }
        assertAll(
                () -> assertEquals("Открыть проект", actTxt),
                () -> assertTrue(result),
                () -> assertTrue(anResult)
        );
    }

}
