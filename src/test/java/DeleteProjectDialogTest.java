import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Muted;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import org.junit.jupiter.api.*;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteProjectDialogTest extends TestsStarter {
    static LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    static SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
    static DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
    static ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);

    boolean resultOne, resultTwo, oldValue, newValue;

    @BeforeAll
    public static void uploadProjects() throws InterruptedException {
        if (!loggedMainPage.desiredProjectIsDisplayed("For Autotests")) {
            loggedMainPage.clickOnCreateProjectsFromFoldersButton();
            importLocalProjectsView.waitOpenImportLocalProjectsView();
            importLocalProjectsView.moveToElementAndClickOnProject("For Autotests");
            importLocalProjectsView.clickOnCreateButton();
            loggedMainPage.waitOpenLoggedMainPage();
            sleep(1000);
        }
    }

    @AfterAll
    @DisplayName("Удалить проект оставив локальные файлы (чек бокс «Оставить локальные файлы» выбран)")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1460")
    public static void deleteProjects () throws InterruptedException {
        if (loggedMainPage.desiredProjectIsDisplayed("For Autotests")) {
            loggedMainPage.findProjectAndClickThem("For Autotests");
            selectedProjectSideView.waitOpenSelectedProjectSideView();
            sleep(1000);
            selectedProjectSideView.selectMenuItemDeleteProjectItem();
            deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
            deleteProjectDialog.clickOnDeleteButton();
        }
    }

    @BeforeEach
    public void clickOnProjectAndMenu() {
        loggedMainPage.findProjectAndClickThem("For Autotests");
        selectedProjectSideView.waitOpenSelectedProjectSideView();
        selectedProjectSideView.clickOnMenuItemButton();
        selectedProjectSideView.selectMenuItemDeleteProjectItem();
    }

    @AfterEach
    public void closeDeleteProjectDialog() {
        if (loggedMainPage.desiredProjectIsDisplayed("For Autotests")) {
            deleteProjectDialog.clickOnCancelButton();
            loggedMainPage.findProjectAndClickThem("For Autotests");
        }
    }

    @Test
    @DisplayName("Открыть окно удаления проекта")
    @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1452"),
                    @Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1457"),
                    @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1477")})
    public void createProjectFromFolderTest() {
        resultOne = deleteProjectDialog.deleteProjectDialogIsOpen();
        resultTwo = deleteProjectDialog.checkBoxLeaveLocalFilesIsChecked();
        assertTrue(resultOne);
    }

    @Test
    @DisplayName("Проверить чек бокс  «Оставить локальные файлы»")
    @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1475"),
                    @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1476")})
    public void checkBoxLeaveLocalFilesTest() {
        oldValue = deleteProjectDialog.checkBoxLeaveLocalFilesIsChecked();
        deleteProjectDialog.clickOnCheckBoxLeaveLocalFiles();
        newValue = deleteProjectDialog.checkBoxLeaveLocalFilesIsChecked();
        deleteProjectDialog.clickOnCheckBoxLeaveLocalFiles();
        assertEquals(oldValue, !newValue);
    }


    @Test
    @Muted
    @DisplayName("Открыть окно удаления активного(открытого) проекта")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1709")
    public void openDeleteProjectDialogAnActiveProjectTest() {
// todo реализовать тест после реализации открытия проекта и возврата
    }


}
