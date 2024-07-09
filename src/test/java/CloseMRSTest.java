import io.qameta.allure.Link;
import mrs_elements.toppanel.MenuWindow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mrs_elements.toppanel.CloseMRS;
import mrs_elements.toppanel.TopPanel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseMRSTest extends TestsStarter {
    MenuWindow menuWindow;
    CloseMRS closeMRS;
    TopPanel topPanel;

    @Test
    @DisplayName("Закрыть приложение")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-746")
    public void clickOnMenuButtonTest1() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenuButton();
        menuWindow = new MenuWindow(driver);
        MenuWindow.clickOnCloseApplicationButton();
        closeMRS = new CloseMRS(driver);
        CloseMRS.clickOnNoButton();
        System.out.println("Ok");
    }

}
