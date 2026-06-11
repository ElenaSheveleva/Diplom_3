package tests;

import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    public void createUserViaApi() {
        userClient = new UserClient();
        String email = "user_" + System.currentTimeMillis() + "@yandex.ru";
        String password = "password123";
        String name = "TestUser";
        user = new User(email, password, name);

        Response response = userClient.register(user);
        accessToken = response.jsonPath().getString("accessToken");

        driver.get("https://stellarburgers.education-services.ru/");

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @After
    public void deleteUserViaApi() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти» на главной")
    public void loginViaMainButtonTest() {
        driver.navigate().refresh();
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginViaProfileButtonTest() {
        mainPage.clickProfileButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginViaRegisterFormTest() {
        driver.get("https://stellarburgers.education-services.ru/register");
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginViaPasswordResetFormTest() {
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isConstructorHeaderDisplayed());
    }
}