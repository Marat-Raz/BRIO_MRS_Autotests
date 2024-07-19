package mrs_elements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedMainPage {
    public static AppiumDriver driver;
    public static final By LOGGED_MAIN_PAGE = By.className("LoggedMainPageView");
    public static final By SELECTED_PROJECT_SIDE_VIEW = By.className("SelectedProjectSideView");
    public static final By NOT_SELECTED_PROJECT_SIDE_VIEW = By.xpath("//LoggedMainPageView/Border/" +
            "ContentPresenter/Grid/Decorator/Grid/AnimatedContentControl/Border/Grid/ContentPresenter/Decorator/Grid");
    public static final By ACCOUNT_LOGIN = By.xpath("//TextBlock[@Text='BrioCloud']");
    public static final By REFRESH_PROJECTS_LIST_BUTTON = By.xpath("//Button[@Text='Обновить список проектов']");
//private static final By LOGIN_INPUT = By.xpath("//TextBox[.//TextBlock[@Text='Логин']]")

    public LoggedMainPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public static void waitOpenLoggedMainPage() {
        (new WebDriverWait(driver, Duration.ofSeconds(1))).until(ExpectedConditions.visibilityOfElementLocated());
    }
    public boolean LoggedMainPageIsOpen() {
        waitOpenLoggedMainPage();
        return driver.findElement(LOGGED_MAIN_PAGE).isDisplayed();
    }
}
