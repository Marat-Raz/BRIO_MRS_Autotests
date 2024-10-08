import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Step;
import mrs_elements.loggedmainpage.*;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CreateNewProjectDialogTests extends TestsStarter {
    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
    CreateNewProjectDialog createNewProjectDialog = new CreateNewProjectDialog(driver);
    DeleteProjectDialog deleteProjectDialog = new DeleteProjectDialog(driver);
    ScreenKeyboard screenKeyboard;
    SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);
    ;
    boolean result, anotherResult;
    String actTxt;

    @Step("Удалить проект")
    public void deleteProject(String project) {
        loggedMainPage.findProjectAndClickThem(project);
        selectedProjectSideView.selectMenuItemDeleteProjectItem();
        if (deleteProjectDialog.CheckBoxLeaveLocalFilesIsChecked()) {
            deleteProjectDialog.clickOnCheckBoxLeaveLocalFiles();
        }
        deleteProjectDialog.clickOnDeleteButton();
    }

    @ParameterizedTest
    @DisplayName("Ввод запрещенных символов в поле ввода названия проекта")
    @ValueSource(strings = {"<", ">", "/", "\\", "|", "?", "*", "\"", ":"})
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void enterProhibitedCharactersInProjectNameFieldTest(String prohibitedChar) {
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput(prohibitedChar);
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        result = createNewProjectDialog.errorMessageIsDisplayed();
        actTxt = createNewProjectDialog.getTextErrorMessage();
        createNewProjectDialog.clickOnCancelButton();
        assertAll(
                () -> assertTrue(result),
                () -> assertEquals("#Имя проекта не должно содержать символ \"" + prohibitedChar + "\"", actTxt)
        );
    }

    @Test
    @DisplayName("Ввод 151 символов в поле ввода названия проекта")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void enterLongLineInProjectNameField() {
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        String longTxt = RandomStringUtils.randomAlphabetic(151);
        screenKeyboard.enterTextToScreenKeyboardInput(longTxt);
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        result = createNewProjectDialog.errorMessageIsDisplayed();
        actTxt = createNewProjectDialog.getTextErrorMessage();
        createNewProjectDialog.clickOnCancelButton();
        assertAll(
                () -> assertTrue(result),
                () -> assertEquals("#Название проекта слишком длинное", actTxt)
        );
    }

    @Test
    @DisplayName("Создать проект с кнопкой «Создать новый», а также проверить счетчик проектов на увеличение и уменьшение")
    @Links(value = {@Link(name = "Ссылка на тест-кейс №1", url = "https://app.qase.io/case/MRS-1355"),
                    @Link(name = "Ссылка на тест-кейс №2", url = "https://app.qase.io/case/MRS-1469"),
                    @Link(name = "Ссылка на тест-кейс №3", url = "https://app.qase.io/case/MRS-1470")})
    public void createProjectWithCreateNewButtonTest() {
        String newProject = "createProjectTest. Delete me";
        int numberOfProjects = loggedMainPage.getNumberOfProjectsFromHeaderProjects();
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput(newProject);
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        loggedMainPage.waitOpenLoggedMainPage();
        int numberOfProjectsPlus1 = loggedMainPage.getNumberOfProjectsFromHeaderProjects();
        result = loggedMainPage.desiredProjectIsDisplayed(newProject);
        deleteProject(newProject);
        int numberOfProjectsMinus1 = loggedMainPage.getNumberOfProjectsFromHeaderProjects();
        assertAll(
                () -> assertTrue(result),
                () -> assertEquals(numberOfProjects + 1, numberOfProjectsPlus1),
                () -> assertEquals(numberOfProjectsPlus1 - 1, numberOfProjectsMinus1)
        );
    }

    @Test
    @DisplayName("Создать проект с уже существующим именем")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-1705")
    public void createProjectWithAnExistingNameTest() {
        String duplicateName = "duplicateNameTest. Delete me";
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput(duplicateName);
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();

        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput(duplicateName);
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        result = createNewProjectDialog.errorMessageIsDisplayed();
        actTxt = createNewProjectDialog.getTextErrorMessage();
        createNewProjectDialog.clickOnCancelButton();

        deleteProject(duplicateName);
        assertAll(
                () -> assertTrue(result),
                () -> assertEquals("#Проект с заданным именем уже существует", actTxt)
        );

    }


}
