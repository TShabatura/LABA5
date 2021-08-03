package decorator.pageobjectcontrols;

import decorator.AbstractElement;
import org.openqa.selenium.WebElement;

public class Checkbox extends AbstractElement {
    public Checkbox(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        element.click();
    }

    public void setChecked(){
        if(!element.isSelected()){
            element.click();
        }else {
            System.out.println("Element is already checked");
        }
    }
}
