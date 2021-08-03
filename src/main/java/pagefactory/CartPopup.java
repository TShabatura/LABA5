package pagefactory;

import decorator.pageobjectcontrols.PriceLabel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class CartPopup extends BasePage{
    public CartPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']/span")
    private PriceLabel totalAmountOfCart;

    public BigDecimal getPrice(){
        return totalAmountOfCart.getPrice();
    }
}
