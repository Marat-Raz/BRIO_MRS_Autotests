import io.qameta.allure.Link;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.loggedmainpage.selectedProjectSideView.DeleteProjectDialog;
import mrs_elements.scene.bim_viewer_view.toolbar.ObjectivesListPanelView;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ObjectivesListPanelViewTests extends TestsStarter {
    ObjectivesListPanelView objectivesListPanelView = new ObjectivesListPanelView(driver);
    static LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    static SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
    ScreenKeyboard screenKeyboard = new ScreenKeyboard(driver);
    static ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
    static DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
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
