package tests;

import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private UserClient userClient;
    private String email;
    private String password = "password123";
    private String accessToken;

    @After
    public void deleteUserViaApi() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistrationTest() {
        driver.get("https://stellarburgers.education-services.ru/register");

        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        userClient = new UserClient();

        email = "user_" + System.currentTimeMillis() + "@yandex.ru";
        registerPage.register("TestUser", email, password);

        driver.get("https://stellarburgers.education-services.ru/login");

        loginPage.login(email, password);

        driver.get("https://stellarburgers.education-services.ru/");
        mainPage = new MainPage(driver);

        assertTrue(mainPage.isConstructorHeaderDisplayed());

        User user = new User(email, password, "TestUser");
        Response response = userClient.register(user);
        accessToken = response.jsonPath().getString("accessToken");
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