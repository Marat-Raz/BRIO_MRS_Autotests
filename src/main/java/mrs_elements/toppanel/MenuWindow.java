package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MenuWindow {
    public static AppiumDriver driver;
    private static final By SETTINGS_BUTTON = By.xpath("//OpenSettingsCommandView/Border/" +
            "ContentPresenter/Button/Grid/ContentPresenter/TextBlock");
    private static final By RETURN_TO_MAIN_PAGE_BUTTON = By.xpath("//ReturnToMainPageMenuActionView/" +
            "Border/ContentPresenter/Button/Grid/ContentPresenter/TextBlock");
    private static final By MINIMIZE_BUTTON = By.xpath("//MinimizeWindowActionView/Border/" +
            "ContentPresenter/Button/Grid/ContentPresenter/TextBlock");
    private static final By CLOSE_APPLICATION_BUTTON = By.xpath("//CloseAppActionView/Border/" +
            "ContentPresenter/Button/Grid/ContentPresenter/TextBlock");
    private static final By BRIO_MRS_VERSION_BUTTON = By.xpath("//MultipleClickButton/Border/" +
            "ContentPresenter/TextBlock");
    private static final By MENU_WINDOW = By.xpath("    //MenuPanelView/Grid/" +
            "ContentPresenter/Grid/ExpanderWithoutHeader/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/" +
            "AdornerLayer");
    private static final By BUTTON_X = By.xpath("//MainMenuView/Border/ContentPresenter/Grid/Grid/" +
            "Button/Grid/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");

    public MenuWindow(AppiumDriver driver) {
        this.driver = driver;
    }
    public boolean menuWindowIsOpen() {
        return driver.findElement(MENU_WINDOW).isDisplayed();
    }
        @Step("Нажимаем на кнопку «Настройки»")
    public static void clickOnSettingsButton() {
        driver.findElement(SETTINGS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Наглавную»")
    public static void clickOnReturnToMainPageButton() {
        driver.findElement(RETURN_TO_MAIN_PAGE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Свернуть окно»")
    public static void clickOnMinimizeButton() {
        driver.findElement(MINIMIZE_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Закрыть приложение»")
    public static void clickOnCloseApplicationButton() {
        driver.findElement(CLOSE_APPLICATION_BUTTON).click();
    }
    @Step("Нажимаем на надписи с версией приложения")
    public static void clickFiveOnBrioMrsVersionButton() {
        for (int i = 0; i < 5; i++){
            driver.findElement(BRIO_MRS_VERSION_BUTTON).click();
        }
    }
    @Step("Нажимаем на кнопку «X»")
    public static void clickOnXButton() {
        driver.findElement(CLOSE_APPLICATION_BUTTON).click();
    }
}
