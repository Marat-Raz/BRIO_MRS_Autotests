package mrs_elements.login;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginWindow {
    public static AppiumDriver driver;
    private static final By LOGIN_WINDOW = By.xpath("//TextBlock[@Text='Войти в систему']/parent::*");
    private static final By LOGIN_WINDOW_HEADER = By.name("loginPageTitle");
    private static final By LOGIN_INPUT = By.name("loginBox");
    private static final By PASSWORD_INPUT = By.name("passBox");
    private static final By CONTINUE_BUTTON = By.name("loginBtn");


    public LoginWindow(AppiumDriver driver) {
        this.driver = driver;
    }

    public static void waitOpenLoginWindow() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_WINDOW_HEADER));
    }

    public boolean loginWindowIsOpen() {
        waitOpenLoginWindow();
        return driver.findElement(LOGIN_WINDOW).isDisplayed();
    }

    @Step("Нажимаем на кнопку «Продолжить»")
    public static void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Нажимаем на поле ввода «Логин»")
    public static void clickLoginInput() {
        driver.findElement(LOGIN_INPUT).click();
    }

    @Step("Нажимаем на поле ввода «Пароль»")
    public static void clickPasswordInput() {
        driver.findElement(PASSWORD_INPUT).click();
    }

    @Step("Ввод текста в поле ввода «Логин»")
    public static void enterTextInLoginInput(String text) {
        driver.findElement(LOGIN_INPUT).sendKeys(text);
    }

    @Step("Ввод текста в поле ввода «Пароль»")
    public static void enterTextInPasswordInput(String text) {
        driver.findElement(LOGIN_INPUT).sendKeys(text);
    }

    @Step("Получить текст заголовка окна авторизации")
    public String getTitleTextOfAuthorizationWindow() {
        return driver.findElement(LOGIN_WINDOW_HEADER).getText();
    }
}
