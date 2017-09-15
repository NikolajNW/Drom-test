package support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

    private static File file;
    private static FileInputStream fileInput;
    private static Properties properties;

    static {
        final String propertyFile = System.getProperty("user.dir")
                + "\\config.properties";
        file = new File(propertyFile);
        fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String property(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
