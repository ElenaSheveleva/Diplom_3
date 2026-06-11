package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @Step("Клик по вкладке 'Булки'")
    public void clickBunsTab() {
        bunsTab.click();
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSaucesTab() {
        saucesTab.click();
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickFillingsTab() {
        fillingsTab.click();
    }

    @Step("Проверка отображения раздела 'Булки'")
    public boolean isBunsSectionDisplayed() {
        return bunsSection.isDisplayed();
    }

    @Step("Проверка отображения раздела 'Соусы'")
    public boolean isSaucesSectionDisplayed() {
        return saucesSection.isDisplayed();
    }

    @Step("Проверка отображения раздела 'Начинки'")
    public boolean isFillingsSectionDisplayed() {
        return fillingsSection.isDisplayed();
    }
}