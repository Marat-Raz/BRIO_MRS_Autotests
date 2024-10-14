package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedMainPage {
    public static AppiumDriver driver;
    public static final By LOGGED_MAIN_PAGE = By.className("LoggedMainPageView");
    public static final By NOT_SELECTED_PROJECT_SIDE_VIEW =
            By.xpath("//Button[.//TextBlock[@Text='Обновить список проектов']]/parent::*");
    public static final By ACCOUNT_NAME = By.className("usernameText");
    public static final By REFRESH_PROJECTS_LIST_BUTTON = By.name("reloadProjectsBtn");
    public static final By CREATE_PROJECTS_FROM_FOLDERS_BUTTON = By.name("importLocalProjectsBtn");
    public static final By INPUT_FIELD_SEARCH = By.name("searchProjectTextBox");
    public static final By PROJECTS =
            By.xpath("//*[starts-with(@Text,'Проекты')]");
    public static final By OPEN_OR_CREATE_PROJECT_BUTTON = By.name("openOrCreateProjectBtn");
    public static final By PROJECT_FOR_AUTO_TESTS =
            By.xpath("//ListBoxItem[.//TextBlock[@Text='For Autotests']]");
    public static final By PROJECT_IMPORTLOCALPROJECTSVIEWTESTS =
            By.xpath("//ListBoxItem[.//TextBlock[@Text='ImportLocalProjectsViewTests']]");
    MethodsForElements methodsForElements;

    public LoggedMainPage(AppiumDriver driver) {
        methodsForElements = new MethodsForElements(driver);
        this.driver = driver;
    }

    public static void waitOpenLoggedMainPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGGED_MAIN_PAGE));
    }

    public boolean loggedMainPageIsOpen() {
        waitOpenLoggedMainPage();
        return driver.findElement(LOGGED_MAIN_PAGE).isDisplayed();
    }

    public static void waitOpenNotSelectedProjectSideView() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGGED_MAIN_PAGE));
    }

    public boolean notSelectedProjectSideViewIsOpen() {
        waitOpenLoggedMainPage();
        return driver.findElement(LOGGED_MAIN_PAGE).isDisplayed();
    }

    @Step("Нажать на кнопку «Обновить список проектов»")
    public void clickOnRefreshOfProjectsListButton() {
        waitOpenLoggedMainPage();
        driver.findElement(REFRESH_PROJECTS_LIST_BUTTON).click();
    }

    @Step("Нажать на кнопку «Создать проекты из папок»")
    public void clickOnCreateProjectsFromFoldersButton() {
        waitOpenLoggedMainPage();
        driver.findElement(CREATE_PROJECTS_FROM_FOLDERS_BUTTON).click();
    }

    @Step("Нажать на поле ввода «Поиск»")
    public void clickOnInputFieldSearch() {
        waitOpenLoggedMainPage();
        driver.findElement(INPUT_FIELD_SEARCH).click();
    }

    @Step("Получить количество проектов из заголовка «Проекты»")
    public int getNumberOfProjectsFromHeaderProjects() {
        String txt = (driver.findElement(PROJECTS).getText()).substring(7);
        int numberOfProjects = txt == "" ? 0 : Integer.parseInt(txt.trim());
        return numberOfProjects;
    }

    @Step("Нажать на кнопку «Создать новый/Открыть проект»")
    public void clickOnOpenOrCreateProjectButton() {
        waitOpenLoggedMainPage();
        driver.findElement(OPEN_OR_CREATE_PROJECT_BUTTON).click();
    }

    @Step("Получить текст кнопки «Создать новый/Открыть проект»")
    public String getTextOpenOrCreateProjectButton() {
        return (driver.findElement(OPEN_OR_CREATE_PROJECT_BUTTON).getText()).substring(0,14);
    }

    @Step ("Искомый проект виден в списке проектов")
    public boolean desiredProjectIsDisplayed(String project) {
        return driver.findElement(By.xpath("//ListBoxItem[.//TextBlock[@Text='" + project + "']]")).isDisplayed();
    }

    @Step("Нажать на проект в списке проектов")
    public void findProjectAndClickThem(String project) {
        waitOpenLoggedMainPage();
        driver.findElement(By.xpath("//ListBoxItem[.//TextBlock[@Text='" + project + "']]")).click();
    }

}
