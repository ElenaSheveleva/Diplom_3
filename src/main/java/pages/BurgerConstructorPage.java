package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BurgerConstructorPage extends BasePage {

    @FindBy(xpath = "//span[text()='Булки']")
    private WebElement bunsTab;

    @FindBy(xpath = "//span[text()='Соусы']")
    private WebElement saucesTab;

    @FindBy(xpath = "//span[text()='Начинки']")
    private WebElement fillingsTab;

    @FindBy(xpath = "//h2[text()='Булки']")
    private WebElement bunsSection;

    @FindBy(xpath = "//h2[text()='Соусы']")
    private WebElement saucesSection;

    @FindBy(xpath = "//h2[text()='Начинки']")
    private WebElement fillingsSection;

    public BurgerConstructorPage(WebDriver driver) {
        super(driver);
    }

    public void clickBunsTab() {
        bunsTab.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(bunsSection));
    }

    public void clickSaucesTab() {
        saucesTab.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(saucesSection));
    }

    public void clickFillingsTab() {
        fillingsTab.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(fillingsSection));
    }

    public boolean isBunsSectionDisplayed() {
        return bunsSection.isDisplayed();
    }

    public boolean isSaucesSectionDisplayed() {
        return saucesSection.isDisplayed();
    }

    public boolean isFillingsSectionDisplayed() {
        return fillingsSection.isDisplayed();
    }
}