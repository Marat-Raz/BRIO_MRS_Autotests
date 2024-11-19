import static generaldatatests.GeneralDataTests.BRIO_CLOUD_USERNAME;
import static generaldatatests.GeneralDataTests.MRS_START_FOLDER;
import static generaldatatests.GeneralDataTests.projectsForTests;

import api.client.ConnectionsClient;
import api.client.ProjectsClient;
import api.client.UserClient;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import startmrshelper.AltTesterDesktopStartEnd;
import startmrshelper.AppiumStarter;
import startmrshelper.DocumentManagementApp;

public class TestsStarter {

  static AppiumDriver driver = null;
  static UserClient userClient;
  static ProjectsClient projectsClient;
  static ConnectionsClient connectionsClient;
  static int userId;

  @BeforeAll
  @Step("Запуск Allure и логирования запросов по API, "
      + "создание пользователя для тестов - 'Autotests', при необходимости, "
      + "добавление в список проектов этого пользователя необходимых для тестов проектов, "
      + "запуск Appium + AltTesterDesktop + БРИО МРС")
  public static void globalSetUp() throws InterruptedException {
    RestAssured.replaceFiltersWith(
        new RequestLoggingFilter(), new ResponseLoggingFilter(),
        new AllureRestAssured());
    DocumentManagementApp.startDocumentManagement(MRS_START_FOLDER);
    createUserAndAddProjects();
    // todo создать пользователя c типом Brio-Cloud
    // todo загрузить проекты для данного пользователя, нужные для тестов
    AppiumStarter.startAppiumServerUsingCommandPrompt();
    AltTesterDesktopStartEnd.altTesterDesktopStarter();
    startNewMRS();
  }

  public static void startNewMRS() throws InterruptedException {
    TimeUnit.SECONDS.sleep(7);
    try {
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("platformName", "Windows");
      caps.setCapability("appium:automationName", "Windows");
      caps.setCapability("appium:app", MRS_START_FOLDER + "BRIO MRS.exe");
      caps.setCapability("appium:appWorkingDir", MRS_START_FOLDER);
      caps.setCapability("ms:waitForAppLaunch", 10);
      caps.setCapability("appium:altUnityHost", "127.0.0.1");
      caps.setCapability("appium:altUnityPort", "13000");
      caps.setCapability("appium:attachToTopLevelWindowClassName", "UnityWndClass");
      //caps.setCapability("appium:forceMatchAppTitle", "BRIO MRS");

      driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), caps);
      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void createUserAndAddProjects() {
    userClient = new UserClient();
    projectsClient = new ProjectsClient();
    connectionsClient = new ConnectionsClient();

    ValidatableResponse getResponse = userClient.checkUserExistsByLogin(BRIO_CLOUD_USERNAME);
    boolean userExist = Boolean.parseBoolean(getResponse.extract().asString());
    if (!userExist) {
      ValidatableResponse response = userClient.createBrioCloudUserForAutotests();
      userId = response.extract().path("id");
      connectionsClient.addConnectionInfoToUserAutotests(userId);
    } else {
      userId = userClient.getUserByLogin(BRIO_CLOUD_USERNAME).extract().path("id.id");
    }
    List<String> projectsList =
        projectsClient.getProjectsLinkedToUser(userId).extract().path("title");
    List<String> expectedList = new ArrayList<>(projectsForTests);
    expectedList.removeAll(projectsList);

    if (expectedList.size() != 0) {
      projectsClient.addProjectsForTests(userId, expectedList);
    }
  }


  @AfterAll
  @Step("Закрытие ранее запущенных приложений")
  public static void tearDown() throws InterruptedException {
    if (driver != null) {
      driver.quit();
    }
    DocumentManagementApp.documentManagementDestroy();
    // We do not delete the user and projects with the MRS for further tests
    AltTesterDesktopStartEnd.altTesterDesktopDestroy();
    AppiumStarter.stopAppiumServerUsingCommandPrompt();
    TimeUnit.SECONDS.sleep(3);
  }
}
