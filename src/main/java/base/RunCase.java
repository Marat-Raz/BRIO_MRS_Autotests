package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RunCase {
    public static DesiredCapabilities getOptions(String startupMethod) {
        switch (startupMethod) {

            case "Подключение к уже запущенному MRS":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Windows");
                caps.setCapability("appium:automationName", "Windows");
                caps.setCapability("appium:app", "Root");
                //caps.setCapability("appium:newCommandTimeout", 180);
                caps.setCapability("ms:waitForAppLaunch", 10);
                caps.setCapability("appium:altUnityHost", "127.0.0.1");
                caps.setCapability("appium:altUnityPort", "13000");
                caps.setCapability("appium:attachToTopLevelWindowClassName", "UnityWndClass");
                caps.setCapability("appium:forceMatchAppTitle", "BRIO MRS");
                return caps;

            case "Запуск нового экземпляра MRS":
                DesiredCapabilities newCaps = new DesiredCapabilities();
                newCaps.setCapability("platformName", "Windows");
                newCaps.setCapability("appium:automationName", "Windows");
                newCaps.setCapability("appium:app", "D:\\BRIO MRS 2.1.3-gui-tests\\BRIO MRS.exe");
                newCaps.setCapability("appium:appWorkingDir", "D:\\BRIO MRS 2.1.3-gui-tests\\");
                newCaps.setCapability("appium:newCommandTimeout", "180");
                newCaps.setCapability("ms:waitForAppLaunch", 10);
                newCaps.setCapability("appium:altUnityHost", "127.0.0.1");
                newCaps.setCapability("appium:altUnityPort", "13000");
                newCaps.setCapability("appium:attachToTopLevelWindowClassName", "UnityWndClass");
                newCaps.setCapability("appium:forceMatchAppTitle", "BRIO MRS");
                return newCaps;

/*            case "chromeNoManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                return new ChromeDriver();*/

            default:
                throw new RuntimeException("Способ запуска не указан или указан не верно!");
        }
    }
}
