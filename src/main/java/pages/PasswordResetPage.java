package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetPage extends BasePage {

    @FindBy(xpath = "//a[text()='Войти']")
    private WebElement loginLink;

    public PasswordResetPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по ссылке 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        loginLink.click();
    }
}