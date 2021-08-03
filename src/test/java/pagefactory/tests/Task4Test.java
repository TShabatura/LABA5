package pagefactory.tests;

import model.RozetkaFilter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.XmlToObject;

import java.util.*;
import java.util.stream.Stream;

public class Task4Test extends BaseTest {
    @DataProvider(name = "rozetkaFilters", parallel = true)
    public Iterator<Object[]> rozetkaFilters(){
        List<RozetkaFilter> rozetkaFilters = new XmlToObject().inputData();
        return Stream.of(
                new Object[]{rozetkaFilters.get(0)},
                new Object[]{rozetkaFilters.get(1)},
                new Object[]{rozetkaFilters.get(2)},
                new Object[]{rozetkaFilters.get(3)},
                new Object[]{rozetkaFilters.get(4)}
        ).iterator();
    }
    @Test(dataProvider = "rozetkaFilters")
    public void task4Test(RozetkaFilter rozetkaFilter){
        getHomePage().inputSearchData(rozetkaFilter.getGroupOfThings());
        getNotebookPage().waitForPageLoadingComplete(60);
        getNotebookPage().searchByProducer(rozetkaFilter.getProducer());
        getNotebookPage().waitForFiltering(60, By.xpath("//div[@data-filter-name='producer']//label"));
        getNotebookPage().filterByProducer();
        getNotebookPage().waitForPageLoadingComplete(60);
        getNotebookPage().clickAddToCartButton();
        getNotebookPage().clickCartButton();
        getNotebookPage().waitForVisibilityOfElement(60, getNotebookPage().getPopup());
        Assert.assertTrue(getCartPopup().getPrice().compareTo(rozetkaFilter.getTotalAmount()) < 0);
    }
}
