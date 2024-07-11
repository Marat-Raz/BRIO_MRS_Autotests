package mrs_elements.toppanel.menu.settings;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProfileWindow {
    public static AppiumDriver driver;
    private static final By  GO_BACK_PROFILE_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/Button");
    private static final By MINUS_BUTTON = By.xpath("//NumericUpDown/Border/Grid/RepeatButton[1]/Grid/Border");
    private static final By PLUS_BUTTON = By.xpath("//NumericUpDown/Border/Grid/RepeatButton[2]/Grid/Border");
    private static final By COUNTER_AS_INPUT = By.xpath("//NumericUpDown/Border/Grid/TextBox");
    private static final By COUNTER_AS_BUTTON = By.xpath("//NumericUpDown/Border/Grid");

    private static final By LOG_OUT_ACCOUNT_BUTTON = By.xpath("//LogoutMenuActionView/Border/" +
            "ContentPresenter/Button/Grid/Border");
    public ProfileWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public void waitOpenProfileWindow() {
        driver.findElement(GO_BACK_PROFILE_BUTTON).isDisplayed();
    }
    public boolean ProfileWindowIsOpen() {
        return driver.findElement(GO_BACK_PROFILE_BUTTON).isDisplayed();
    }
    @Step("Нажимаем на кнопку «<Профиль»")
    public static void clickOnGoBackButton() {
        driver.findElement(GO_BACK_PROFILE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «+»")
    public static void clickOnPlusButton() {
        driver.findElement(PLUS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «-»")
    public static void clickOnMinusButton() {
        driver.findElement(MINUS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Выйти из акканта»")
    public void clickOnLogOutAccountButton() {
        driver.findElement(LOG_OUT_ACCOUNT_BUTTON).click();
    }
    @Step("Получаем значения из поля «Время на устранение задачи по умолчанию, дней»")
    public String getTextFromCounter() {
        return driver.findElement(COUNTER_AS_INPUT).getText();
    }
    @Step("Нажимаем на поле «Время на устранение задачи по умолчанию, дней»")
    public void clickOnCounter() {
        driver.findElement(COUNTER_AS_BUTTON).click();
    }

}
