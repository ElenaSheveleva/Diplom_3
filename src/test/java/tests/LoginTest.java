package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private PasswordResetPage passwordResetPage;
    private String email;
    private String password = "password123";

    @Before
    public void createUser() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        passwordResetPage = new PasswordResetPage(driver);

        email = "user_" + System.currentTimeMillis() + "@yandex.ru";
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage.register("TestUser", email, password);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти» на главной")
    public void loginViaMainButtonTest() {
        mainPage.clickLoginButton();
        loginPage.login(email, password);
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginViaProfileButtonTest() {
        mainPage.clickProfileButton();
        loginPage.login(email, password);
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginViaRegisterFormTest() {
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage.clickLoginLink();
        loginPage.login(email, password);
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginViaPasswordResetFormTest() {
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
        passwordResetPage.clickLoginLink();
        loginPage.login(email, password);
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }
}