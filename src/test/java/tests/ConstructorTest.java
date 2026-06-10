package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BurgerConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    private BurgerConstructorPage constructorPage;

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void switchToBunsSectionTest() {
        constructorPage = new BurgerConstructorPage(driver);
        constructorPage.clickSaucesTab();
        constructorPage.clickBunsTab();
        assertTrue(constructorPage.isBunsSectionDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void switchToSaucesSectionTest() {
        constructorPage = new BurgerConstructorPage(driver);
        constructorPage.clickSaucesTab();
        assertTrue(constructorPage.isSaucesSectionDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void switchToFillingsSectionTest() {
        constructorPage = new BurgerConstructorPage(driver);
        constructorPage.clickFillingsTab();
        assertTrue(constructorPage.isFillingsSectionDisplayed());
    }
}