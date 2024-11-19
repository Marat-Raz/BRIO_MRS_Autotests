package mrselements.scene.bimviewerview.toolbar;

import static mrselements.scene.bimviewerview.toolbar.ToolsSidePanelViewLocators.*;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsSidePanelView {

  public static AppiumDriver driver;

  public ToolsSidePanelView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenToolsSidePanelView() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(TOOLS_SIDE_PANEL_VIEW));
  }

  public boolean toolsSidePanelViewIsOpen() {
    try {
      return driver.findElement(TOOLS_SIDE_PANEL_VIEW).isDisplayed();
    } catch (TimeoutException | NoSuchElementException ex) {
      return false;
    }
  }

  @Step("Нажимаем на кнопку «Х»")
  public void clickOnXBtn() {
    driver.findElement(X_BTN).click();
  }

  @Step("Нажимаем на кнопку «Размещение» в разделе «Расстояние»")
  public void clickOnPlacementBtnInDistanceTool() {
    driver.findElement(PLACEMENT_BTN_IN_DISTANCE_TOOL).click();
  }

  @Step("Нажимаем на кнопку «Сброс»в разделе «Расстояние»")
  public void clickOnResetBtnInDistanceTool() {
    driver.findElement(RESET_BTN_IN_DISTANCE_TOOL).click();
  }

  @Step("Нажимаем на кнопку «Размещение» в разделе «Координаты»")
  public void clickOnPlacementBtnInPositionToolView() {
    driver.findElement(PLACEMENT_BTN_IN_POSITION_TOOL_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Сброс» в разделе «Координаты»")
  public void clickOnResetBtnInPositionToolView() {
    driver.findElement(RESET_BTN_IN_POSITION_TOOL_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Размещение» в разделе «Расстояние между элементами»")
  public void clickOnPlacementBtnInRulerToolControl() {
    driver.findElement(PLACEMENT_BTN_IN_RULER_TOOL_CONTROL).click();
  }

  @Step("Нажимаем на кнопку «Сброс» в разделе «Расстояние между элементами»")
  public void clickOnResetBtnInRulerToolControl() {
    driver.findElement(RESET_BTN_IN_RULER_TOOL_CONTROL).click();
  }

  @Step("Нажимаем на кнопку «Размещение» в разделе «Разрез»")
  public void clickOnPlacementBtnInSectionEditor() {
    driver.findElement(PLACEMENT_BTN_IN_SECTION_EDITOR).click();
  }

  @Step("Нажимаем на кнопку «Сброс» в разделе «Разрез»")
  public void clickOnResetBtnInSectionEditor() {
    driver.findElement(RESET_BTN_IN_SECTION_EDITOR).click();
  }

  @Step("Нажимаем на кнопку «Повернуть» в разделе «Разрез»")
  public void clickOnTurnBtnInSectionEditor() {
    driver.findElement(TURN_BTN_IN_SECTION_EDITOR).click();
  }

  @Step("Нажимаем на кнопку «Переместить» в разделе «Разрез»")
  public void clickOnMoveBtnInSectionEditor() {
    driver.findElement(MOVE_BTN_IN_SECTION_EDITOR).click();
  }

  @Step("Нажимаем на кнопку «Размещение» в разделе «Угол»")
  public void clickOnPlacementBtnInAngleToolView() {
    driver.findElement(PLACEMENT_BTN_IN_ANGLE_TOOL_VIEW).click();
  }

  @Step("Нажимаем на кнопку «Сброс» в разделе «Угол»")
  public void clickOnResetBtnInAngleToolView() {
    driver.findElement(RESET_BTN_IN_ANGLE_TOOL_VIEW).click();
  }


}
