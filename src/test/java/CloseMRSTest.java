import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.toppanel.CloseMRS;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CloseMRSTest extends TestsStarter {
    private CloseMRSTest closeMRSTest;
    @Test
    @DisplayName("Закрыть приложение")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-746")
    public void clickOnDetailsButtonTest() throws InterruptedException {
        CloseMRS.clickOnMainMenu();
        Thread.sleep(300);
        CloseMRS.clickOnCloseApplicationButton();
        Thread.sleep(300);
        CloseMRS.clickOnYesButton();
        Thread.sleep(300);
        System.out.println("Ok");
        //assertTrue(accountManagementPage.buttonDetailsIsRevealed(), "Ошибка!");
    }
}
