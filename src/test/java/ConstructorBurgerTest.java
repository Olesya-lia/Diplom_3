import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorBurgerTest extends BaseTest {

    @Test
    @DisplayName("Конструктор булки")
    @Description("Проверка перехода в раздел булки")
    public void constructorBunTest(){
        mainPage.clickTabSauces();
        mainPage.clickTabBun();
        assertTrue(mainPage.isVisibilityConstructorSelection(mainPage.getChoiceBun()));
    }

    @Test
    @DisplayName("Конструктор соусы")
    @Description("Проверка перехода в раздел соусы")
    public void constructorSaucesTest(){
        mainPage.clickTabSauces();
        assertTrue(mainPage.isVisibilityConstructorSelection(mainPage.getChoiceSauces()));
    }

    @Test
    @DisplayName("Конструктор начинки")
    @Description("Проверка перехода в раздел начинки")
    public void constructorToppingsTest(){
        mainPage.clickTabFillings();
        assertTrue(mainPage.isVisibilityConstructorSelection(mainPage.getChoiceFillings()));
    }
}
