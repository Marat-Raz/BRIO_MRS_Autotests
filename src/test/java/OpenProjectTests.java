import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Step;
import mrs_elements.explorer_view.ExplorerView;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoadModelsOpenedLastTimeDialog;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.scene.bim_viewer_view.BimViewerView;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OpenProjectTests extends TestsStarter {

  LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
  LoadModelsOpenedLastTimeDialog loadModelsOpenedLastTimeDialog = new LoadModelsOpenedLastTimeDialog(
      driver);
  ExplorerView explorerView = new ExplorerView(driver);
  BimViewerView bimViewerView = new BimViewerView(driver);
  TopPanel topPanel = new TopPanel(driver);
  MenuWindow menuWindow = new MenuWindow(driver);
  SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
  DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);

  boolean result, resultOne, resultTwo;
  String actTxt;

  @Step("Загрузить проект для теста")
  public void uploadProject(String project) throws InterruptedException {
    if (!loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.clickOnCreateProjectsFromFoldersButton();
      importLocalProjectsView.waitOpenImportLocalProjectsView();
      importLocalProjectsView.moveToElementAndClickOnProject(project);
      importLocalProjectsView.clickOnCreateButton();
      loggedMainPage.waitOpenLoggedMainPage();
      sleep(1000);
    }
    loggedMainPage.findProjectAndClickThem(project);
    loggedMainPage.clickOnOpenOrCreateProjectButton();
  }

  @Step("Удалить проект после прохождения теста")
  public void deleteProjects(String project) throws InterruptedException {
    if (loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.findProjectAndClickThem(project);
      selectedProjectSideView.waitOpenSelectedProjectSideView();
      sleep(1000);
      selectedProjectSideView.selectMenuItemDeleteProjectItem();
      deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
      deleteProjectDialog.clickOnDeleteButton();
      sleep(1000);
    }
  }

  @Step("Вернутся в главное меню")
  public void returnToMainMenu() {
    topPanel.clickOnMainMenuButton();
    menuWindow.clickOnReturnToMainPageButton();
    loggedMainPage.waitOpenLoggedMainPage();
  }

  @Test
  @DisplayName("Не загружать модели с прошлого сеанса \n" +
      "Проверка выделения открытого проекта \n")
  @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1336"),
      @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1445"),
      @Link(name = "Ссылка на тест-кейс №3", url = "https://app.qase.io/case/MRS-1446"),
      @Link(name = "Ссылка на тест-кейс №4", url = "https://app.qase.io/case/MRS-1450")})
  public void doNotLoadModelsFromPreviousSessionTest() throws InterruptedException {
    String project = "For Autotests";
    uploadProject(project);
    sleep(1000);
    resultOne = loadModelsOpenedLastTimeDialog.loadModelsOpenedLastTimeDialogIsOpen();
    loadModelsOpenedLastTimeDialog.clickOnNoButton();
    resultTwo = explorerView.explorerViewIsOpen();
    explorerView.clickOnBackButton();
    returnToMainMenu();
    String background = loggedMainPage.getBorderBackgroundOfProject(project);
    String data = loggedMainPage.getDataOfProject(project);
    deleteProjects(project);
    assertAll(
        () -> assertTrue(resultOne),
        () -> assertTrue(resultTwo),
        () -> assertEquals("#FFF5F5F5", background),
        () -> assertTrue(!data.isEmpty())
    );
  }

  @Test
  @DisplayName("Загрузить модели с прошлого сеанса")
  @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1448"),
      @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1450"),
      @Link(name = "Ссылка на тест-кейс №3", url = "https://app.qase.io/case/MRS-1449")})
  public void downloadModelsFromLastSessionTest() throws InterruptedException {
    String project = "Офис Гладилова 38А (Казань)";
    uploadProject(project);
    if (loadModelsOpenedLastTimeDialog.loadModelsOpenedLastTimeDialogIsOpen()) {
      loadModelsOpenedLastTimeDialog.clickOnYesButton();
    }
    resultOne = bimViewerView.expanderWithoutHeaderIsOpen();
    resultTwo = bimViewerView.bimViewerViewIsOpen();
    returnToMainMenu();
    actTxt = loggedMainPage.getModelNameFromProject(project);
    deleteProjects(project);
    assertAll(
        () -> assertTrue(resultOne),
        () -> assertNotEquals("нет использованных моделей", actTxt),
        () -> assertTrue(resultTwo)
    );
  }

  @Test
  @DisplayName("Повторное открытие проекта")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1719")
  public void reopenProjectTest() throws InterruptedException {
    String project = "BRIO-Test";
    uploadProject(project);
    if (loadModelsOpenedLastTimeDialog.loadModelsOpenedLastTimeDialogIsOpen()) {
      loadModelsOpenedLastTimeDialog.clickOnYesButton();
    }
    bimViewerView.waitOpenBimViewerView();
    returnToMainMenu();
    loggedMainPage.findProjectAndClickThem(project);
    loggedMainPage.clickOnOpenOrCreateProjectButton();
    result = bimViewerView.bimViewerViewIsOpen();
    returnToMainMenu();
    deleteProjects(project);
    assertTrue(result);
  }
}
