import base.RunCase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.*;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestsStarter {
    static AppiumDriver driver = null;
    @BeforeAll
    @Step("Запуск Allure и логгирования запросов по API, запуск к МРС")
    public static void globalSetUp() throws IOException, InterruptedException {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());
        setUp();
    }

    public static void setUp() {

        String[] options = {"Подключение к уже запущенному MRS", "Запуск нового экземпляра MRS"};
        int x = JOptionPane.showOptionDialog(null, "Выберите способ запуска тестов",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        try {
        if (x == 0 ) {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), RunCase.getOptions("Подключение к уже запущенному MRS"));
        } else if (x == 1) {
            AppiumStarter.startAppiumServerUsingCommandPrompt();
            AltTesterDesktopStartEnd.AltTesterDesktopStarter();
            TimeUnit.SECONDS.sleep(5);
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), RunCase.getOptions("Запуск нового экземпляра MRS"));
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
/*    @AfterEach
    public void closeSession() {
        if(driver != null)
            driver.quit();
    }*/

        @AfterAll
    @Step("Закрытие МРС по запросу")
    public static void tearDown() {
        String[] options = {"Да", "Нет"};
        int x = JOptionPane.showOptionDialog(null, "Закрыть все ранее запущенные приложения?",
                "Нажмите кнопку",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
            if (x == 0 ) {
                if(driver != null)
                    driver.quit();
                AltTesterDesktopStartEnd.AltTesterDesktopDestroy();
                AppiumStarter.stopAppiumServerUsingCommandPrompt();
            }
        }
    }
/*    public static void closeBrioMRS() {
        if(driver != null)
            driver.quit();
    }
    @AfterAll
    public static void tearDown(){
        closeBrioMRS();
        //AltTesterDesktopStartEnd.AltTesterDesktopDestroy();
        AppiumStarter.stopAppiumServerUsingCommandPrompt();
    }*/


