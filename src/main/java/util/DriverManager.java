package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static ThreadLocal<WebDriver> driverPool = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        if(Objects.isNull(driverPool.get())){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(new PropertiesReader().getUrl());
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driverPool.set(driver);
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        driverPool.get().quit();
        driverPool.set(null);
    }
}
