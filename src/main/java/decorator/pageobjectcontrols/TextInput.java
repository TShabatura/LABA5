package decorator.pageobjectcontrols;

import decorator.AbstractElement;
import org.openqa.selenium.WebElement;

public class TextInput extends AbstractElement {
    public TextInput(WebElement element) {
        super(element);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        element.clear();
        element.sendKeys(charSequences);
    }
}
