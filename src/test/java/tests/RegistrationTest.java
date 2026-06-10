package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistrationTest() {
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage = new RegisterPage(driver);

        String uniqueEmail = "user_" + System.currentTimeMillis() + "@yandex.ru";
        registerPage.registerAndWait("TestUser", uniqueEmail, "password123");

        loginPage = new LoginPage(driver);
        loginPage.login(uniqueEmail, "password123");

        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Ошибка для пароля менее 6 символов")
    public void registrationWithShortPasswordTest() {
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage = new RegisterPage(driver);

        registerPage.register("TestUser", "test@yandex.ru", "12345");

        assertTrue(registerPage.isErrorPasswordDisplayed());
    }
}