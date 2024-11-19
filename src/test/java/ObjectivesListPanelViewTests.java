import io.qameta.allure.Link;
import mrselements.loggedmainpage.ImportLocalProjectsView;
import mrselements.loggedmainpage.LoggedMainPage;
import mrselements.loggedmainpage.SelectedProjectSideView;
import mrselements.loggedmainpage.selectedprojectsideview.DeleteProjectDialog;
import mrselements.scene.bimviewerview.toolbar.ObjectivesListPanelView;
import mrselements.screenkeyboards.ScreenKeyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ObjectivesListPanelViewTests extends TestsStarter {

  ObjectivesListPanelView objectivesListPanelView = new ObjectivesListPanelView(driver);
  LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
  SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
  ScreenKeyboard screenKeyboard = new ScreenKeyboard(driver);
  ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
  DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
  String[] objectives, objectivesBeforeSort, objectivesAfterSort, objectivesForEqual;
  boolean result, oldValue, newValue;


  // todo изменить описание
  @Test
  @DisplayName("Сортировка «Сначала новые» или «Сначала старые»")
  @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1710")
  public void createProjectFromFolderTest() {
    objectivesListPanelView.objectivesListView.statusOfToggleButtonSortByTime();

  }
}
