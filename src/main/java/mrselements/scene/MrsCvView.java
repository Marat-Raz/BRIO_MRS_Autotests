package mrs_elements.scene;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MrsCvView {

  public static AppiumDriver driver;

  public static final By MRS_CV_VIEW = By.className("MrsCVView");
  public static final By MIXED_REALITY_MODE_SWITCH_VIEW = By.className(
      "MixedRealityModeSwitchView");
  public static final By SWITCH_TO_AR_BTN = By.name("switchToARBtn");
  public static final By SWITCH_TO_MR_BTN = By.name("switchToMRBtn");
  public static final By SWITCH_TO_AMR_BTN = By.name("switchToAMRBtn");
  public static final By OPEN_BIM_VIEWER_BUTTON = By.xpath("//OpenBimViewerButtonView//Button");

  public MrsCvView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenMrsCvView() {
    (new WebDriverWait(driver, Duration.ofSeconds(5)))
        .until(ExpectedConditions.visibilityOfElementLocated(MRS_CV_VIEW));
  }

  public boolean mrsCvViewIsOpen() {
    waitOpenMrsCvView();
    return driver.findElement(MRS_CV_VIEW).isDisplayed();
  }

  public boolean mixedRealityModeSwitchViewIsVisible() {
    return driver.findElement(MIXED_REALITY_MODE_SWITCH_VIEW).isDisplayed();
  }

  @Step("Нажимаем на кнопку переключения между режимами камеры и модели")
  public void clickOnOpenBimViewerButton() {
    driver.findElement(OPEN_BIM_VIEWER_BUTTON).click();
  }

}
