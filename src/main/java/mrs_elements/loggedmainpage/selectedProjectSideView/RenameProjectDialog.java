package mrs_elements.loggedmainpage.selectedProjectSideView;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class RenameProjectDialog {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;
    public static final By RENAME_PROJECT_DIALOG =
            By.xpath("//Button[.//TextBlock[@Text='Переименовать']]/parent::*");
    public static final By INPUT_BOX = By.name("inputBox");
    public static final By RENAME_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Переименовать']]");
    public static final By CANCEL_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Отмена']]");
    public static final By ERROR_MESSAGE =
            By.xpath("//TextBlock[@Text='Введите название проекта']/following-sibling::TextBlock");

    public RenameProjectDialog(AppiumDriver driver) {
        this.driver = driver;
        methodsForElements = new MethodsForElements(driver);
    }

    public static void waitOpenRenameProjectDialog() {
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOfElementLocated(RENAME_PROJECT_DIALOG));
    }

    public boolean RenameProjectDialogIsOpen() {
        waitOpenRenameProjectDialog();
        return driver.findElement(RENAME_PROJECT_DIALOG).isDisplayed();
    }

    @Step("Нажать на поле ввода")
    public void clickOnInputBox() {
        waitOpenRenameProjectDialog();
        driver.findElement(INPUT_BOX).click();
    }

    @Step("Нажать на кнопку «Переименовать»")
    public void clickOnRenameButton() {
        waitOpenRenameProjectDialog();
        driver.findElement(RENAME_BUTTON).click();
    }

    @Step("Нажать на кнопку «Отмена»")
    public void clickOnCancelButton() {
        waitOpenRenameProjectDialog();
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Появилось сообщение об ошибке?")
    public boolean errorMessageIsDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Step("Получить текст сообщения об ошибке")
    public String getTextErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}

