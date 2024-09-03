package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteProjectDialog {
    public static AppiumDriver driver;
    public static final By DELETE_PROJECT_DIALOG =
            By.xpath("//CheckBox[.//TextBlock[@Text='Оставить локальные файлы']]/parent::*");
    public static final By CHECK_BOX_LEAVE_LOCAL_FILES =
            By.xpath("//CheckBox[.//TextBlock[@Text='Оставить локальные файлы']]");
    public static final By DELETE_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Удалить']]");
    public static final By CANCEL_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Отмена']]");

    public DeleteProjectDialog(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenDeleteProjectDialog() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(DELETE_PROJECT_DIALOG));
    }

    public boolean deleteProjectDialogIsOpen() {
        waitOpenDeleteProjectDialog();
        return driver.findElement(DELETE_PROJECT_DIALOG).isDisplayed();
    }

    @Step("Нажать на поле ввода названия проекта")
    public void clickOnCheckBoxLeaveLocalFiles() {
        waitOpenDeleteProjectDialog();
        driver.findElement(CHECK_BOX_LEAVE_LOCAL_FILES).click();
    }

    @Step("Нажать на кнопку «Создать»")
    public void clickOnDeleteButton() {
        waitOpenDeleteProjectDialog();
        driver.findElement(DELETE_BUTTON).click();
    }

    @Step("Нажать на кнопку «Отмена»")
    public void clickOnCancelButton() {
        waitOpenDeleteProjectDialog();
        driver.findElement(CANCEL_BUTTON).click();
    }

}
