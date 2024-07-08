import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mrs_elements.toppanel.CloseMRS;
import mrs_elements.toppanel.TopPanel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseMRSTest extends TestsStarter {
    CloseMRS closeMRS;
    TopPanel topPanel;
    @Test
    @DisplayName("Закрыть приложение")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-746")
    public void clickOnЬMenuButtonTest() {
        topPanel = new TopPanel(driver);
        topPanel.clickOnMainMenu();
        closeMRS = new CloseMRS(driver);
        CloseMRS.clickOnCloseApplicationButton();
        CloseMRS.clickOnNoButton();
        //Thread.sleep(1000);
        System.out.println("Ok");
    }
}
