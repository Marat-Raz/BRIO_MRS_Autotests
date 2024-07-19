package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mrs_elements.toppanel.menu.settings.InterfaceWindowLocators.*;

public class InterfaceWindow {
    public static AppiumDriver driver;


    public InterfaceWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public static void waitOpenInterfaceWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_INTERFACE_BUTTON));
    }
    public boolean interfaceWindowIsOpen() {
        waitOpenInterfaceWindow();
        return driver.findElement(GO_BACK_INTERFACE_BUTTON).isDisplayed();
    }
    @Step("Нажимаем на кнопку «<Интерфейс»")
    public static void clickOnGoBackButton() {
        waitOpenInterfaceWindow();
        driver.findElement(GO_BACK_INTERFACE_BUTTON).click();
    }
    //Todo Нужно дождаться доработки кода получения структуры ui от Данила потом продолжить работу с выпадающими списками: Язык и Сторона Интерфейса
    @Step("Выбор элемента выпадающего списка")
    public void selectText(String variableTextForSelect) {
        WebElement selectElement = driver.findElement(LANGUAGE_TOGGLE_BUTTON);
        Select select = new Select(selectElement);
        select.selectByVisibleText(variableTextForSelect);
    }
    @Step("Нажимаем на кнопку «<Интерфейс»")
    public boolean showViewCubeToggleButtonIsEnabled() {
        waitOpenInterfaceWindow();
       return driver.findElement(SHOW_VIEW_CUBE_TOGGLE_BUTTON).isSelected();
    }
    @Step("Нажимаем на кнопку «<Интерфейс»")
    public static void clickOnShowViewCubeToggleButton() {
        waitOpenInterfaceWindow();
        driver.findElement(SHOW_VIEW_CUBE_TOGGLE_BUTTON).click();
    }

}
