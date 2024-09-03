package mrs_elements.toppanel.menu.settings;

import org.openqa.selenium.By;

public class InterfaceWindowLocators {
    public static final By INTERFACE_WINDOW =
            By.xpath("//Button[.//TextBlock[@Text='Интерфейс' or @Text='Interface']]/parent::*");
    public static final By GO_BACK_INTERFACE_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Интерфейс' or @Text='Interface']]");
    public static final By INTERFACE_X_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Интерфейс' or @Text='Interface']]/following-sibling::*");
    public static final By INTERFACE_LANGUAGE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Язык' or @Text='Language']/parent::*/descendant::ToggleButton");
    public static final By LANGUAGE_POPUP_ENGLISH =
            By.xpath("//Popup/descendant::TextBlock[@Text='English (US)']");
    public static final By LANGUAGE_POPUP_RUSSIAN =
            By.xpath("//Popup/descendant::TextBlock[@Text='Русский']");
    public static final By INTERFACE_SIDE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Сторона интерфейса']/parent::*/descendant::ToggleButton");
    public static final By INTERFACE_SIDE_POPUP_RIGHT =
            By.xpath("//Popup/descendant::TextBlock[@Text='Правая']");
    public static final By INTERFACE_SIDE_POPUP_LEFT =
            By.xpath("//Popup/descendant::TextBlock[@Text='Левая']");
    public static final By SHOW_VIEW_CUBE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать видовой куб']/following-sibling::*");
    public static final By SHOW_MINIMAP_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать миникарту']/following-sibling::*");
    public static final By SHOW_LOCATION_ON_MAP_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать местоположение на карте']/following-sibling::*");
    public static final By SHOW_MAP_PANE_BUTTON_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать кнопку панели карт']/following-sibling::*");
    public static final By STICKING_TAPE_MEASURE_TO_CORNERS_OF_MODEL_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Прилипание рулетки к углам модели']/following-sibling::*");
    public static final By VISIBILITY_RANGE_OF_OBJECTS_OUTPUT =
            By.xpath("//TextBlock[@Text='Дальность видимости объектов']/following-sibling::*");
    public static final By VISIBILITY_RANGE_OF_OBJECTS_SLIDER =
            By.xpath("//TextBlock[@Text='Дальность видимости объектов']/parent::*/parent::*/child::Slider");
    public static final By RENDERING_LEVEL_OF_DETAIL_OUTPUT =
            By.xpath("//TextBlock[@Text='Уровень детализации отрисовки']/following-sibling::*");
    public static final By RENDERING_LEVEL_OF_DETAIL_SLIDER =
            By.xpath("//TextBlock[@Text='Уровень детализации отрисовки']/parent::*/parent::*/child::Slider");
    public static final By FAR_CLIPPING_PLANE_OUTPUT =
            By.xpath("//TextBlock[@Text='Дальняя отсекающая плоскость']/following-sibling::*");
    public static final By FAR_CLIPPING_PLANE_SLIDER =
            By.xpath("//TextBlock[@Text='Дальняя отсекающая плоскость']/parent::*/parent::*/child::Slider");
    public static final By DISPLAY_TASK_OUT_OF_SIGHT_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Отображать метки задач, находящихся вне поля зрения']/following-sibling::*");
    public static final By MAXIMUM_RENDERING_DISTANCE_LABELS_OUTPUT =
            By.xpath("//TextBlock[@Text='Максимальная дальность отрисовки меток задач']/following-sibling::*");
    public static final By MAXIMUM_RENDERING_DISTANCE_LABELS_SLIDER =
            By.xpath("//TextBlock[@Text='Максимальная дальность отрисовки меток задач']/parent::*/parent::*/child::Slider");
    public static final By USE_DRAW_DISTANCE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Использовать ограничение дальности " +
                    "отрисовки меток задач на виде модели']/following-sibling::*");
    public static final By SCROLL_BAR_INCREASE_BUTTON = By.xpath("//SettingsView/Border/ContentPresenter/" +
            "AnimatedContentControl/Border/Grid/ContentPresenter/Grid/ScrollViewer/Border/Grid/ScrollBar[2]/Grid/" +
            "Track/RepeatButton[2]");

}
