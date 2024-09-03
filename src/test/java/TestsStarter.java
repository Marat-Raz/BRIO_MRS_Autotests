import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestsStarter {
    static AppiumDriver driver = null;

    @BeforeAll
    @Step("Запуск Allure и логирования запросов по API, запуск Appium + AltTesterDesktop + БРИО МРС")
    public static void globalSetUp() throws InterruptedException {
        RestAssured.replaceFiltersWith(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());
        AppiumStarter.startAppiumServerUsingCommandPrompt();
        AltTesterDesktopStartEnd.AltTesterDesktopStarter();
        startNewMRS();
    }

    public static void startNewMRS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Windows");
            caps.setCapability("appium:automationName", "Windows");
            caps.setCapability("appium:app", "D:\\BRIO MRS 2.x for AutoTests\\BRIO MRS.exe");
            caps.setCapability("appium:appWorkingDir", "D:\\BRIO MRS 2.x for AutoTests\\");
            caps.setCapability("ms:waitForAppLaunch", 10);
            caps.setCapability("appium:altUnityHost", "127.0.0.1");
            caps.setCapability("appium:altUnityPort", "13000");
            caps.setCapability("appium:attachToTopLevelWindowClassName", "UnityWndClass");
            //caps.setCapability("appium:forceMatchAppTitle", "BRIO MRS");

            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    @Step("Закрытие ранее запущенных приложений")
    public static void tearDown() throws InterruptedException {
        if (driver != null)
            driver.quit();
        AltTesterDesktopStartEnd.AltTesterDesktopDestroy();
        AppiumStarter.stopAppiumServerUsingCommandPrompt();
        TimeUnit.SECONDS.sleep(3);

    }
}
