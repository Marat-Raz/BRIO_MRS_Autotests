import io.qameta.allure.Link;
import io.qameta.allure.Muted;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationTests extends TestsStarter {
    MenuWindow menuWindow;
    TopPanel topPanel;
    @Test
    //@Muted
    @DisplayName("Нажать на «Свернуть окно»")
    @Link(name = "Ссылка на тест-кейс отсутствует", url = "")
    public void clickOnMinimizeButtonTest() throws InterruptedException {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        menuWindow.waitOpenMenuWindow();
        Thread.sleep(1000);
        MenuWindowTest.menuWindow.clickOnMinimizeButton();
        Thread.sleep(1000);
    }
}
