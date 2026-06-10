package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public PasswordResetPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}