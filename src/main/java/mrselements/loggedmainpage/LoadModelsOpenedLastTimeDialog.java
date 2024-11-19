package mrselements.loggedmainpage;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadModelsOpenedLastTimeDialog {

  public static AppiumDriver driver;
  public static final By YES_BTN =
      By.xpath("//LoadPreviousDialogView//Button[.//TextBlock[@Text='Да']]");
  public static final By NO_BTN =
      By.xpath("//LoadPreviousDialogView//Button[.//TextBlock[@Text='Нет']]");
  public static final By DIALOG =
      By.xpath(
          "//LoadPreviousDialogView//*[starts-with(@Text,'Загрузить открытые в прошлый раз модели')]/parent::*");

  public LoadModelsOpenedLastTimeDialog(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenLoadModelsOpenedLastTimeDialog() {
    (new WebDriverWait(driver, Duration.ofSeconds(10)))
        .until(ExpectedConditions.visibilityOfElementLocated(DIALOG));
  }

  public boolean loadModelsOpenedLastTimeDialogIsOpen() {
    try {
      return driver.findElement(DIALOG).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @Step("Нажать на кнопку «Да»")
  public void clickOnYesButton() {
    driver.findElement(YES_BTN).click();
  }

  @Step("Нажать на кнопку «Нет»")
  public void clickOnNoButton() {
    waitOpenLoadModelsOpenedLastTimeDialog();
    driver.findElement(NO_BTN).click();
  }

}
