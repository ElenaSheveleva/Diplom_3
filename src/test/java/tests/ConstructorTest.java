package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.BurgerConstructorPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    private BurgerConstructorPage constructorPage;

    @Before
    public void setUpConstructor() {
        constructorPage = new BurgerConstructorPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    public void switchToBunsSectionTest() {
        constructorPage.clickSaucesTab();
        constructorPage.clickBunsTab();
        assertTrue(constructorPage.isBunsSectionDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    public void switchToSaucesSectionTest() {
        constructorPage.clickSaucesTab();
        assertTrue(constructorPage.isSaucesSectionDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    public void switchToFillingsSectionTest() {
        constructorPage.clickFillingsTab();
        assertTrue(constructorPage.isFillingsSectionDisplayed());
    }
}