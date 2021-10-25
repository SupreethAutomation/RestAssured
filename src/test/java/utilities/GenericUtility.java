package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GenericUtility {
    public static String getConfigData(String key) {
        Properties objProperties = new Properties();
        FileReader objFileReader = null;
        try {
            objFileReader = new FileReader(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator + "config.properties"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            objProperties.load(objFileReader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (String) objProperties.get(key);
    }

    public static String getRandomInputText() {
        String randownText = "Test" + (int) (Math.random() * 999999) + (int) (Math.random() * 999999) + "Test";
        return randownText;
    }

}
