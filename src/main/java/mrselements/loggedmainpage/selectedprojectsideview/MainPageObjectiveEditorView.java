package mrselements.loggedmainpage.selectedprojectsideview;

import static mrselements.loggedmainpage.selectedprojectsideview.MainPageObjectiveEditorView_Locators.MAIN_PAGE_OBJECTIVE_EDITOR_VIEW;
import static mrselements.loggedmainpage.selectedprojectsideview.MainPageObjectiveEditorView_Locators.X_BTN;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import mrselements.MethodsForElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObjectiveEditorView {

  public static AppiumDriver driver;
  MethodsForElements methodsForElements;

  public MainPageObjectiveEditorView(AppiumDriver driver) {
    methodsForElements = new MethodsForElements(driver);
    this.driver = driver;
  }

  public void waitOpenMainPageObjectiveEditorView() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(MAIN_PAGE_OBJECTIVE_EDITOR_VIEW));
  }

  public boolean MainPageObjectiveEditorViewIsOpen() {
    waitOpenMainPageObjectiveEditorView();
    return driver.findElement(MAIN_PAGE_OBJECTIVE_EDITOR_VIEW).isDisplayed();
  }

  @Step("Нажать на кнопку закрыть")
  public void clickOnXBtn() {
    driver.findElement(X_BTN).click();
  }


}
