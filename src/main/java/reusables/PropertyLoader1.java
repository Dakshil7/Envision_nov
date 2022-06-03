//package reusables;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Properties;
//
//public class PropertiesLoader1 {
//
//    static Properties PropertiesObj;
//    private static  String Browser;
//    private static  String RunOn;
//    private static  boolean CaptureScreenshots;
//    private static  String CaptureScreenshotsFor;
//    private static Properties propertiesObj;
//    private static boolean RunMaximize;
//    private static int ShortWait;
//    private static int MediumWait;
//    private static int LongWait;
//    private static String ApplicationURL;
//    private static String Environment;
//
//    public static String getBrowserName(){
//        return Browser;
//    }
//
//    public static String getRunOn(){
//        return RunOn;
//    }
//
//    public static boolean isCaptureScreenshots(){
//        return CaptureScreenshots;
//    }
//    public static String getCaptureScreenshotsFor(){
//        return CaptureScreenshotsFor;
//    }
//
//    public static void loadProperties(String fullFilePath) throws FileNotFoundException {
//        try {
//            PropertiesObj = new Properties();
//            PropertiesObj.load(new FileInputStream(new File(fullFilePath)));
//        }catch (Exception e){
//            System.out.println("Unable to read property file");
//        }
//
//    }
//
//    public static void loadProperties() throws FileNotFoundException {
//        try {
//            PropertiesObj = new Properties();
//            PropertiesObj.load(new FileInputStream(new File(System.getProperty("user.dir") +
//                    "/src/test/resources/Configs/"+System.getProperty("envName").toLowerCase()+"-Config.properties")));
//        }catch (Exception e){
//            System.out.println("Unable to read property file");
//        }
//
//    }
//
//    public static String getProperties(String propertyName){
//        return PropertiesObj.getProperty(propertyName);
//    }
//
//    public static void initializationOfProperties() throws FileNotFoundException {
//        PropertiesLoader.loadProperties();
////        Browser = getProperties(Browser);
////        RunOn = getProperties(RunOn);
////        CaptureScreenshots = Boolean.parseBoolean(getProperties("CaptureScreenshots"));
////        CaptureScreenshotsFor = getProperties("CaptureScreenshotsFor");
//
////        if (System.getProperty("envName") == null || System.getProperty("envName").isEmpty()) {
////            setEnvironment("sit");
////        } else {
////            setEnvironment(System.getProperty("envName"));
////        }
//
//
//        // loadProperties();
//        Browser = getProperties("Browser");
//        RunOn = getProperties("RunOn");
//        CaptureScreenshots = Boolean.parseBoolean(getProperties("CaptureScreenshots"));
//        CaptureScreenshotsFor = getProperties("CaptureScreenshotFor");
//        ShortWait = Integer.parseInt(getProperties("ShortWait"));
//        MediumWait = Integer.parseInt(getProperties("MediumWait"));
//        LongWait = Integer.parseInt(getProperties("LongWait"));
//        ApplicationURL = getProperties("ApplicationURL");
//        RunMaximize = Boolean.parseBoolean(getProperties("RunMaximize"));
//    }
//
//
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        PropertiesLoader.loadProperties();
//        //PropertiesLoader.getProperties("Browser");
//    }
//}
