package reusables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties propertiesObj;
    private static boolean RunMaximize;
    private static String Browser;
    private static String RunOn;
    private static boolean CaptureScreenshots;
    private static String CaptureScreenshotFor;
    private static int ShortWait;
    private static int MediumWait;
    private static int LongWait;
    private static String ApplicationURL;
    private static String Environment;


    public static String getBrowserName() {
        return Browser;
    }

    public static String getRunOn() {
        return RunOn;
    }

    public static boolean isCaptureScreenshots() {
        return CaptureScreenshots;
    }

    public static String getCaptureScreenshotFor() {
        return CaptureScreenshotFor;
    }

    public static int getShortWait() {
        return ShortWait;
    }

    public static int getMediumWait() {
        return MediumWait;
    }

    public static int getLongWait() {
        return LongWait;
    }

    public static String getApplicationUrl() {
        return ApplicationURL;
    }

    public static void loadProperties(String fullFilePath) throws FileNotFoundException {
        try {
            propertiesObj = new Properties();
            propertiesObj.load(
                    new FileInputStream(
                            new File(fullFilePath)));
        } catch (Exception e) {
            System.out.println("Unable to read property file. Pls check the location of file");
        }
    }


    public static void loadProperties() throws FileNotFoundException {
        try {
            propertiesObj = new Properties();
            propertiesObj.load(
                    new FileInputStream(
                            new File(
                                    System.getProperty("user.dir") +
                                            "/src/test/resources/Configs/" +System.getProperty("Environment").toLowerCase()+
                                            "-Config.properties")));
        } catch (Exception e) {
            System.out.println("Unable to read property file. Pls check the location of file");
        }
    }

    public static String getProperty(String propertyName) {
        return propertiesObj.getProperty(propertyName);
    }

    public static boolean isRunMaximize() {
        return RunMaximize;
    }


    public static void initializeConfigurations() throws FileNotFoundException {
        if (System.getProperty("Environment") == null || System.getProperty("Environment").isEmpty()) {
            setEnvironment("uat");
        } else {
            setEnvironment(System.getProperty("Environment"));
        }


        loadProperties();
        Browser = getProperty("Browser");
        RunOn = getProperty("RunOn");
        CaptureScreenshots = Boolean.parseBoolean(getProperty("CaptureScreenshots"));
        CaptureScreenshotFor = getProperty("CaptureScreenshotFor");
        ShortWait = Integer.parseInt(getProperty("ShortWait"));
        MediumWait = Integer.parseInt(getProperty("MediumWait"));
        LongWait = Integer.parseInt(getProperty("LongWait"));
        ApplicationURL = getProperty("ApplicationURL");
        RunMaximize = Boolean.parseBoolean(getProperty("RunMaximize"));
    }

//    public static String getEnvironment() {
//        return Environment;
//    }

    public static void setEnvironment(String environment) {
        Environment = environment;
    }

    public static void main(String[] args) throws FileNotFoundException {
        PropertiesLoader.initializeConfigurations();
        System.out.println(PropertiesLoader.getCaptureScreenshotFor());
    }
}