package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//button[text()='Выход']")
    private WebElement logoutButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}
