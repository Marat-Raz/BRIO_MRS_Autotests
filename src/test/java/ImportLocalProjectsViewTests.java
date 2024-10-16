import io.qameta.allure.Link;
import io.qameta.allure.Links;
import mrs_elements.loggedmainpage.*;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class ImportLocalProjectsViewTests extends TestsStarter {
    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
    SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
    DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);

    boolean resultOne, resultTwo;

    @Test
    @DisplayName("Создать проект из папки")
    @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1463"),
                    @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1702")})
    public void createProjectFromFolderTest() throws InterruptedException {
        loggedMainPage.clickOnCreateProjectsFromFoldersButton();
        importLocalProjectsView.waitOpenImportLocalProjectsView();
        importLocalProjectsView.clickOnProjectImportLocalProjectsViewTests();
        resultOne = importLocalProjectsView.projectImportLocalProjectsViewTestsIsChecked();
        importLocalProjectsView.clickOnCreateButton();
        loggedMainPage.waitOpenLoggedMainPage();
        sleep(1000);
        resultTwo = loggedMainPage.desiredProjectIsDisplayed("ImportLocalProjectsViewTests");
        loggedMainPage.findProjectAndClickThem("ImportLocalProjectsViewTests");
        selectedProjectSideView.waitOpenSelectedProjectSideView();
        sleep(1000);
        selectedProjectSideView.selectMenuItemDeleteProjectItem();
        deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
        deleteProjectDialog.clickOnDeleteButton();
        assertAll(
                () -> assertTrue(resultOne),
                () -> assertTrue(resultTwo)
        );
    }

    @Test
    @DisplayName("Нажать кнопку «Выбрать/Сбросить всё»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1465")
    public void clickOnSelectOrResetAllCheckboxTest() {
        loggedMainPage.clickOnCreateProjectsFromFoldersButton();
        importLocalProjectsView.waitOpenImportLocalProjectsView();
        importLocalProjectsView.clickOnSelectOrResetAllCheckbox();
        resultOne = importLocalProjectsView.selectOrResetAllCheckboxIsChecked();
        importLocalProjectsView.clickOnSelectOrResetAllCheckbox();
        resultTwo = importLocalProjectsView.selectOrResetAllCheckboxIsChecked();
        importLocalProjectsView.clickOnCancelButton();
        assertEquals(resultOne, !resultTwo);
    }

    @Test
    @DisplayName("Создание проектов из папок когда БД пуста и Database тоже пуста")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1569")
    public void folderDatabaseMissingTest() {
        importLocalProjectsView.renameFolderDatabase();
        loggedMainPage.clickOnCreateProjectsFromFoldersButton();
        importLocalProjectsView.waitOpenImportLocalProjectsView();
        int numberOfProjects = importLocalProjectsView.getListOfAvailableProjects();
        importLocalProjectsView.returnNameFolderDatabase();
        importLocalProjectsView.clickOnCancelButton();
        assertEquals(0, numberOfProjects);
    }

}
