package mrs_elements;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodsForElements {
    public static AppiumDriver driver;
    public MethodsForElements(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean switchEnabled(By by) {
        String attr = driver.findElement(by).getAttribute("IsChecked");
        boolean IsChecked = Boolean.parseBoolean(attr);
        return IsChecked;
    }

    public void moveSliderToPercent(WebElement slider, int percent) {
        Actions builder = new Actions(this.driver);
        Action dragAndDrop;
        int height = slider.getSize().getHeight();
        int width = slider.getSize().getWidth();
        int xHeight = (int) ((height * percent) / 100);
        int xWidth = (int) ((width * percent) / 100);

        if (width > height) {
            //highly likely a horizontal slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(-(width / 2), 0).
                    moveByOffset(xWidth, 0).
                    release().build();
        } else {
            //highly likely a vertical slider
            dragAndDrop = builder.clickAndHold(slider).moveByOffset(0, -(height / 2)).
                    moveByOffset(0, xHeight).
                    release().build();
        }
        dragAndDrop.perform();
    }

    public void clickingOnListAndSelectListItem(By list, By listItem) {
        driver.findElement(list).click();
        (new WebDriverWait(driver, Duration.ofSeconds(1)))
                .until(ExpectedConditions.visibilityOfElementLocated(listItem));
        driver.findElement(listItem).click();
    }
}
