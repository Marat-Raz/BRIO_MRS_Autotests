package mrs_elements.toppanel;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TopPanel {
    public static AppiumDriver driver;
    public static final By MENU_BUTTON = By.xpath("//OpenMenuActionView/Border/ContentPresenter/" +
            "Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By SYNCHRONIZATION_BUTTON = By.xpath("//ConnectionIndicatorView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By NOTIFICATIONS_BUTTON = By.xpath("//NotificationPanelOpenActionView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AXES_BUTTON = By.xpath("//ToggleGridLabelsCommandView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By EXPLORER_BUTTON = By.xpath("//OpenExplorerContextActionView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By HIERARCHY_BUTTON = By.xpath("//ToggleHierarchyCommandView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[1]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By MR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[2]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AMR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[3]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public TopPanel(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку «Синхронизация»")
    public static void clickOnSynchronizationButton() {
        driver.findElement(SYNCHRONIZATION_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Уведомления»")
    public static void clickOnNotificationsButton() {
        driver.findElement(NOTIFICATIONS_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Оси»")
    public static void clickOnAxesButton() {
        driver.findElement(AXES_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Проводник»")
    public static void clickOnExplorerButton() {
        driver.findElement(EXPLORER_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Уровни»")
    public static void clickOnHierarchyButton() {
        driver.findElement(HIERARCHY_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «Меню»")
    public static void clickOnMainMenuButton() {
        driver.findElement(MENU_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «AR»")
    public static void clickOnAR() {
        driver.findElement(AR_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «MR»")
    public static void clickOnMR() {
        driver.findElement(MR_BUTTON).click();
    }
    @Step("Нажимаем на кнопку «AMR»")
    public static void clickOnAMR() {
        driver.findElement(AMR_BUTTON).click();
    }

}
