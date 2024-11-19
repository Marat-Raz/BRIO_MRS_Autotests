package mrselements.explorerview;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorerView {

  public static AppiumDriver driver;
  public static final By EXPLORER_VIEW = By.xpath("//ExplorerView");
  //By.xpath("//ExplorerView//*[starts-with(@Text,'Выберите модели для загрузки')]/parent::*");
  public static final By EXPLORER_GO_BACK_BTN = By.name("explorerGoBackBtn");
  public static final By EXPLORER_ADD_TO_SCENE_BUTTON =
      By.xpath("//LoadIfcExplorerCommandView//SidePanelButton");

  public ExplorerView(AppiumDriver driver) {
    this.driver = driver;
  }

  public static void waitOpenExplorerView() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(EXPLORER_VIEW));
  }

  public boolean explorerViewIsOpen() throws InterruptedException {
    try {
      return driver.findElement(EXPLORER_VIEW).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void clickOnBackButton() {
    driver.findElement(EXPLORER_GO_BACK_BTN).click();
  }

  @Step("Нажать на проект в списке проектов")
  public void findModelAndClickThem(String project) {
    waitOpenExplorerView();
    driver.findElement(By.xpath("//ExplorerFileControl//TextBlock[@Text='"
        + project + "']")).click();
  }

  @Step("Нажать на кнопку «Добавить на сцену»")
  public void clickOnAddToSceneButton() {
    driver.findElement(EXPLORER_ADD_TO_SCENE_BUTTON).click();
  }


}
