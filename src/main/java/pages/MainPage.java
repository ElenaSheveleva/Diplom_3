package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButtonMain;

    @FindBy(xpath = "//p[text()='Личный Кабинет']")
    private WebElement profileButton;

    @FindBy(xpath = "//h1[text()='Соберите бургер']")
    private WebElement constructorHeader;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        loginButtonMain.click();
    }

    public void clickProfileButton() {
        profileButton.click();
    }

    public boolean isConstructorHeaderDisplayed() {
        return constructorHeader.isDisplayed();
    }
}