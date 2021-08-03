package decorator.pageobjectcontrols;

import decorator.AbstractElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverManager;

public class Button extends AbstractElement {

    public Button(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        if (element.isDisplayed()) {
            element.click();
        } else {
            new WebDriverWait(DriverManager.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }
}
