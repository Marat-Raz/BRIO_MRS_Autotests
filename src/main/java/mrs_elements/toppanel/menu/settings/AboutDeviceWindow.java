package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutDeviceWindow {
    public static AppiumDriver driver;

    public AboutDeviceWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static final By ABOUT_DEVICE_WINDOW = By.xpath("//DeviceInformationView");
    public static final By ABOUT_DEVICE_GO_BACK = By.xpath("//Button[.//TextBlock[@Text='Об устройстве']]");
    public static final By SERIAL_NUMBER_TEXT = By.xpath("//DeviceInformationView/Border/ContentPresenter/Grid/StackPanel[1]/TextBlock[1]");
    public static final By DATE_OF_MANUFACTURE_TEXT = By.xpath("//DeviceInformationView/Border/ContentPresenter/Grid/StackPanel[1]/TextBlock[1]");

//DeviceInformationView/Border/ContentPresenter/Grid/StackPanel[1]/TextBlock[1]

    public static void waitOpenAboutDeviceWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).
                until(ExpectedConditions.visibilityOfElementLocated(ABOUT_DEVICE_WINDOW));
    }

    public boolean aboutDeviceWindowIsOpen() {
        waitOpenAboutDeviceWindow();
        return driver.findElement(ABOUT_DEVICE_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Об устройстве»")
    public static void clickOnGoBackButton() {
        waitOpenAboutDeviceWindow();
        driver.findElement(ABOUT_DEVICE_GO_BACK).click();
    }

    @Step("Считываем текст серийного номера")
    public String readSerialNumberText() {
        return driver.findElement(SERIAL_NUMBER_TEXT).getText();
    }

    @Step("Считываем текст даты изготовления")
    public String readDateOfManufactureText() {
        return driver.findElement(DATE_OF_MANUFACTURE_TEXT).getText();
    }


}
