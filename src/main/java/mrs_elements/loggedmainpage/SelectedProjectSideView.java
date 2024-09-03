package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectedProjectSideView {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;
    public static final By SELECTED_PROJECT_SIDE_VIEW = By.className("SelectedProjectSideView");
    public static final By MENU_ITEM = By.className("MenuItem");
    public static final By MENU_ITEM_RENAME_PROJECT_ITEM = By.name("renameProjectItem");
    public static final By MENU_ITEM_DELETE_PROJECT_ITEM = By.name("deleteProjectItem");

    public SelectedProjectSideView(AppiumDriver driver) {
        methodsForElements = new MethodsForElements(driver);
        this.driver = driver;
    }

    public static void waitOpenSelectedProjectSideView() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(SELECTED_PROJECT_SIDE_VIEW));
    }

    public boolean selectedProjectSideViewIsOpen() {
        waitOpenSelectedProjectSideView();
        return driver.findElement(SELECTED_PROJECT_SIDE_VIEW).isDisplayed();
    }

    @Step("Нажать на кнопку «Создать»")
    public void clickOnMenuItemButton() {
        waitOpenSelectedProjectSideView();
        driver.findElement(MENU_ITEM).click();
    }

    @Step("Выбор элемента «Удалить проект» выпадающего списка «Меню выбранного проекта»")
    public void selectMenuItemDeleteProjectItem() {
        methodsForElements.clickingOnListAndSelectListItem(MENU_ITEM, MENU_ITEM_DELETE_PROJECT_ITEM);
    }


}
