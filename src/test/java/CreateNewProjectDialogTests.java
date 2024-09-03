import io.qameta.allure.Link;
import mrs_elements.loggedmainpage.CreateNewProjectDialog;
import mrs_elements.loggedmainpage.ImportLocalProjectsView;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateNewProjectDialogTests extends TestsStarter {
    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    ImportLocalProjectsView importLocalProjectsView = new ImportLocalProjectsView(driver);
    CreateNewProjectDialog createNewProjectDialog = new CreateNewProjectDialog(driver);
    ScreenKeyboard screenKeyboard;
    SelectedProjectSideView selectedProjectSideView;
    boolean result, anotherResult;
    String actTxt;

    @ParameterizedTest
    @DisplayName("Ввод запрещенных символов в поле ввода названия проекта")
    @ValueSource(strings = { "<", ">", "/", "\\", "|", "?", "*", "\""})
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
    @DisplayName("Создать проект с кнопкой «Создать новый»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-172")
    public void createProjectWithCreateNewButtonTest() {
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput("createProjectTest. Delete me");
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        loggedMainPage.waitOpenLoggedMainPage();
        result = loggedMainPage.findProject("createProjectTest. Delete me");
        // todo нужно удалить тестовый проект
        System.out.println(result);

    }

    @Test
    @DisplayName("Создать проект с уже существующим именем")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void createProjectWithAnExistingNameTest() {
        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput("duplicateNameTest. Delete me");
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();

        loggedMainPage.clickOnOpenOrCreateProjectButton();
        createNewProjectDialog.waitOpenCreateNewProjectDialog();
        createNewProjectDialog.clickOnTextBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput("duplicateNameTest. Delete me");
        screenKeyboard.clickHideKeyboardButton();
        createNewProjectDialog.clickOnCreateButton();
        result = createNewProjectDialog.errorMessageIsDisplayed();
        actTxt = createNewProjectDialog.getTextErrorMessage();
        createNewProjectDialog.clickOnCancelButton();
        loggedMainPage.findProjectAndClickThem("duplicateNameTest. Delete me");

        selectedProjectSideView.selectMenuItemDeleteProjectItem();
        assertAll(
                () -> assertTrue(result),
                () -> assertEquals("#Проект с заданным именем уже существует", actTxt)
        );


        // todo нужно удалить тестовый проект

        // todo заменить пользователя bricloud/123 на test/123

        System.out.println(result);

    }



}
