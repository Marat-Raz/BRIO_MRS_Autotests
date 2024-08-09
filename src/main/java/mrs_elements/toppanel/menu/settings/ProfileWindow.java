package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileWindow {
    public static AppiumDriver driver;
    private static final By GO_BACK_PROFILE_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Профиль' or @Text='Profile']]");
    private static final By MINUS_BUTTON = By.xpath("//NumericUpDown/Border/Grid/RepeatButton[1]/Grid/Border");
    private static final By PLUS_BUTTON = By.xpath("//NumericUpDown/Border/Grid/RepeatButton[2]/Grid/Border");
    private static final By COUNTER_AS_INPUT = By.xpath("//NumericUpDown/Border/Grid/TextBox");
    private static final By COUNTER_AS_BUTTON = By.xpath("//NumericUpDown/Border/Grid");
    private static final By LOG_OUT_ACCOUNT_BUTTON = By.xpath("//Button[.//TextBlock[@Text='Выйти из аккаунта' or @Text='Logout']]");

    public ProfileWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenProfileWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.visibilityOfElementLocated(GO_BACK_PROFILE_BUTTON));
    }

    public boolean profileWindowIsOpen() {
        waitOpenProfileWindow();
        return driver.findElement(GO_BACK_PROFILE_BUTTON).isDisplayed();
    }

    @Step("Нажимаем на кнопку «<Профиль»")
    public static void clickOnGoBackButton() {
        waitOpenProfileWindow();
        driver.findElement(GO_BACK_PROFILE_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «+»")
    public static void clickOnPlusButton() {
        waitOpenProfileWindow();
        driver.findElement(PLUS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «-»")
    public static void clickOnMinusButton() {
        waitOpenProfileWindow();
        driver.findElement(MINUS_BUTTON).click();
    }

    @Step("Нажимаем на кнопку «Выйти из акканта»")
    public void clickOnLogOutAccountButton() {
        waitOpenProfileWindow();
        driver.findElement(LOG_OUT_ACCOUNT_BUTTON).click();
    }

    @Step("Получаем значения из поля «Время на устранение задачи по умолчанию, дней»")
    public String getTextFromCounter() {
        waitOpenProfileWindow();
        return driver.findElement(COUNTER_AS_INPUT).getText();
    }

    @Step("Нажимаем на поле «Время на устранение задачи по умолчанию, дней»")
    public void clickOnCounter() {
        waitOpenProfileWindow();
        driver.findElement(COUNTER_AS_BUTTON).click();
    }
// TODO Нужно добавить ввод в поле «Время на устранение задачи по умолчанию, дней» значений с цифровой клавиатуры
}
