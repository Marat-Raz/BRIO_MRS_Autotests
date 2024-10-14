import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Muted;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteProjectDialogTest extends TestsStarter {
    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
    DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);

    boolean result, resultOne, resultTwo, oldValue, newValue;

    @BeforeEach
    public void clickOnProjectAndMenu() {
        loggedMainPage.findProjectAndClickThem("For Autotests");
        selectedProjectSideView.waitOpenSelectedProjectSideView();
        selectedProjectSideView.clickOnMenuItemButton();
        selectedProjectSideView.selectMenuItemDeleteProjectItem();
    }

    @AfterEach
    public void closeDeleteProjectDialog() {
        deleteProjectDialog.clickOnCancelButton();
        loggedMainPage.findProjectAndClickThem("For Autotests");
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
    @DisplayName("Удалить проект оставив локальные файлы (чек бокс «Оставить локальные файлы» выбран)")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1460")
    public void deleteProjectWithoutLocalFilesTest() throws InterruptedException {
        deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
        deleteProjectDialog.clickOnDeleteButton();
        sleep(1500);
        resultOne = loggedMainPage.desiredProjectIsDisplayed("For Autotests");
        resultTwo = deleteProjectDialog.checkingDeletingFolderFromDatabase("For Autotests");
        loggedMainPage.clickOnCreateProjectsFromFoldersButton();

        assertAll(
                () -> assertTrue(!resultOne),
                () -> assertTrue(resultTwo)
        );
    }

    @Test
    @Muted
    @DisplayName("Открыть окно удаления активного(открытого) проекта")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1709")
    public void openDeleteProjectDialogAnActiveProjectTest() {
// todo реализовать тест после реализации открытия проекта и возврата
    }


}
