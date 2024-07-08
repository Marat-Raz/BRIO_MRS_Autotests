import io.appium.java_client.AppiumDriver;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.*;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestsStarter {
    static AppiumDriver driver = null;
    @BeforeAll
    @Step("Запуск Allure и логгирования запросов по API")
    public static void globalSetUp() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());}
    @BeforeEach
        public void startNewMRS() throws InterruptedException, IOException {
        AppiumStarter.startAppiumServerUsingCommandPrompt();
        AltTesterDesktopStartEnd.AltTesterDesktopStarter();
        TimeUnit.SECONDS.sleep(5);
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Windows");
            caps.setCapability("appium:automationName", "Windows");
            caps.setCapability("appium:app", "D:\\BRIO MRS 2.1.3-gui-tests\\BRIO MRS.exe");
            caps.setCapability("appium:appWorkingDir", "D:\\BRIO MRS 2.1.3-gui-tests\\");
            caps.setCapability("ms:waitForAppLaunch", 10);
            caps.setCapability("appium:altUnityHost", "127.0.0.1");
            caps.setCapability("appium:altUnityPort", "13000");
            caps.setCapability("appium:attachToTopLevelWindowClassName", "UnityWndClass");
            caps.setCapability("appium:forceMatchAppTitle", "BRIO MRS");

            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @AfterEach
    @Step
    public void closeBrioMRS() {
        if(driver != null)
            driver.quit();
    }
    @AfterAll
    public static void tearDown(){
        AltTesterDesktopStartEnd.AltTesterDesktopDestroy();
        AppiumStarter.stopAppiumServerUsingCommandPrompt();
    }
}
