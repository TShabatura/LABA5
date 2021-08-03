package pagefactory;

import decorator.pageobjectcontrols.TextInput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//input[@name='search']")
    private TextInput searchBox;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void inputSearchData(String input){
        searchBox.sendKeys(input, Keys.ENTER);
    }
}
