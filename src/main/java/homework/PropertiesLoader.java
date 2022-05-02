package homework;


import java.io.FileReader;
import java.util.Properties;

public class PropertiesLoader {

    static FileReader fileReader;
    static Properties prop = new Properties();

    static {
        try {
            fileReader = new FileReader("src/main/resources/app.properties");
            prop.load(fileReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}
