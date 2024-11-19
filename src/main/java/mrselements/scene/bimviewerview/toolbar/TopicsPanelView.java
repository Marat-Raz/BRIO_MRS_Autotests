package mrselements.scene.bimviewerview.toolbar;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopicsPanelView {

  public static AppiumDriver driver;

  public static final By TOPICS_PANEL_VIEW = By.className("TopicsPanelView");
  public static final By X_BTN = By.xpath(
      "//TextBlock[@Text='Задачи BCF']/following-sibling::Button");
  public static final By FROM_FILE_BTN = By.xpath("//Button[.//TextBlock[@Text='Из файла']]");
  public static final By FROM_OBJECTIVES_BTN = By.xpath("//Button[.//TextBlock[@Text='Из задач']]");

  public TopicsPanelView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenTopicsPanelView() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(TOPICS_PANEL_VIEW));
  }

  public boolean topicsPanelViewIsOpen() {
    try {
      return driver.findElement(TOPICS_PANEL_VIEW).isDisplayed();
    } catch (TimeoutException | NoSuchElementException ex) {
      return false;
    }
  }

  @Step("Нажимаем на кнопку «Х»")
  public void clickOnXBtn() {
    driver.findElement(X_BTN).click();
  }

  @Step("Нажимаем на кнопку «Из файла»")
  public void clickOnFromFileBtn() {
    driver.findElement(FROM_FILE_BTN).click();
  }

  @Step("Нажимаем на кнопку «Из задач»")
  public void clickOnFromObjectivesBtn() {
    driver.findElement(FROM_OBJECTIVES_BTN).click();
  }


}
