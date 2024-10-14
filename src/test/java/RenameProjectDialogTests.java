import io.qameta.allure.Link;
import io.qameta.allure.Links;
import mrs_elements.loggedmainpage.LoggedMainPage;
import mrs_elements.loggedmainpage.SelectedProjectSideView;
import mrs_elements.loggedmainpage.selectedProjectSideView.RenameProjectDialog;
import mrs_elements.screenkeyboards.ScreenKeyboard;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenameProjectDialogTests extends TestsStarter{
    RenameProjectDialog renameProjectDialog = new RenameProjectDialog(driver);

    LoggedMainPage loggedMainPage = new LoggedMainPage(driver);
    ScreenKeyboard screenKeyboard;
    SelectedProjectSideView selectedProjectSideView = new SelectedProjectSideView(driver);

    boolean result;
    String actTxt;

    @BeforeEach
    public void clickOnProjectAndMenu() {
        loggedMainPage.findProjectAndClickThem("For Autotests");
        selectedProjectSideView.waitOpenSelectedProjectSideView();
        selectedProjectSideView.clickOnMenuItemButton();
        selectedProjectSideView.selectMenuItemRenameProjectItem();
    }

    @AfterEach
    public void closeDeleteProjectDialog() {
        renameProjectDialog.clickOnCancelButton();
        loggedMainPage.findProjectAndClickThem("For Autotests");
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
    public void renameProjectTest() {
        String newName = "newName";
        renameProjectDialog.clickOnInputBox();
        screenKeyboard = new ScreenKeyboard(driver);
        screenKeyboard.waitOpenScreenKeyboard();
        screenKeyboard.enterTextToScreenKeyboardInput(newName);
        screenKeyboard.clickHideKeyboardButton();
        renameProjectDialog.clickOnRenameButton();
        result = loggedMainPage.desiredProjectIsDisplayed(newName);
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
                () -> assertEquals("#Имя проекта не должно содержать символ \"" + prohibitedChar + "\"", actTxt)
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
