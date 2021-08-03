package decorator.pageobjectcontrols;

import decorator.AbstractElement;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class PriceLabel extends AbstractElement {
    public PriceLabel(WebElement element) {
        super(element);
    }

    public BigDecimal getPrice(){
        return new BigDecimal(element.getText());
    }
}
