package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement profileButton;

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement constructorHeader;

    public MainPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Клик по кнопке 'Войти' на главной странице")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        try {
            loginButton.click();
        } catch (ElementClickInterceptedException e) {
            driver.navigate().refresh();
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        }
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickProfileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton)).click();
    }

    @Step("Проверка отображения заголовка конструктора")
    public boolean isConstructorHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(constructorHeader)).isDisplayed();
    }
}