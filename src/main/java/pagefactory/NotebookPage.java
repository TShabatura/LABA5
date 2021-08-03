package pagefactory;

import decorator.pageobjectcontrols.Button;
import decorator.pageobjectcontrols.Checkbox;
import decorator.pageobjectcontrols.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotebookPage extends BasePage{
    @FindBy(xpath = "//button[@aria-label='Купити']")
    private Button addToCartButton;

    @FindBy(xpath = "//div[@data-filter-name='producer']//input[@name='searchline']")
    private TextInput producerSearchBox;

    @FindBy(xpath = "//div[@data-filter-name='producer']//label")
    private Checkbox filter;

    public NotebookPage(WebDriver driver){
        super(driver);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void searchByProducer(String producer){
        producerSearchBox.sendKeys(producer, Keys.ENTER);
    }

    public void filterByProducer(){
        filter.click();
    }

    public void waitForFiltering(long timeToWait, By locator) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.numberOfElementsToBe(locator, 1));
    }
}
