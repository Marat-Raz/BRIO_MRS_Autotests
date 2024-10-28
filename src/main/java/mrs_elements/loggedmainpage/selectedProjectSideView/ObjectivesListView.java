package mrs_elements.loggedmainpage.selectedProjectSideView;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mrs_elements.MethodsForElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ObjectivesListView {
    public static AppiumDriver driver;
    MethodsForElements methodsForElements;

    public static final By TOGGLE_BUTTON_SORT_BY_TIME =
            By.xpath("//ToggleButton[.//TextBlock[@Text='Сначала новые' or @Text='Сначала старые']]");
    public static final By DATE_COMBO_BOX = By.className("ComboBox");
    public static final By ITEM_CREATION_DATE =
            By.xpath("//Popup/descendant::TextBlock[@Text='Дата создания']");
    public static final By ITEM_DATE_MODIFIED =
            By.xpath("//Popup/descendant::TextBlock[@Text='Дата изменения']");
    public static final By ITEM_COMPLETION_DATE =
            By.xpath("//Popup/descendant::TextBlock[@Text='Дата завершения']");
    public static final By OBJECTIVES_SEARCH_TEXT_BOX =
            By.name("objectivesSearchTextBox");
    public static final By WINDOW_PLUG =
            By.xpath("//SelectedProjectSideView//*[starts-with(@Text,'Здесь будут задачи')]");
    public static final By FIRST_LIST_BOX_ITEM =
            By.xpath("//VirtualizingStackPanel/ListBoxItem[1]");
    public static final By LIST_BOX_ITEM =
            By.xpath("//ObjectivesListView//ListBox//ListBoxItem//TextBlock[@Name='title']");
    public static final By EXPANDED_LABEL = By.className("ExpandedLabel");
    public static final By SELECT_ALL_BTN = By.xpath("//ExpandedLabel//Button[.//TextBlock[@Text='Выделить всё']]");
    public static final By DESELECT_ALL_BTN =
            By.xpath("//ExpandedLabel//Button[.//TextBlock[@Text='Выделить всё']]/following-sibling::*");
    public static final By TXT_NO_OBJECTIVES_FOUND =
            By.xpath("//ObjectivesListView//TextBlock[@Text='Задачи не найдены']");
    public static final By PROJECT_NAME =
            By.xpath("//SelectedProjectSideView//*[starts-with(@Text,'For Autotests')]");
    public static final By SELECTION_INDICATOR =
            By.xpath("//ListBoxItem//HoldButton//Rectangle[@Name='SelectionUnderline']");
    public static final By SELECTED_OBJECTIVES =
            By.xpath("//SelectedProjectSideView//ExpandedLabel//*[starts-with(@Text,'Выбран')]");

    public ObjectivesListView(AppiumDriver driver) {
        methodsForElements = new MethodsForElements(driver);
        this.driver = driver;
    }

    @Step("Статус нажатия на кнопку «Сначала новые»/«Сначала старые»")
    public boolean statusOfToggleButtonSortByTime() {
        return methodsForElements.switchEnabled(TOGGLE_BUTTON_SORT_BY_TIME);
    }

    @Step("Нажать на кнопку сортировки «Сначала новые»/«Сначала старые»")
    public void clickOnToggleButtonSortByTime() {
        driver.findElement(TOGGLE_BUTTON_SORT_BY_TIME).click();
    }

    @Step("Выбор способа сортировки задач по «Дата создания»")
    public void selectCreationDate() {
        methodsForElements.clickingOnListAndSelectListItem(DATE_COMBO_BOX, ITEM_CREATION_DATE);
    }

    @Step("Выбор способа сортировки задач по «Дата изменения»")
    public void selectDateModified() {
        methodsForElements.clickingOnListAndSelectListItem(DATE_COMBO_BOX, ITEM_DATE_MODIFIED);
    }

    @Step("Выбор способа сортировки задач по «Дата завершения»")
    public void selectCompletionDate() {
        methodsForElements.clickingOnListAndSelectListItem(DATE_COMBO_BOX, ITEM_COMPLETION_DATE);
    }

    @Step("Нажать на поле «Поиск»")
    public void clickOnSearchField() {
        driver.findElement(OBJECTIVES_SEARCH_TEXT_BOX).click();
    }

    @Step("Нажать на первую задачу")
    public void clickOnFirstListBoxItem() {
        driver.findElement(FIRST_LIST_BOX_ITEM).click();
    }

    @Step("Зажать на первой задаче")
    public void clickAndHoldOnFirstListBoxItem() {
        WebElement listBoxItem = driver.findElement(FIRST_LIST_BOX_ITEM);
        new Actions(driver)
                .clickAndHold(listBoxItem)
                .perform();
    }

    @Step("Строка «Выделено...» «Выделить всё» видна?")
    public boolean expandedLabelIsVisible() {
        return driver.findElement(EXPANDED_LABEL).isDisplayed();
    }

    @Step("Нажать на первую задачу")
    public void clickOnSelectAllBtn() {
        driver.findElement(SELECT_ALL_BTN).click();
    }

    @Step("Нажать на первую задачу")
    public void clickOnDeselectAllBtn() {
        driver.findElement(DESELECT_ALL_BTN).click();
    }

    @Step("Получить, считать список задач")
    public static String[] getListOfObjectives() {
        List<WebElement> elements = driver.findElements(LIST_BOX_ITEM);
        String[] objectives = new String[elements.size()];
        int i = 0;
        for (WebElement element : elements) {
            objectives[i] = element.getText();
            i++;
        }
        return objectives;
    }

    @Step("Текст «Задачи не найдены» виден?")
    public boolean txtNoObjectivesFoundIsVisible() {
        return driver.findElement(TXT_NO_OBJECTIVES_FOUND).isDisplayed();
    }

    @Step("Текст «Здесь будут задачи для отображения отклонений.» виден?")
    public boolean projectHasNotObjectives() {
        return driver.findElement(WINDOW_PLUG).isDisplayed();
    }

    @Step("Получить количество задач из заголовка проекта «For Autotests»")
    public int getNumberOfObjectivesFromHeaderOfProjects() {
        String txt = (driver.findElement(PROJECT_NAME).getText()).substring(13);
        int numberOfProjects = txt == "" ? 0 : Integer.parseInt(txt.trim());
        return numberOfProjects;
    }

    @Step("Получить количество выделенных элементов(задач) списка задач")
    public static int getNumberOfSelectedObjectives() {
        List<WebElement> elements = driver.findElements(SELECTION_INDICATOR);
        int[] attributes = new int[elements.size()];
        int i = 0;
        for (WebElement element : elements) {
            attributes[i] = Integer.parseInt(element.getAttribute("width"));
            i++;
        }
         int number = 0;
        for (int j = 0; j < attributes.length; j++) {
            if (attributes[j] > 0) {
               number++;
            };
        }
        return number;
    }

    @Step("Получить количество выделенных задач из текста «Выделено: ... задач»")
    public int getNumberOfSelectedObjectivesFromText() {
        String txt = (driver.findElement(SELECTED_OBJECTIVES).getText()).substring(7, 10);
        int numberOfProjects = txt == "" ? 0 : Integer.parseInt(txt.trim());
        return numberOfProjects;
    }

}
