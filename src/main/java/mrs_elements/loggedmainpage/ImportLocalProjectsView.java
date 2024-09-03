package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportLocalProjectsView {
    public static AppiumDriver driver;
    //public static final By IMPORT_LOCAL_PROJECTS_VIEW = By.className("ImportLocalProjectsView");
    public static final By IMPORT_LOCAL_PROJECTS_VIEW = By.xpath("//TextBlock[@Text='Выберите папки для создания проектов']");
    public static final By SELECT_OR_RESET_ALL_CHECKBOX =
            By.xpath("//CheckBox[.//TextBlock[@Text='Выбрать/Сбросить всё']]");
    public static final By PROJECT_FOR_AUTO_TESTS_CHECKBOX =
            By.xpath("//CheckBox[.//TextBlock[@Text='беларусь']]");
    public static final By INCREASE_BUTTON_SCROLL = By.name("IncreaseButton"); // LineDownButton
    public static final By CREATE_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Создать']]");
    public static final By CANCEL_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Отмена']]");
    MethodsForElements methodsForElements;

    public ImportLocalProjectsView(AppiumDriver driver) {
        methodsForElements = new MethodsForElements(driver);
        this.driver = driver;
    }

    public static void waitOpenImportLocalProjectsView() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(IMPORT_LOCAL_PROJECTS_VIEW));
    }

    public boolean importLocalProjectsViewIsOpen() {
        waitOpenImportLocalProjectsView();
        return driver.findElement(IMPORT_LOCAL_PROJECTS_VIEW).isDisplayed();
    }

    @Step("Нажимаем на чекбокс «Выбрать/Сбросить все»")
    public void clickOnSelectOrResetAllCheckbox() {
        waitOpenImportLocalProjectsView();
        driver.findElement(SELECT_OR_RESET_ALL_CHECKBOX).click();
    }

    @Step("Считываем состояние чекбокса «Выбрать/Сбросить все»")
    public boolean selectOrResetAllCheckboxIsChecked() {
        return methodsForElements.switchEnabled(SELECT_OR_RESET_ALL_CHECKBOX);
    }

    @Step("Считываем состояние чекбокса выбранного проекта «For AutoTests»")
    public boolean projectForAutoTestsIsChecked() {
        //waitOpenImportLocalProjectsView();
        return methodsForElements.switchEnabled(PROJECT_FOR_AUTO_TESTS_CHECKBOX);
    }

    @Step("Нажимаем на чекбокс выбранного проекта «For AutoTests»")
    public void clickOnProjectForAutoTests() {
        waitOpenImportLocalProjectsView();
        moveToElement(PROJECT_FOR_AUTO_TESTS_CHECKBOX);
        //(new WebDriverWait(driver, Duration.ofSeconds(1)))
         //       .until(ExpectedConditions.elementToBeClickable(PROJECT_FOR_AUTO_TESTS_CHECKBOX));
        //driver.findElement(PROJECT_FOR_AUTO_TESTS_CHECKBOX).click();
        driver.findElement(PROJECT_FOR_AUTO_TESTS_CHECKBOX).click();

        // fixme по факту нажатия не происходит, когда нужно выбрать элемент в конце списка
        //  или сделать прокрутку на другую страницу
    }

    @Step("Нажимаем вниз в полосе прокрутки")
    public void clickOnIncreaseButtonScroll() {
        waitOpenImportLocalProjectsView();
        driver.findElement(INCREASE_BUTTON_SCROLL).click();
    }

    public void moveToElement(By by) {
        waitOpenImportLocalProjectsView();
        while (!driver.findElement(by).isDisplayed());
        {
            clickOnIncreaseButtonScroll();
        }

    }

    @Step("Нажать на кнопку «Создать»")
    public void clickOnCreateButton() {
        waitOpenImportLocalProjectsView();
        driver.findElement(CREATE_BUTTON).click();
    }

    @Step("Считываем состояние кнопки «Создать»")
    public boolean createButtonIsActive() {
        String attr = driver.findElement(CREATE_BUTTON).getAttribute("IsEnabled");
        boolean IsEnabled = Boolean.parseBoolean(attr);
        return IsEnabled;
    }

    @Step("Нажать на кнопку «Отмена»")
    public void clickOnCancelButton() {
        waitOpenImportLocalProjectsView();
        driver.findElement(CANCEL_BUTTON).click();
    }


}
