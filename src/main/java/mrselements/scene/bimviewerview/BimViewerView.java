package mrselements.scene.bimviewerview;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BimViewerView {

  public static AppiumDriver driver;

  public static final By BIM_VIEWER_VIEW = By.className("BimViewerView");
  public static final By EXPANDER_WITHOUT_HEADER = By.className("ExpanderWithoutHeader");
  public static final By TOGGLE_MARKERS_PANEL_COMMAND_VIEW = By.className(
      "ToggleMarkersPanelCommandView");
  public static final By LOAD_IFC_COMMAND_VIEW = By.className("LoadIfcCommandView");
  public static final By OPEN_MAPPING_PANEL_COMMAND_VIEW = By.className(
      "OpenMappingPanelCommandView");
  public static final By OPEN_TOOLS_PANEL_COMMAND_VIEW = By.className("OpenToolsPanelCommandView");
  public static final By OBJECTIVES_PANEL_COMMAND_VIEW = By.className(
      "ToggleObjectivesPanelCommandView");
  public static final By BCF_PANEL_COMMAND_VIEW = By.className("ToggleBCFPanelCommandView");
  public static final By SWITCH_MINIMAP_AND_CUBE_VIEW_BTN = By.xpath(
      "//SwitchMinimapAndCubeView//Button");
  public static final By OPEN_MRS_CAMERA_BUTTON_VIEW = By.xpath(
      "//OpenMrsCameraButtonView//Button");
  public static final By MAKE_SCREENSHOT_BTN = By.xpath("//BimCaptureView//Button");

  public BimViewerView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenBimViewerView() {
    (new WebDriverWait(driver, Duration.ofSeconds(25)))
        .until(ExpectedConditions.visibilityOfElementLocated(BIM_VIEWER_VIEW));
  }

  public boolean bimViewerViewIsOpen() {
    return driver.findElement(BIM_VIEWER_VIEW).isDisplayed();
  }

  public static void waitOpenExpanderWithoutHeader() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(EXPANDER_WITHOUT_HEADER));
  }

  public boolean expanderWithoutHeaderIsOpen() {
    waitOpenExpanderWithoutHeader();
    return driver.findElement(EXPANDER_WITHOUT_HEADER).isDisplayed();
  }

  @Step("Нажимаем на кнопку «Метки»")
  public void clickOnMarkersBtn() {
    driver.findElement(TOGGLE_MARKERS_PANEL_COMMAND_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Модели»")
  public void clickOnModelsBtn() {
    driver.findElement(LOAD_IFC_COMMAND_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Панель карт этажей»")
  public void clickOnFloorMapPanelBtn() {
    driver.findElement(OPEN_MAPPING_PANEL_COMMAND_VIEW).click();
  }

  public boolean floorMapPanelBtnIsVisible() {
    try {
      return driver.findElement(EXPANDER_WITHOUT_HEADER).isDisplayed();
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  @Step("Нажимаем на кнопку «Инструменты»")
  public void clickOnToolsBtn() {
    driver.findElement(OPEN_TOOLS_PANEL_COMMAND_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Задачи»")
  public void clickOnObjectivesBtn() {
    driver.findElement(OBJECTIVES_PANEL_COMMAND_VIEW).click();
  }

  @Step("Нажимаем на кнопку «BCF»")
  public void clickOnBCFBtn() {
    driver.findElement(BCF_PANEL_COMMAND_VIEW).click();
  }

  @Step("Нажимаем на кнопку переключения между видовым кубом и мини картой")
  public void switchMinimapAndCubeView() {
    driver.findElement(SWITCH_MINIMAP_AND_CUBE_VIEW_BTN).click();
  }

  @Step("Нажимаем на кнопку переключения между режимами камеры и модели")
  public void clickMrsCameraButton() {
    driver.findElement(OPEN_MRS_CAMERA_BUTTON_VIEW).click();
  }

  @Step("Нажимаем на кнопку фотографирования")
  public void clickOnMakeScreenshotBtn() {
    driver.findElement(MAKE_SCREENSHOT_BTN).click();
  }

}
