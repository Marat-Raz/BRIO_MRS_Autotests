package mrselements.scene.bimviewerview.toolbar;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarkersListView {

  public static AppiumDriver driver;

  public static final By MARKERS_LIST_VIEW = By.className("MarkersListView");
  public static final By X_BTN = By.xpath("//TextBlock[@Text='Метки']/following-sibling::Button");
  public static final By SEARCH = By.xpath("//MarkersListView//TextBox");
  public static final By GROUPING_MARKERS_BY_MODEL = By.xpath("//Expander/Grid/ToggleButton");

  public MarkersListView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenMarkersListView() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(MARKERS_LIST_VIEW));
  }

  public boolean markersListViewIsOpen() {
    try {
      return driver.findElement(MARKERS_LIST_VIEW).isDisplayed();
    } catch (TimeoutException | NoSuchElementException ex) {
      return false;
    }
  }

  @Step("Нажимаем на кнопку «Х»")
  public void clickOnXBtn() {
    driver.findElement(X_BTN).click();
  }

}
