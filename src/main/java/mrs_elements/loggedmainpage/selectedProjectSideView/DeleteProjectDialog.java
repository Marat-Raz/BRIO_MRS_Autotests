package mrs_elements.loggedmainpage.selectedProjectSideView;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class DeleteProjectDialog {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;
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
        methodsForElements = new MethodsForElements(driver);
    }

    public static void waitOpenDeleteProjectDialog() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(DELETE_PROJECT_DIALOG));
    }

    public boolean deleteProjectDialogIsOpen() {
        waitOpenDeleteProjectDialog();
        return driver.findElement(DELETE_PROJECT_DIALOG).isDisplayed();
    }

    @Step("Считываем состояние чекбокса «Оставить локальные файлы»")
    public boolean checkBoxLeaveLocalFilesIsChecked() {
        return methodsForElements.switchEnabled(CHECK_BOX_LEAVE_LOCAL_FILES);
    }

    @Step("Нажать на чек бокс «Оставить локальные файлы»")
    public void clickOnCheckBoxLeaveLocalFiles() {
        waitOpenDeleteProjectDialog();
        driver.findElement(CHECK_BOX_LEAVE_LOCAL_FILES).click();
    }

    @Step("Выбрать чек бокс «Оставить локальные файлы»")
    public void selectCheckBoxLeaveLocalFiles() {
        if (!checkBoxLeaveLocalFilesIsChecked())
        driver.findElement(CHECK_BOX_LEAVE_LOCAL_FILES).click();
    }

    @Step("Выбрать чек бокс «Оставить локальные файлы»")
    public void deselectCheckBoxLeaveLocalFiles() {
        if (checkBoxLeaveLocalFilesIsChecked())
        driver.findElement(CHECK_BOX_LEAVE_LOCAL_FILES).click();
    }

    @Step("Нажать на кнопку «Удалить»")
    public void clickOnDeleteButton() {
        waitOpenDeleteProjectDialog();
        driver.findElement(DELETE_BUTTON).click();
    }

    @Step("Нажать на кнопку «Отмена»")
    public void clickOnCancelButton() {
        waitOpenDeleteProjectDialog();
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Проверка удаления папки из Database")
    public boolean checkingDeletingFolderFromDatabase(String projectName) {
        File findFile = new File("C:\\Users\\User\\Documents\\Brio MRS\\Database\\" + projectName);
        return (findFile.exists());
    }



}
