import static generaldatatests.GeneralDataTests.projectsForTests;
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
import mrselements.loggedmainpage.selectedprojectsideview.RenameProjectDialog;
import mrselements.screenkeyboards.ScreenKeyboard;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RenameProjectDialogTests extends TestsStarter {

  LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
  ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
  RenameProjectDialog renameProjectDialog = new RenameProjectDialog(driver);
  ScreenKeyboard screenKeyboard;
  DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);

  boolean result;
  String actTxt;
  String project = projectsForTests.get(0);

  @BeforeAll // todo заменить BeforeAll
  public void uploadProjects() throws InterruptedException {
    if (!loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.clickOnCreateProjectsFromFoldersButton();
      importLocalProjectsView.waitOpenImportLocalProjectsView();
      importLocalProjectsView.moveToElementAndClickOnProject(project);
      importLocalProjectsView.clickOnCreateButton();
      loggedMainPage.waitOpenLoggedMainPage();
      sleep(1000);
    }
  }

  @AfterAll
  @DisplayName("Удалить проект оставив локальные файлы (чек бокс «Оставить локальные файлы» выбран)")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1460")
  public void deleteProjects() throws InterruptedException {
    if (loggedMainPage.desiredProjectIsDisplayed(project)) {
      loggedMainPage.findProjectAndClickThem(project);
      selectedProjectSideView.waitOpenSelectedProjectSideView();
      sleep(1000);
      selectedProjectSideView.selectMenuItemDeleteProjectItem();
      deleteProjectDialog.selectCheckBoxLeaveLocalFiles();
      deleteProjectDialog.clickOnDeleteButton();
    }
  }

  @BeforeEach
  public void clickOnProjectAndMenu() {
    loggedMainPage.findProjectAndClickThem(project);
    selectedProjectSideView.waitOpenSelectedProjectSideView();
    selectedProjectSideView.clickOnMenuItemButton();
    selectedProjectSideView.selectMenuItemRenameProjectItem();
  }

  @AfterEach
  public void closeDeleteProjectDialog() {
    if (renameProjectDialog.RenameProjectDialogIsOpen()) {
      renameProjectDialog.clickOnCancelButton();
    }
    loggedMainPage.findProjectAndClickThem(project);
  }

  @Test
  @DisplayName("Открыть диалог переименования, но не переименовывать проект")
  @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1454"),
      @Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1455"),
      @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1706")})
  public void createProjectWithAnExistingNameTest() {
    // todo изменить тест после изменения поведения при сохранении старого имени
    renameProjectDialog.clickOnRenameButton();
    result = renameProjectDialog.errorMessageIsDisplayed();
    actTxt = renameProjectDialog.getTextErrorMessage();
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals("#Проект с заданным именем уже существует", actTxt)
    );
  }

  @Test
  @DisplayName("Переименовать проект")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1612")
  public void renameProjectTest() throws InterruptedException {
    String newName = "newName";
    renameProjectDialog.clickOnInputBox();
    screenKeyboard = new ScreenKeyboard(driver);
    screenKeyboard.waitOpenScreenKeyboard();
    screenKeyboard.enterTextToScreenKeyboardInput(newName);
    screenKeyboard.clickHideKeyboardButton();
    renameProjectDialog.clickOnRenameButton();
    sleep(3000);
    result = loggedMainPage.desiredProjectIsDisplayed(newName);

    loggedMainPage.findProjectAndClickThem(newName);
    selectedProjectSideView.waitOpenSelectedProjectSideView();
    selectedProjectSideView.clickOnMenuItemButton();
    selectedProjectSideView.selectMenuItemRenameProjectItem();
    renameProjectDialog.clickOnInputBox();
    screenKeyboard = new ScreenKeyboard(driver);
    screenKeyboard.waitOpenScreenKeyboard();
    screenKeyboard.enterTextToScreenKeyboardInput(project);
    screenKeyboard.clickHideKeyboardButton();
    renameProjectDialog.clickOnRenameButton();
    sleep(3000);
    clickOnProjectAndMenu();

    assertTrue(result);
  }

  @ParameterizedTest
  @DisplayName("Ввод запрещенных символов в поле ввода названия проекта")
  @ValueSource(strings = {"<", ">", "/", "\\", "|", "?", "*", "\"", ":"})
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1707")
  public void enterProhibitedCharactersInProjectNameFieldTest(String prohibitedChar) {
    renameProjectDialog.clickOnInputBox();
    screenKeyboard = new ScreenKeyboard(driver);
    screenKeyboard.waitOpenScreenKeyboard();
    screenKeyboard.enterTextToScreenKeyboardInput(prohibitedChar);
    screenKeyboard.clickHideKeyboardButton();
    renameProjectDialog.clickOnRenameButton();
    result = renameProjectDialog.errorMessageIsDisplayed();
    actTxt = renameProjectDialog.getTextErrorMessage();
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals("#Имя проекта не должно содержать символ \"" + prohibitedChar + "\"",
            actTxt)
    );
  }

  @Test
  @DisplayName("Ввод 151 символов в поле ввода названия проекта")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1708")
  public void enterLongLineInProjectNameFieldTest() {
    renameProjectDialog.clickOnInputBox();
    screenKeyboard = new ScreenKeyboard(driver);
    screenKeyboard.waitOpenScreenKeyboard();
    String longTxt = RandomStringUtils.randomAlphabetic(151);
    screenKeyboard.enterTextToScreenKeyboardInput(longTxt);
    screenKeyboard.clickHideKeyboardButton();
    renameProjectDialog.clickOnRenameButton();
    result = renameProjectDialog.errorMessageIsDisplayed();
    actTxt = renameProjectDialog.getTextErrorMessage();
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals("#Название проекта слишком длинное", actTxt)
    );
  }

}
