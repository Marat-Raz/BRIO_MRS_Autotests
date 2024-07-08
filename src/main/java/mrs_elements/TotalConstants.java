package mrs_elements;


import org.openqa.selenium.By;

public class TotalConstants {
    public static final By MENU_BUTTON = By.xpath("//OpenMenuActionView/Border/ContentPresenter/" +
                "Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By CLOSE_APPLICATION_BUTTON = By.xpath("//CloseAppActionView/Border/" +
            "ContentPresenter/Button/Grid/ContentPresenter/TextBlock");
    public static final By YES_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[1]/" +
            "Button/Grid/ContentPresenter/TextBlock");
    public static final By NO_BUTTON_CLOSE_APPLICATION = By.xpath("//UniformGrid/ContentPresenter[2]/" +
            "Button/Grid/ContentPresenter/TextBlock");
    public static final By SYNCHRONIZATION_BUTTON = By.xpath("//ConnectionIndicatorView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By NOTIFICATIONS_BUTTON = By.xpath("//NotificationPanelOpenActionView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AXES_BUTTON = By.xpath("//ToggleGridLabelsCommandView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By EXPLORER_BUTTON = By.xpath("//OpenExplorerContextActionView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By HIERARCHY_BUTTON = By.xpath("//ToggleHierarchyCommandView/Border/" +
            "ContentPresenter/Button/Grid/Border/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[1]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By MR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[2]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");
    public static final By AMR_BUTTON = By.xpath("//MixedRealityModeSwitchView/Border/ContentPresenter/" +
            "Grid/RadioButton[3]/Border/DockPanel/ContentPresenter/VectorIcon/Border/Viewbox/Decorator/Canvas/Path");




}