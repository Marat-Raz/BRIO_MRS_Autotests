package pages;


import org.openqa.selenium.By;

public class TotalConstants {

public static final By MENU_BUTTON = By.xpath("//NotificationPanelView/Grid/ContentPresenter/Grid/" +
        "ExpanderWithoutHeader/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/Border/ContentPresenter/" +
        "Border/Grid/Grid/StackPanel/TextBlock");
public static final By CLOSE_APPLICATION_BUTTON = By.xpath("//CloseAppActionView/Border/ContentPresenter/" +
        "Button/Grid/ContentPresenter/TextBlock");
public static final By YES_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[1]/Button/" +
        "Grid/ContentPresenter/TextBlock");
public static final By NO_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[2]/Button/" +
        "Grid/ContentPresenter/TextBlock");






}