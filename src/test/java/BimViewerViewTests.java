import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import mrs_elements.explorer_view.ExplorerView;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoadModelsOpenedLastTimeDialog;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.scene.MrsCvView;
import mrs_elements.scene.bim_viewer_view.BimViewerView;
import mrs_elements.scene.bim_viewer_view.toolbar.FloorMapListView;
import mrs_elements.scene.bim_viewer_view.toolbar.MarkersListView;
import mrs_elements.scene.bim_viewer_view.toolbar.ObjectivesListPanelView;
import mrs_elements.scene.bim_viewer_view.toolbar.ToolsSidePanelView;
import mrs_elements.scene.bim_viewer_view.toolbar.TopicsPanelView;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.InterfaceWindow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BimViewerViewTests extends TestsStarter {

  static LoggedMainPage loggedMainPage;
  static ImportLocalProjectsView importLocalProjectsView;
  static LoadModelsOpenedLastTimeDialog loadModelsOpenedLastTimeDialog;
  BimViewerView bimViewerView = new BimViewerView(driver);
  MrsCvView mrsCvView = new MrsCvView(driver);
  MarkersListView markersListView = new MarkersListView(driver);

  static String project = "For Autotests";
  boolean result, resultOne, resultTwo;

  @BeforeAll
  public static void uploadProject() throws InterruptedException {
    loggedMainPage = new LoggedMainPage(driver);
    loggedMainPage.waitOpenLoggedMainPage();
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
    loggedMainPage.clickOnOpenOrCreateProjectButton();
    loadModelsOpenedLastTimeDialog = new LoadModelsOpenedLastTimeDialog(driver);
    if (loadModelsOpenedLastTimeDialog.loadModelsOpenedLastTimeDialogIsOpen()) {
      loadModelsOpenedLastTimeDialog.clickOnYesButton();
    }
  }

  @Test
  @DisplayName("Переключение между режимами камеры и модели")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1951")
  public void switchBetweenCameraAndModelModesTest() {
    bimViewerView.clickMrsCameraButton();
    result = mrsCvView.mrsCvViewIsOpen();
    resultOne = mrsCvView.mixedRealityModeSwitchViewIsVisible();
    mrsCvView.clickOnOpenBimViewerButton();
    resultTwo = bimViewerView.bimViewerViewIsOpen();
    assertTrue(result);
    assertTrue(resultOne);
    assertTrue(resultTwo);
  }

  @Test
  @DisplayName("Проверка кнопки «Метки»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1530")
  public void checkingLabelsButtonTest() throws InterruptedException {
    bimViewerView.clickOnMarkersBtn();
    result = markersListView.markersListViewIsOpen();
    markersListView.clickOnXBtn();
    sleep(1000);
    resultOne = markersListView.markersListViewIsOpen();
    bimViewerView.clickOnMarkersBtn();
    sleep(1000);
    bimViewerView.clickOnMarkersBtn();
    resultTwo = markersListView.markersListViewIsOpen();
    sleep(1000);
    assertAll(
        () -> assertTrue(result),
        () -> assertFalse(resultOne),
        () -> assertFalse(resultTwo)
    );
  }

  @Test
  @DisplayName("Проверка кнопки «Модели»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1803")
  public void checkingModelsButtonTest() throws InterruptedException {
    bimViewerView.clickOnModelsBtn();
    ExplorerView explorerView = new ExplorerView(driver);
    result = explorerView.explorerViewIsOpen();
    explorerView.clickOnBackButton();
    sleep(1000);
    assertTrue(result);
  }

  @Test
  @DisplayName("Проверка кнопки «Панель карт этажей»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1804")
  public void checkingFloorMapPanelButtonTest() throws InterruptedException {
    if (!bimViewerView.floorMapPanelBtnIsVisible()) {
      TopPanel topPanel = new TopPanel(driver);
      topPanel.clickOnMainMenuButton();
      MenuWindow menuWindow = new MenuWindow(driver);
      menuWindow.clickOnSettingsButton();
      SettingsWindow settingsWindow = new SettingsWindow(driver);
      settingsWindow.clickOnInterfaceButton();
      InterfaceWindow interfaceWindow = new InterfaceWindow(driver);
      interfaceWindow.clickOnShowMapPaneButtonToggleButton();
      interfaceWindow.clickOnXButton();
    }
    bimViewerView.clickOnFloorMapPanelBtn();
    FloorMapListView floorMapListView = new FloorMapListView(driver);
    result = floorMapListView.floorMapListViewIsOpen();
    floorMapListView.clickOnXBtn();
    sleep(1000);
    resultOne = floorMapListView.floorMapListViewIsOpen();
    bimViewerView.clickOnFloorMapPanelBtn();
    sleep(1000);
    bimViewerView.clickOnFloorMapPanelBtn();
    resultTwo = floorMapListView.floorMapListViewIsOpen();
    sleep(1000);
    assertAll(
        () -> assertTrue(result),
        () -> assertFalse(resultOne),
        () -> assertFalse(resultTwo)
    );
  }

  @Test
  @DisplayName("Проверка кнопки «Инструменты»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1805")
  public void checkingToolsButtonTest() throws InterruptedException {
    bimViewerView.clickOnToolsBtn();
    ToolsSidePanelView toolsSidePanelView = new ToolsSidePanelView(driver);
    result = toolsSidePanelView.toolsSidePanelViewIsOpen();
    toolsSidePanelView.clickOnXBtn();
    sleep(1000);
    resultOne = toolsSidePanelView.toolsSidePanelViewIsOpen();
    bimViewerView.clickOnToolsBtn();
    sleep(1000);
    bimViewerView.clickOnToolsBtn();
    resultTwo = toolsSidePanelView.toolsSidePanelViewIsOpen();
    sleep(1000);
    assertAll(
        () -> assertTrue(result),
        () -> assertFalse(resultOne),
        () -> assertFalse(resultTwo)
    );
  }

  @Test
  @DisplayName("Проверка кнопки «Задачи»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1806")
  public void checkingObjectivesButtonTest() throws InterruptedException {
    bimViewerView.clickOnObjectivesBtn();
    ObjectivesListPanelView objectivesListPanelView = new ObjectivesListPanelView(driver);
    result = objectivesListPanelView.objectivesListPanelViewIsOpen();
    objectivesListPanelView.clickOnXBtn();
    sleep(1000);
    resultOne = objectivesListPanelView.objectivesListPanelViewIsOpen();
    bimViewerView.clickOnObjectivesBtn();
    sleep(1000);
    bimViewerView.clickOnObjectivesBtn();
    resultTwo = objectivesListPanelView.objectivesListPanelViewIsOpen();
    sleep(1000);
    assertAll(
        () -> assertTrue(result),
        () -> assertFalse(resultOne),
        () -> assertFalse(resultTwo)
    );
  }

  @Test
  @DisplayName("Проверка кнопки «BCF»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1807")
  public void checkingBCFButtonTest() throws InterruptedException {
    bimViewerView.clickOnBCFBtn();
    TopicsPanelView topicsPanelView = new TopicsPanelView(driver);
    result = topicsPanelView.topicsPanelViewIsOpen();
    topicsPanelView.clickOnXBtn();
    sleep(1000);
    resultOne = topicsPanelView.topicsPanelViewIsOpen();
    bimViewerView.clickOnBCFBtn();
    sleep(1000);
    bimViewerView.clickOnBCFBtn();
    resultTwo = topicsPanelView.topicsPanelViewIsOpen();
    sleep(1000);
    assertAll(
        () -> assertTrue(result),
        () -> assertFalse(resultOne),
        () -> assertFalse(resultTwo)
    );
  }
}
