package mrs_elements.scene.bim_viewer_view.toolbar;

import org.openqa.selenium.By;

public class ToolsSidePanelViewLocators {

  public static final By TOOLS_SIDE_PANEL_VIEW = By.className("ToolsSidePanelView");
  public static final By X_BTN =
      By.xpath("//TextBlock[@Text='Инстру\u200Bменты']/following-sibling::Button");
  // a zero-length space for line wrapping
  public static final By PLACEMENT_BTN_IN_DISTANCE_TOOL =
      By.xpath("//DistanceToolView//TextBlock[@Text='Размещение']");
  public static final By RESET_BTN_IN_DISTANCE_TOOL =
      By.xpath("//DistanceToolView//TextBlock[@Text='Сброс']");
  public static final By PLACEMENT_BTN_IN_POSITION_TOOL_VIEW =
      By.xpath("//PositionToolView//TextBlock[@Text='Размещение']");
  public static final By RESET_BTN_IN_POSITION_TOOL_VIEW =
      By.xpath("//PositionToolView//TextBlock[@Text='Сброс']");
  public static final By PLACEMENT_BTN_IN_RULER_TOOL_CONTROL =
      By.xpath("//RulerToolControl//TextBlock[@Text='Размещение']");
  public static final By RESET_BTN_IN_RULER_TOOL_CONTROL =
      By.xpath("//RulerToolControl//TextBlock[@Text='Сброс']");
  public static final By PLACEMENT_BTN_IN_SECTION_EDITOR =
      By.xpath("//SectionEditorView//TextBlock[@Text='Размещение']");
  public static final By RESET_BTN_IN_SECTION_EDITOR =
      By.xpath("//SectionEditorView//TextBlock[@Text='Сброс']");
  public static final By TURN_BTN_IN_SECTION_EDITOR =
      By.xpath("//SectionEditorView//TextBlock[@Text='Повернуть']");
  public static final By MOVE_BTN_IN_SECTION_EDITOR =
      By.xpath("//SectionEditorView//TextBlock[@Text='Переместить']");
  public static final By PLACEMENT_BTN_IN_ANGLE_TOOL_VIEW =
      By.xpath("//AngleToolView//TextBlock[@Text='Размещение']");
  public static final By RESET_BTN_IN_ANGLE_TOOL_VIEW =
      By.xpath("//AngleToolView//TextBlock[@Text='Сброс']");

}
