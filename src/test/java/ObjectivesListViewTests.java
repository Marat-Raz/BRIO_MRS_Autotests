import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Link;
import io.qameta.allure.Links;
import java.util.Arrays;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.loggedmainpage.selectedProjectSideView.MainPageObjectiveEditorView;
import mrs_elements.loggedmainpage.selectedProjectSideView.ObjectivesListView;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObjectivesListViewTests extends TestsStarter {

  static LoggedMainPage loggedMainPage;
  ObjectivesListView objectivesListView = new ObjectivesListView(driver);
  static SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
  ScreenKeyboard screenKeyboard = new ScreenKeyboard(driver);
  static ImportLocalProjectsView importLocalProjectsView;
  static DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  String[] objectives, objectivesBeforeSort, objectivesAfterSort, objectivesForEqual;
  boolean result, oldValue, newValue;

// todo нужно вначале тестов создать задачи в проекте

  @BeforeAll
  public static void uploadProjects() throws InterruptedException {
    loggedMainPage = new LoggedMainPage(driver);
    if (!loggedMainPage.desiredProjectIsDisplayed("For Autotests")) {
      loggedMainPage.clickOnCreateProjectsFromFoldersButton();
      importLocalProjectsView = new ImportLocalProjectsView(driver);
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
  public static void deleteProjects() throws InterruptedException {
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
  public void clickOnProject() throws InterruptedException {
    loggedMainPage.findProjectAndClickThem("For Autotests");
    selectedProjectSideView.waitOpenSelectedProjectSideView();
    sleep(500);
  }

  @AfterEach
  public void clickOnProjectAfterTests() {
    loggedMainPage.waitOpenLoggedMainPage();
    loggedMainPage.findProjectAndClickThem("For Autotests");
  }

  @Test
  @DisplayName("Сортировка «Сначала новые» или «Сначала старые»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1710")
  public void createProjectFromFolderTest() throws InterruptedException {
    oldValue = objectivesListView.statusOfToggleButtonSortByTime();
    objectives = objectivesListView.getListOfObjectives();
    ArrayUtils.reverse(objectives);
    objectivesListView.clickOnToggleButtonSortByTime();
    sleep(500);
    newValue = objectivesListView.statusOfToggleButtonSortByTime();
    objectivesAfterSort = objectivesListView.getListOfObjectives();
    assertArrayEquals(objectives, objectivesAfterSort);
    assertEquals(oldValue, !newValue);
  }

  @Test
  @DisplayName("Способ сортировки задач «Дата создания»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1711")
  public void sortObjectivesByCreationDateTest() throws InterruptedException {
    objectives = objectivesListView.getListOfObjectives();
    objectivesListView.selectCreationDate();
    sleep(500);
    objectivesBeforeSort = objectivesListView.getListOfObjectives();
    ArrayUtils.reverse(objectivesBeforeSort);
    objectivesListView.clickOnToggleButtonSortByTime();
    sleep(500);
    objectivesAfterSort = objectivesListView.getListOfObjectives();
    objectivesForEqual = Arrays.copyOf(objectivesBeforeSort, objectivesBeforeSort.length);
    Arrays.sort(objectives);
    Arrays.sort(objectivesForEqual);
    assertArrayEquals(objectives, objectivesForEqual);
    assertArrayEquals(objectivesBeforeSort, objectivesAfterSort);
  }

  @Test
  @DisplayName("Способ сортировки задач «Дата изменения»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1712")
  public void sortObjectivesByDateModifiedTest() throws InterruptedException {
    objectives = objectivesListView.getListOfObjectives();
    objectivesListView.selectDateModified();
    sleep(500);
    objectivesBeforeSort = objectivesListView.getListOfObjectives();
    ArrayUtils.reverse(objectivesBeforeSort);
    objectivesListView.clickOnToggleButtonSortByTime();
    sleep(500);
    objectivesAfterSort = objectivesListView.getListOfObjectives();
    objectivesForEqual = Arrays.copyOf(objectivesBeforeSort, objectivesBeforeSort.length);
    Arrays.sort(objectives);
    Arrays.sort(objectivesForEqual);
    assertArrayEquals(objectives, objectivesForEqual);
    assertArrayEquals(objectivesBeforeSort, objectivesAfterSort);
  }

  @Test
  @DisplayName("Способ сортировки задач «Дата изменения»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1713")
  public void sortObjectivesByCompletionDateTest() throws InterruptedException {
    objectives = objectivesListView.getListOfObjectives();
    objectivesListView.selectCompletionDate();
    sleep(500);
    objectivesBeforeSort = objectivesListView.getListOfObjectives();
    ArrayUtils.reverse(objectivesBeforeSort);
    objectivesListView.clickOnToggleButtonSortByTime();
    sleep(500);
    objectivesAfterSort = objectivesListView.getListOfObjectives();
    objectivesForEqual = Arrays.copyOf(objectivesBeforeSort, objectivesBeforeSort.length);
    Arrays.sort(objectives);
    Arrays.sort(objectivesForEqual);
    assertArrayEquals(objectives, objectivesForEqual);
    assertArrayEquals(objectivesBeforeSort, objectivesAfterSort);
  }

  @Test
  @DisplayName("При нажатии на поле ввода «Поиск» открывается встроенная клавиатура")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1714")
  public void clickOnSearchFieldTest() {
    objectivesListView.clickOnSearchField();
    screenKeyboard = new ScreenKeyboard(driver);
    result = screenKeyboard.screenKeyboardIsOpen();
    assertTrue(result);
  }

  @Test
  @DisplayName("Выполнить валидный поиск задачи")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1715")
  public void performValidObjectivesSearchTest() throws InterruptedException {
    objectives = objectivesListView.getListOfObjectives();
    objectivesListView.clickOnSearchField();
    String searchText = objectives[1];
    screenKeyboard.enterTextToScreenKeyboardInput(searchText);
    screenKeyboard.clickHideKeyboardButton();
    sleep(500);
    objectivesForEqual = objectivesListView.getListOfObjectives();
    String actText = objectivesForEqual[0];
    assertEquals(searchText, actText);
  }

  @Test
  @DisplayName("Выполнить невалидный поиск задачи")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1715")
  public void performNonValidObjectivesSearchTest() throws InterruptedException {
    objectives = objectivesListView.getListOfObjectives();
    objectivesListView.clickOnSearchField();
    screenKeyboard.enterTextToScreenKeyboardInput("Апчхи");
    screenKeyboard.clickHideKeyboardButton();
    sleep(500);
    result = objectivesListView.txtNoObjectivesFoundIsVisible();
    assertTrue(result);
  }

  @Test
  @DisplayName("Счетчик задач рядом с названием проекта показывает количество задач")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1717")
  public void performAnInvalidObjectivesSearchTest() {
    int number = objectivesListView.getNumberOfObjectivesFromHeaderOfProjects();
    objectives = objectivesListView.getListOfObjectives();
    assertEquals(objectives.length, number);
  }

  @Test
  @DisplayName("Нажать на задаче открывает окно редактирования задачи")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1860")
  public void clickOnObjectivesTest() {
    objectivesListView.clickOnFirstListBoxItem();
    MainPageObjectiveEditorView mainPageObjectiveEditorView = new MainPageObjectiveEditorView(
        driver);
    result = mainPageObjectiveEditorView.MainPageObjectiveEditorViewIsOpen();
    mainPageObjectiveEditorView.clickOnXBtn();
    assertTrue(result);
  }

  @Test
  @DisplayName("Выделить задачу")
  @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-2038"),
      @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-2039")})
  public void clickAndHoldOnObjectivesTest() throws InterruptedException {
    objectivesListView.clickAndHoldOnFirstListBoxItem();
    sleep(1000);
    result = objectivesListView.expandedLabelIsVisible();
    objectivesListView.clickOnSelectAllBtn();
    sleep(500);
    int numberOfSelectedObjectives = objectivesListView.getNumberOfSelectedObjectives();
    int numberOfSelectedObjectivesFromText = objectivesListView.getNumberOfSelectedObjectivesFromText();
    objectivesListView.clickOnDeselectAllBtn();
    int numberOfSelectedObjectivesAfterDeselect = objectivesListView.getNumberOfSelectedObjectivesFromText();
    assertAll(
        () -> assertTrue(result),
        () -> assertEquals(numberOfSelectedObjectives, numberOfSelectedObjectivesFromText),
        () -> assertEquals(0, numberOfSelectedObjectivesAfterDeselect)
    );
  }


}
