package pagefactory;

import decorator.pageobjectcontrols.Button;
import decorator.CustomFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    @FindBy(xpath = "//button[@opencart]")
    private Button cartButton;

    @FindBy(xpath = "//div[@class = 'modal__content']")
    private WebElement popup;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitForPageLoadingComplete(long timeToWait){
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForVisibilityOfElement(long timeToWait, WebElement element){
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityOfElement(long timeToWait, WebElement element){
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickCartButton(){
        cartButton.click();
    }

    public WebElement getPopup(){
        return popup;
    }
}
