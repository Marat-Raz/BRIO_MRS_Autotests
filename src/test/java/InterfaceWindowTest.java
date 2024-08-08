import io.qameta.allure.Link;
import mrs_elements.MethodsForElements;
import mrs_elements.toppanel.MenuWindow;
import mrs_elements.toppanel.TopPanel;
import mrs_elements.toppanel.menu.SettingsWindow;
import mrs_elements.toppanel.menu.settings.InterfaceWindow;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceWindowTest extends TestsStarter {
    TopPanel topPanel = new TopPanel(driver);
    MenuWindow menuWindow = new MenuWindow(driver);
    SettingsWindow settingsWindow = new SettingsWindow(driver);
    InterfaceWindow interfaceWindow = new InterfaceWindow(driver);
    boolean result, newResult, oldResult;
    String minValue, maxValue, medValue, oldValue, newValue;

    @BeforeEach
    public void clickOnMenuButton() {
        topPanel.waitOpenTopPanel();
        topPanel.clickOnMainMenuButton();
        menuWindow.waitOpenMenuWindow();
        menuWindow.clickOnSettingsButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnInterfaceButton();
        interfaceWindow.waitOpenInterfaceWindow();
    }

    @AfterEach
    public void closeMenu() throws InterruptedException {
        interfaceWindow.clickOnGoBackButton();
        settingsWindow.waitOpenSettingsWindow();
        settingsWindow.clickOnGoBackButton();
        menuWindow.waitOpenMenuWindow();
        menuWindow.clickOnXButton();
        topPanel.waitOpenTopPanel();
        Thread.sleep(600);
    }


    @Test
    @DisplayName("Открылось окно настроек интерфейса")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-673")
    public void openInterfaceWindowTest() {
        result = interfaceWindow.interfaceWindowIsOpen();
        assertTrue(result);
    }

    @Test
    @DisplayName("Смена языка")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-661")
    public void changeLanguageInterfaceWindowTest() {
        interfaceWindow.selectLanguageEnglish();
        newValue = interfaceWindow.systemLanguageIs();
        interfaceWindow.selectLanguageRussian();
        oldValue = interfaceWindow.systemLanguageIs();
        assertEquals("English (US)", newValue);
        assertEquals("Русский", oldValue);
    }

    @Test
    @DisplayName("Сменить сторону интерфейса")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-662")
    public void changeInterfaceSideInterfaceWindowTest() {
        interfaceWindow.selectInterfaceSideLeft();
        newValue = interfaceWindow.interfaceSideIs();
        interfaceWindow.selectInterfaceSideRight();
        oldValue = interfaceWindow.interfaceSideIs();
        assertEquals("Левая", newValue);
        assertEquals("Правая", oldValue);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать видовой куб»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-663")
    public void showViewCubeInterfaceWindowTest() {
        oldResult = interfaceWindow.showViewCubeToggleButtonIsEnabled();
        interfaceWindow.clickOnShowViewCubeToggleButton();
        newResult = interfaceWindow.showViewCubeToggleButtonIsEnabled();
        interfaceWindow.clickOnShowViewCubeToggleButton();
        //todo еще нужно проверять включение видового куба на сцене
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать миникарту»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-664")
    public void showMinimapInterfaceWindowTest() {
        oldResult = interfaceWindow.showMinimapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMinimapToggleButton();
        newResult = interfaceWindow.showMinimapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMinimapToggleButton();
        //todo еще нужно проверять включение миникарты на сцене
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать местоположение на карте»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-665")
    public void showLocationOnTheMapInterfaceWindowTest() {
        oldResult = interfaceWindow.showLocationOnTheMapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowLocationOnTheMapToggleButton();
        newResult = interfaceWindow.showLocationOnTheMapToggleButtonIsEnabled();
        interfaceWindow.clickOnShowLocationOnTheMapToggleButton();
        //todo еще нужно проверять включение на сцене при этом Включить переключатель "Показывать миникарту"
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Показывать кнопку панели карт»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-650")
    public void showMapPaneButtonInterfaceWindowTest() {
        oldResult = interfaceWindow.showShowMapPaneButtonToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMapPaneButtonToggleButton();
        newResult = interfaceWindow.showShowMapPaneButtonToggleButtonIsEnabled();
        interfaceWindow.clickOnShowMapPaneButtonToggleButton();
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Прилипание рулетки к углам модели»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-667")
    public void stickingTapeMeasureToCornersOfModelInterfaceWindowTest() {
        oldResult = interfaceWindow.stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled();
        interfaceWindow.clickOnStickingTapeMeasureToCornersOfModelToggleButton();
        newResult = interfaceWindow.stickingTapeMeasureToCornersOfModelToggleButtonIsEnabled();
        interfaceWindow.clickOnStickingTapeMeasureToCornersOfModelToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями тапами не протестить на автотестах.
        assertEquals(oldResult, !newResult);
    }

    @Test
    @DisplayName("Двигать ползунок «Дальность видимости объектов»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-669")
    public void visibilityRangeOfObjectsInterfaceWindowTest() {
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(50);
        medValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(0);
        minValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        interfaceWindow.moveSliderVisibilityRangeOfObjectsSlider(100);
        maxValue = interfaceWindow.readValueOfVisibilityRangeOfObjectsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        assertNotNull(medValue, "Значение не считано");
        assertEquals("2,000 м", minValue, "Значение отличается от ожидаемого");
        assertEquals("100,000 м", maxValue, "Значение отличается от ожидаемого");
    }
    @Test
    @DisplayName("Двигать ползунок «Уровень детализации отрисовки»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-657")
    public void RenderingLevelOfDetailInterfaceWindowTest() {
        interfaceWindow.moveSliderRenderingLevelOfDetail(50);
        medValue = interfaceWindow.readValueRenderingLevelOfDetail();
        interfaceWindow.moveSliderRenderingLevelOfDetail(0);
        minValue = interfaceWindow.readValueRenderingLevelOfDetail();
        interfaceWindow.moveSliderRenderingLevelOfDetail(100);
        maxValue = interfaceWindow.readValueRenderingLevelOfDetail();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        assertEquals("52%", medValue, "Значение отличается от ожидаемого");
        assertEquals("5%", minValue, "Значение отличается от ожидаемого");
        assertEquals("100%", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Двигать ползунок «Дальняя отсекающая плоскость»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-658")
    public void farClippingPlaneInterfaceWindowTest() {
        interfaceWindow.moveSliderFarClippingPlane(50);
        medValue = interfaceWindow.readValueFarClippingPlane();
        interfaceWindow.moveSliderFarClippingPlane(0);
        minValue = interfaceWindow.readValueFarClippingPlane();
        interfaceWindow.moveSliderFarClippingPlane(100);
        maxValue = interfaceWindow.readValueFarClippingPlane();
        //по этому тесты можно только проверить движение ползунка,
        // режим сцены не протестить на автотестах.
        assertNotNull(medValue, "Значение не считано");
        assertEquals("20,0 м", minValue, "Значение отличается от ожидаемого");
        assertEquals("10000,0 м", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Отображать метки задач, находящихся вне поля зрения»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-670")
    public void displayTaskOutOfSightInterfaceWindowTest() {
        oldResult = interfaceWindow.displayTaskOutOfSightToggleButtonIsEnabled();
        interfaceWindow.clickOnDisplayTaskOutOfSightToggleButton();
        newResult = interfaceWindow.displayTaskOutOfSightToggleButtonIsEnabled();
        interfaceWindow.clickOnDisplayTaskOutOfSightToggleButton();
        assertEquals(oldResult, !newResult);
        // todo рассмотреть возможность проверки работы этого переключателя с помощью модели
    }

    @Test
    @DisplayName("Двигать ползунок «Максимальная дальность отрисовки меток задач»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-671")
    public void maximumRenderingDistanceLabelsInterfaceWindowTest() {
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(50);
        medValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(0);
        minValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        interfaceWindow.moveSliderMaximumRenderingDistanceLabels(100);
        maxValue = interfaceWindow.readValueOfMaximumRenderingDistanceLabelsField();
        //по этому тесты можно только проверить движение ползунка,
        // режим камеры не протестить на автотестах.
        assertNotNull(medValue, "Значение не считано");
        assertEquals("1,0 м", minValue, "Значение отличается от ожидаемого");
        assertEquals("100,0 м", maxValue, "Значение отличается от ожидаемого");
    }

    @Test
    @DisplayName("Включить и выключить переключатель «Использовать ограничение дальности " +
            "отрисовки меток задач на виде модели»")
    @Link(name = "Ссылка на тест-кейс", url = "https://app.qase.io/case/MRS-672")
    public void useDrawDistanceLimitForTaskLabelsInModelViewInterfaceWindowTest() {
        oldResult = interfaceWindow.useDrawDistanceToggleButtonIsEnabled();
        interfaceWindow.clickOnUseDrawDistanceToggleButton();
        newResult = interfaceWindow.useDrawDistanceToggleButtonIsEnabled();
        interfaceWindow.clickOnUseDrawDistanceToggleButton();
        //по этому тесты можно только проверить вкл/выкл переключателя,
        // режим работы с моделями пока не протестить на автотестах.
        assertEquals(oldResult, !newResult);
    }
}
