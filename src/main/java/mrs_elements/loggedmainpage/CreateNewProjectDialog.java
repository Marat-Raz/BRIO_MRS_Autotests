package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateNewProjectDialog {
    public static AppiumDriver driver;
    public static final By CREATE_NEW_PROJECT_DIALOG =
            By.xpath("//TextBlock[@Text='Введите название проекта']/parent::*");
    public static final By TEXT_BOX = By.name("inputBox");
    public static final By CREATE_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Создать']]");
    public static final By CANCEL_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Отмена']]");
    public static final By ERROR_MESSAGE =
            By.xpath("//TextBlock[@Text='Введите название проекта']/following-sibling::TextBlock");

    public CreateNewProjectDialog(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenCreateNewProjectDialog() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_NEW_PROJECT_DIALOG));
    }

    public boolean createNewProjectDialogIsOpen() {
        waitOpenCreateNewProjectDialog();
        return driver.findElement(CREATE_NEW_PROJECT_DIALOG).isDisplayed();
    }

    @Step("Нажать на поле ввода названия проекта")
    public void clickOnTextBox() {
        waitOpenCreateNewProjectDialog();
        driver.findElement(TEXT_BOX).click();
    }

    @Step("Нажать на кнопку «Создать»")
    public void clickOnCreateButton() {
        waitOpenCreateNewProjectDialog();
        driver.findElement(CREATE_BUTTON).click();
    }

    @Step("Нажать на кнопку «Отмена»")
    public void clickOnCancelButton() {
        waitOpenCreateNewProjectDialog();
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
