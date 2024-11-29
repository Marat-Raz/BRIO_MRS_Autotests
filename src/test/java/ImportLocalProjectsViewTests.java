import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import io.qameta.allure.Links;
import mrselements.loggedmainpage.ImportLocalProjectsView;
import mrselements.loggedmainpage.LoggedMainPage;
import mrselements.loggedmainpage.SelectedProjectSideView;
import mrselements.loggedmainpage.selectedprojectsideview.DeleteProjectDialog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    String project = "ImportLocalProjectsViewTests";
    loggedMainPage.clickOnCreateProjectsFromFoldersButton();
    importLocalProjectsView.waitOpenImportLocalProjectsView();
    importLocalProjectsView.moveToElementAndClickOnProject(project);
    resultOne = importLocalProjectsView.projectIsChecked(project);
    importLocalProjectsView.clickOnCreateButton();
    loggedMainPage.waitOpenLoggedMainPage();
    sleep(1000);
    resultTwo = loggedMainPage.desiredProjectIsDisplayed(project);
    loggedMainPage.findProjectAndClickThem(project);
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
    loggedMainPage.waitOpenLoggedMainPage();
    loggedMainPage.clickOnCreateProjectsFromFoldersButton();
    int numberOfProjects;
    try {
      importLocalProjectsView.waitOpenImportLocalProjectsView();
      numberOfProjects = importLocalProjectsView.getListOfAvailableProjects();
    } finally {
      importLocalProjectsView.returnNameFolderDatabase();
    }
    importLocalProjectsView.clickOnCancelButton();
    assertEquals(0, numberOfProjects);
  }

}
