import static generaldatatests.GeneralDataTests.projectsForTests;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Muted;
import mrselements.loggedmainpage.ImportLocalProjectsView;
import mrselements.loggedmainpage.LoggedMainPage;
import mrselements.loggedmainpage.SelectedProjectSideView;
import mrselements.loggedmainpage.selectedprojectsideview.DeleteProjectDialog;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteProjectDialogTest extends TestsStarter {

  static LoggedMainPage loggedMainPage;
  static SelectedProjectSideView selectedProjectSideView;
  static DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  static ImportLocalProjectsView importLocalProjectsView;
  static String project = projectsForTests.get(0);

  boolean resultOne, resultTwo, oldValue, newValue;

  @BeforeAll
  public static void uploadProjects() throws InterruptedException {
    loggedMainPage = new LoggedMainPage(driver);
    if (!loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.clickOnCreateProjectsFromFoldersButton();
      importLocalProjectsView = new ImportLocalProjectsView(driver);
      importLocalProjectsView.waitOpenImportLocalProjectsView();
      importLocalProjectsView.moveToElementAndClickOnProject(project);
      importLocalProjectsView.clickOnCreateButton();
      loggedMainPage.waitOpenLoggedMainPage();
      sleep(1000);
    }
    loggedMainPage.findProjectAndClickThem(project);
    selectedProjectSideView = new SelectedProjectSideView(driver);
    selectedProjectSideView.waitOpenSelectedProjectSideView();
    selectedProjectSideView.clickOnMenuItemButton();
    selectedProjectSideView.selectMenuItemDeleteProjectItem();
  }

  @AfterAll
  @DisplayName("Удалить проект оставив локальные файлы (чек бокс «Оставить локальные файлы» выбран)")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1460")
  public static void deleteProjects() throws InterruptedException {
    deleteProjectDialog.clickOnCancelButton();
    loggedMainPage.findProjectAndClickThem(project);
    if (loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.findProjectAndClickThem(project);
      selectedProjectSideView = new SelectedProjectSideView(driver);
      sleep(500);
      selectedProjectSideView.selectMenuItemDeleteProjectItem();
      deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
      deleteProjectDialog.clickOnDeleteButton();
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
