package mrs_elements.screenkeyboards;

import static mrs_elements.screenkeyboards.ScreenKeyboardLocators.ENTER_BUTTON;
import static mrs_elements.screenkeyboards.ScreenKeyboardLocators.HIDE_KEYBOARD_BUTTON;
import static mrs_elements.screenkeyboards.ScreenKeyboardLocators.SCREEN_KEYBOARD;
import static mrs_elements.screenkeyboards.ScreenKeyboardLocators.SCREEN_KEYBOARD_INPUT;
import static mrs_elements.screenkeyboards.ScreenKeyboardLocators.SCREEN_KEYBOARD_PART_ATTACHED_CLEAR_BUTTON;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenKeyboard {

  public static AppiumDriver driver;

  public ScreenKeyboard(AppiumDriver driver) {
    this.driver = driver;
  }

  public void waitOpenScreenKeyboard() {
    (new WebDriverWait(driver, Duration.ofSeconds(3)))
        .until(ExpectedConditions.visibilityOfElementLocated(SCREEN_KEYBOARD));
  }

  public boolean screenKeyboardIsOpen() {
    waitOpenScreenKeyboard();
    return driver.findElement(SCREEN_KEYBOARD).isDisplayed();
  }

  @Step("Нажать на кнопку удаления текста")
  public void clickClearButton() {
    waitOpenScreenKeyboard();
    driver.findElement(SCREEN_KEYBOARD_PART_ATTACHED_CLEAR_BUTTON).click();
  }

  @Step("Нажать на кнопку скрытия клавиатуры")
  public void clickHideKeyboardButton() {
    waitOpenScreenKeyboard();
    driver.findElement(HIDE_KEYBOARD_BUTTON).click();
  }

  @Step("Ввод текста в поле ввода клавиатуры")
  public void enterTextToScreenKeyboardInput(String text) {
    clickClearButton();
    driver.findElement(SCREEN_KEYBOARD_INPUT).sendKeys(text);
  }

  @Step("Нажать на кнопку «Enter»")
  public void clickEnterButton() {
    driver.findElement(ENTER_BUTTON).click();
  }


}
