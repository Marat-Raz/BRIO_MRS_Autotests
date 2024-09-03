package mrs_elements.screenkeyboards;

import org.openqa.selenium.By;

public class ScreenKeyboardLocators {
    public static final By SCREEN_KEYBOARD = By.className("TextKeyboardWithMicView");
    public static final By SCREEN_KEYBOARD_INPUT = By.name("KeyboardTextBox");
    public static final By SCREEN_KEYBOARD_PART_ATTACHED_CLEAR_BUTTON = By.name("PART_AttachedClearButton");
    public static final By HIDE_KEYBOARD_BUTTON = By.name("hideKeyboardBtn");
    //public static final By REPEAT_BUTTON = By.name("RepeatButton");
    public static final By BUTTON_1 = By.xpath("//Button[.//TextBlock[@Text='1']]");
    public static final By BUTTON_2 = By.xpath("//Button[.//TextBlock[@Text='2']]");
    public static final By BUTTON_3 = By.xpath("//Button[.//TextBlock[@Text='3']]");
    public static final By BUTTON_4 = By.xpath("//Button[.//TextBlock[@Text='4']]");
    public static final By BUTTON_5 = By.xpath("//Button[.//TextBlock[@Text='5']]");
    public static final By BUTTON_6 = By.xpath("//Button[.//TextBlock[@Text='6']]");
    public static final By BUTTON_7 = By.xpath("//Button[.//TextBlock[@Text='7']]");
    public static final By BUTTON_8 = By.xpath("//Button[.//TextBlock[@Text='8']]");
    public static final By BUTTON_9 = By.xpath("//Button[.//TextBlock[@Text='9']]");
    public static final By BUTTON_0 = By.xpath("//Button[.//TextBlock[@Text='0']]");
    public static final By BUTTON_Q = By.xpath("//Button[.//TextBlock[@Text='й' or @Text='Й' or @Text='q' or @Text='Q']]");
    public static final By BUTTON_W = By.xpath("//Button[.//TextBlock[@Text='ц' or @Text='Ц' or @Text='w' or @Text='W']]");
    public static final By BUTTON_E = By.xpath("//Button[.//TextBlock[@Text='у' or @Text='У' or @Text='e' or @Text='E']]");
    public static final By BUTTON_R = By.xpath("//Button[.//TextBlock[@Text='к' or @Text='К' or @Text='r' or @Text='R']]");
    public static final By BUTTON_T = By.xpath("//Button[.//TextBlock[@Text='е' or @Text='Е' or @Text='t' or @Text='T']]");
    public static final By BUTTON_Y = By.xpath("//Button[.//TextBlock[@Text='н' or @Text='Н' or @Text='y' or @Text='Y']]");
    public static final By ENTER_BUTTON = By.xpath("//TextKeyboardWithMicView/Border/ContentPresenter/Grid/Border[2]/Grid/Decorator/Grid/ItemsControl/Border/ItemsPresenter/Grid/ContentPresenter[42]/RepeatButton");



}
