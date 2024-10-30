package mrs_elements.scene.bim_viewer_view.toolbar;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.loggedmainpage.selectedProjectSideView.ObjectivesListView;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ObjectivesListPanelView {
    public static AppiumDriver driver;
    public ObjectivesListView objectivesListView;
    public static final By OBJECTIVES_LIST_PANEL_VIEW = By.className("ObjectivesListPanelView");
    public static final By X_BTN = By.name("closeObjectivesPanelBtn");
    public static final By SHOW_OBJ_LABELS_BTN = By.name("showObjLabelsBtn");
    public static final By FILTERS_BTN = By.name("openObjFiltersBtn");
    public static final By CREATE_OBJECTIVE_BTN = By.name("createObjectiveBtn");
    public static final By REPORTS_BTN = By.xpath("//Button[.//TextBlock[@Text='Отчёты']]");
    public static final By DELETE_BTN = By.xpath("//Button[.//TextBlock[@Text='Удалить']]");

    public ObjectivesListPanelView(AppiumDriver driver) {
        objectivesListView = new ObjectivesListView(driver);
        this.driver = driver;
    }

    public static void waitOpenObjectivesListPanelView() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(OBJECTIVES_LIST_PANEL_VIEW));
    }

    public boolean objectivesListPanelViewIsOpen() {
        try {
            return driver.findElement(OBJECTIVES_LIST_PANEL_VIEW).isDisplayed();
        } catch (TimeoutException | NoSuchElementException ex)  {
            return false;
        }
    }

    @Step("Нажимаем на кнопку «Х»")
    public void clickOnXBtn() {
        driver.findElement(X_BTN).click();
    }

    @Step("Нажимаем на кнопку «Метки задач»")
    public void clickOnObjLabelsBtn() {
        driver.findElement(SHOW_OBJ_LABELS_BTN).click();
    }

    @Step("Нажимаем на кнопку «Фильтры»")
    public void clickOnObjFiltersBtn() {
        driver.findElement(FILTERS_BTN).click();
    }

    @Step("Нажимаем на кнопку «Создать задачу»")
    public void clickOnCreateObjectiveBtn() {
        driver.findElement(CREATE_OBJECTIVE_BTN).click();
    }

    @Step("Нажимаем на кнопку «Отчёты»")
    public void clickOnReportsBtn() {
        driver.findElement(REPORTS_BTN).click();
    }

    @Step("Нажимаем на кнопку «Отчёты»")
    public void clickOnDeleteBtn() {
        driver.findElement(DELETE_BTN).click();
    }

}


