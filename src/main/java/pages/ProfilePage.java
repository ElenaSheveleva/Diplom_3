package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickLogoutButton() {
        logoutButton.click();
    }

    @Step("Проверка отображения кнопки 'Выход'")
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }
}