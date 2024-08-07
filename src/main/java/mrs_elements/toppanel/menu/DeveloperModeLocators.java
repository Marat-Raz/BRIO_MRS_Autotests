package mrs_elements.toppanel.menu;

import org.openqa.selenium.By;

public class DeveloperModeLocators {
    public static final By DEVELOPER_MODE_WINDOW = By.xpath("//Button[.//TextBlock[@Text='Для разработчиков']]/parent::*");
    public static final By DEVELOPER_MODE_GO_BACK =
            By.xpath("//Button[.//TextBlock[@Text='Для разработчиков']]");
    public static final By COMPUTER_VISION_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Компьютерное зрение']]");
    public static final By VERTICAL_SYNC_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Вертикальная синхронизация']/following-sibling::*");
    public static final By SHOW_STATISTICS_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать статистику']/following-sibling::*");
    public static final By SHOW_DEPTH_MAP_INSTEAD_OF_CAMERA_IMAGE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Показывать карту глубины вместо изображения с камеры']/following-sibling::*");
    public static final By MINIMAP_MODE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Режим миникарты']/parent::*/descendant::ToggleButton");
    public static final By MINIMAP_MODE_POPUP_MAP_ROTATION =
            By.xpath("//Popup/descendant::TextBlock[@Text='Вращение карты']");
    public static final By MINIMAP_MODE_POPUP_ROTATE_MARKER =
            By.xpath("//Popup/descendant::TextBlock[@Text='Вращение маркера']");
    public static final By VIRTUAL_KEYBOARD_TYPE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Тип виртуальной клавиатуры']/parent::*/descendant::ToggleButton");
    public static final By VIRTUAL_KEYBOARD_TYPE_POPUP_BUILT_INTO_MRS =
            By.xpath("//Popup/descendant::TextBlock[@Text='Встроенная в MRS']");
    public static final By VIRTUAL_KEYBOARD_TYPE_POPUP_SYSTEM_WINDOWS =
            By.xpath("//Popup/descendant::TextBlock[@Text='Системная (Windows)']");
    public static final By VIRTUAL_KEYBOARD_TYPE_POPUP_NO_VIRTUAL_KEYBOARD =
            By.xpath("//Popup/descendant::TextBlock[@Text='Без виртуальной клавиатуры']");
    public static final By VOICE_INPUT_DEVICE_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Устройство голосового ввода']/parent::*/descendant::ToggleButton");
    public static final By VOICE_INPUT_DEVICE_POPUP =
            By.xpath("//SettingsView/Border/ContentPresenter/AnimatedContentControl/Border/Grid/" +
                    "ContentPresenter/Grid/ScrollViewer/Border/Grid/ScrollContentPresenter/ItemsControl/Border/" +
                    "ItemsPresenter/StackPanel/ContentPresenter[7]/Grid/ComboBox/Grid/Popup/Border");
    public static final By MOVE_THE_MODEL_S_CAMERA_BEHIND_REAL_CAMERA_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Перемещать камеру модели за реальной камерой']/following-sibling::*");
    public static final By CAMERA_ANIMATION_SPEED_OUTPUT =
            By.xpath("//TextBlock[@Text='Скорость анимации камеры']/following-sibling::*");
    public static final By CAMERA_ANIMATION_SPEED_SLIDER =
            By.xpath("//TextBlock[@Text='Скорость анимации камеры']/parent::*/parent::*/child::Slider");
    public static final By SELECT_COINCIDENT_FEATURES_TOGGLE_BUTTON =
            By.xpath("//TextBlock[@Text='Выделять совпадающие объекты']/following-sibling::*");
    public static final By DISTANCE_TO_COINCIDENT_FEATURES_OUTPUT =
            By.xpath("//TextBlock[@Text='Расстояние до совпадения объектов']/following-sibling::*");
    public static final By DISTANCE_TO_COINCIDENT_FEATURES_SLIDER =
            By.xpath("//TextBlock[@Text='Расстояние до совпадения объектов']/parent::*/parent::*/child::Slider");
    public static final By TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_OUTPUT =
            By.xpath("//TextBlock[@Text='Прозрачность объекта пересечения']/following-sibling::*");
    public static final By TRANSPARENCY_OF_AN_INTERSECTION_OBJECT_SLIDER =
            By.xpath("//TextBlock[@Text='Прозрачность объекта пересечения']/parent::*/parent::*/child::Slider");
    public static final By INTERSECTION_LINE_SIZE_OUTPUT =
            By.xpath("//TextBlock[@Text='Размер линии пересечения']/following-sibling::*");
    public static final By INTERSECTION_LINE_SIZE_SLIDER =
            By.xpath("//TextBlock[@Text='Размер линии пересечения']/parent::*/parent::*/child::Slider");
    public static final By DATASET_BTN = By.name("datasetBtn");
    public static final By COLLECT_BUTTON =
            By.xpath("//Button[.//TextBlock[@Text='Собрать']]");
    public static final By REPEAT_BUTTON_BY_SCROLL_BAR =
            By.xpath("//SettingsView/Border/ContentPresenter/AnimatedContentControl/Border/Grid/" +
                    "ContentPresenter/Grid/ScrollViewer/Border/Grid/ScrollBar[2]/Grid/Track/RepeatButton[2]");
    public static final By STATISTICS_WINDOW =
            By.xpath("//StatisticsOverlayView/Border/ContentPresenter/Grid/Border/Grid");
}
