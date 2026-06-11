package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@name='name' and @type='text']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='Пароль']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginLink;

    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    private WebElement errorPasswordMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение имени: {name}")
    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    @Step("Заполнение email: {email}")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Заполнение пароля")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Регистрация пользователя: {name}, {email}")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Клик по ссылке 'Войти'")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Проверка отображения сообщения об ошибке пароля")
    public boolean isErrorPasswordDisplayed() {
        return errorPasswordMessage.isDisplayed();
    }
}
