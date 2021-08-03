package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    Properties property = new Properties();

    public PropertiesReader(){
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            property.load(fileInputStream);
            fileInputStream.close();
        }   catch (IOException e){
            System.err.println("ERROR: Properties file doesn`t exist!");
        }
    }

    public String getUrl(){
        String URL = property.getProperty("URL");
        return URL;
    }

    public String getDriverName(){
        String driverName = property.getProperty("CHROME_DRIVER_NAME");
        return driverName;
    }

    public String getDriverLocation(){
        String driverLocation = property.getProperty("CHROME_DRIVER_LOCATION");
        return driverLocation;
    }
}
