import static generaldatatests.GeneralDataTests.projectsForTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Muted;
import mrselements.loggedmainpage.LoggedMainPage;
import mrselements.loggedmainpage.SelectedProjectSideView;
import mrselements.loggedmainpage.selectedprojectsideview.DeleteProjectDialog;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteProjectDialogTest extends TestsStarter {

  LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
  SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);

  DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  String project = projectsForTests.get(0);

  boolean resultOne, resultTwo, oldValue, newValue;

  @BeforeEach
  public void uploadProjects() {
    loggedMainPage.findProjectAndClickThem(project);
    selectedProjectSideView.waitOpenSelectedProjectSideView();
    selectedProjectSideView.clickOnMenuItemButton();
    selectedProjectSideView.selectMenuItemDeleteProjectItem();
  }

  @AfterEach
  @DisplayName("Удалить проект оставив локальные файлы (чек бокс «Оставить локальные файлы» выбран)")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1460")
  public void deleteProjects() {
    deleteProjectDialog.clickOnCancelButton();
    loggedMainPage.findProjectAndClickThem(project);
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
