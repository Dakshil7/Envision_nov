//package reusables;
//
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Set;
//
//public class BasePage1 {
//    public static WebDriver driver;
//    public static BasePage using (WebDriver driver){
//        BasePage.driver = driver;
//        return new BasePage();
//    }
//
//    public  <T> T goTo(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        try {
//            return clazz.newInstance();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void switchToWindow(int index, WebDriver driver) throws Exception {
//        try {
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(index));
//            Reporter.logPassedMessage("Switched successfully to the window");
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            Reporter.logFailedMessage("Unable to switch to the window");
//            throw e;
//        }
//    }
//
//    public static void switchToLastWindow(WebDriver driver){
//        try {
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(windows.size()-1));
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            throw e;
//        }
//    }
//
//    public static void switchToSecondLastWindow(WebDriver driver){
//        try{
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(windows.size()-2));
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            throw e;
//        }
//    }
//
//    public static void switchToSecondWindow(WebDriver driver){
//        try{
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(1));
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            throw e;
//        }
//    }
//
//    public static void switchToThirdWindow(WebDriver driver){
//        try{
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(2));
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            throw e;
//        }
//    }
//
//    public static void switchToOriginalWindow(WebDriver driver){
//        try{
//            Set<String> sessionIDs = driver.getWindowHandles();
//            ArrayList<String> windows = new ArrayList<>(sessionIDs);
//            driver.switchTo().window(windows.get(0));
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Window");
//            throw e;
//        }
//    }
//
//    public static void switchToAlertAndAccept(WebDriver driver){
//        try {
//            driver.switchTo().alert().accept();
//        }catch(Exception e){
//            System.out.println("Unable to switch to alert and Accept");
//            throw e;
//        }
//    }
//
//    public static void switchToAlertAndDismiss(WebDriver driver){
//        try {
//            driver.switchTo().alert().dismiss();
//        }catch(Exception e){
//            System.out.println("Unable to switch to alert and Dismiss");
//            throw e;
//        }
//    }
//
//    public static void switchToAlertAndSendValues(String textValue,WebDriver driver){
//        try {
//            Alert alert = driver.switchTo().alert();
//            alert.sendKeys(textValue);
//            alert.accept();
//        }catch(Exception e){
//            System.out.println("Unable to switch to alert and Dismiss");
//            throw e;
//        }
//    }
//
//    public static void switchToFrames(String frame , WebDriver driver){
//        try {
//            driver.switchTo().frame(frame);
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Frame");
//            throw e;
//        }
//    }
//
//    public static void switchToFrames(WebElement element, WebDriver driver){
//        try {
//            driver.switchTo().frame(element);
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Frame");
//            throw e;
//        }
//    }
//
//    public static void switchToMainPageFromPage(WebDriver driver){
//        try{
//            driver.switchTo().defaultContent();
//        } catch (Exception e){
//            System.out.println("Unable to Switch to Targeted Frame");
//            throw e;
//        }
//    }
//
//    public static void scrollDown(WebDriver driver){
//        try {
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//        }catch (Exception e){
//            System.out.println("Unable to scroll");
//        }
//    }
//
//    public static void scrollUp(WebDriver driver){
//        try{
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
//        }catch (Exception e){
//            System.out.println("Unable to scroll");
//        }
//    }
//
//    public static void scrollToElement(WebDriver driver,WebElement element){
//        try{
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("arguments[0].scrollIntoView(true);", element);
//        }catch (Exception e){
//            System.out.println("Unable to scroll");
//        }
//    }
//
//    public static void selectBy(WebDriver driver, WebElement element, String mode, String value) throws Exception {
//
//        Select ddList = new Select(element);
//        try {
//            if (mode.equalsIgnoreCase("value")) {
//                ddList.deselectByValue(value);
//            } else if (mode.equalsIgnoreCase("index")) {
//                ddList.deselectByIndex(Integer.parseInt(value));
//            } else if (mode.equalsIgnoreCase("text")) {
//                ddList.selectByVisibleText(value);
//            }
//            Reporter.logPassedMessage("Value [" + value + "] selected from the list");
//        }catch (Exception e){
//            Reporter.logFailedMessage("Unable to select value ["+value+"] from the list");
//        }
//    }
//
////    public static WebElement findElement(WebDriver driver,String elementName) throws Exception {
////
////        //Reading properties from OR file and then split it and store those values in 'how' and 'value' to finally put them
////        //in findElementBy by method
////        PropertiesLoader.loadProperties(System.getProperty("user.dir")+"/src/test/resources/ObjectRepository/OR.properties");
////        //String elementFromORFile = PropertiesLoader.getProperties(elementName);
////        //String how = elementFromORFile.split(":")[0];
////        //String value = elementFromORFile.split(":")[1];
////       // WebElement element = findElementBy(driver,how,value);
////       // return element;
////    }
//
//    public static void
//    clickOn(WebDriver driver, String clickOn) throws Exception {
//        try {
//            WebElement element = findElement(driver, clickOn);
//            element.click();
//            Reporter.logPassedMessage("Succesfully clicked on element "+clickOn);
//
//        }catch (Exception e){
//            System.out.println("Unable to Click On " + clickOn);
//            Reporter.logFailedMessage("Unable to click on element "+clickOn);
//
//        }
//    }
//
//    //Making reusable method for Page Factory
//    //Page Factory takes web element directly
//    public static void clickOn(WebElement clickOn) throws Exception {
//        try {
//            clickOn.click();
//            Reporter.logPassedMessage("Succesfully clicked on element");
//        }catch (Exception e){
//            System.out.println("Unable to Click On " + clickOn.toString());
//            Reporter.logFailedMessage("Unable to click on element");
//        }
//    }
//
//    public  static void typeInto(WebDriver driver,String typeInto, String value) throws Exception{
//        try {
//            WebElement element = findElement(driver,typeInto);
//            element.clear();
//            element.click();
//            element.sendKeys(value);
//            Reporter.logPassedMessage("Entered text into "+typeInto+ " Value Entered is = "+value);
//        }catch (Exception e){
//            System.out.println("Unable To Type Into " + typeInto);
//            Reporter.logFailedMessage("Unable to enter text into "+typeInto);
//        }
//    }
//
//    //Making reusable method for Page Factory
//    public  static void typeInto(WebElement element, String value) throws Exception{
//        try {
//            element.clear();
//            element.click();
//            element.sendKeys(value);
//        }catch (Exception e){
//            System.out.println("Unable To Type Value " + value);
//        }
//    }
//
//    public static boolean isDisplayed(WebDriver driver, String elementToCheck) throws Exception {
//        try {
//            WebElement element = findElement(driver, elementToCheck);
//            return element.isDisplayed();
//        }catch (Exception e){
//            System.out.println("Unable To Check Element " + elementToCheck);
//            Reporter.logFailedMessage("Element is not displayed: element= "+elementToCheck);
//            return false;
//        }
//    }
//
//
//    //Making Reusable Method for Page Factory
//    public static boolean isDisplayed(WebElement elementToCheck) throws Exception {
//        try {
//            return elementToCheck.isDisplayed();
//        }catch (Exception e){
//            System.out.println("Unable To Check Element " + elementToCheck.toString());
//            return false;
//        }
//    }
//
////    public static String findPropertiesFromUATFile(WebDriver driver,String elementName) throws Exception {
////        PropertiesLoader.loadProperties();
////        //String propertiesFromUATFile = PropertiesLoader.getProperties(elementName);
////       // return propertiesFromUATFile;
////    }
//
//    public static WebElement findElementBy(WebDriver driver,String how,String value) throws Exception {
//        WebElement element = null;
//        WebDriverWait wait = new WebDriverWait(driver,1000);
//        try {
//            switch (how) {
//                case "id":
//                    //tried to use web-driver wait in this line which will wait until the element is visible
//                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
//                    //now this line itself is capable to find element so we dont need to find element separately
//                    //element = driver.findElement(By.id(value));
//                    break;
//                case "name":
//                    element = driver.findElement(By.name(value));
//                    break;
//                case "class":
//                    element = driver.findElement(By.className(value));
//                    break;
//                case "xpath":
//                    element = driver.findElement(By.xpath(value));
//                    break;
//                case "css":
//                    element = driver.findElement(By.cssSelector(value));
//                    break;
//                case "tag":
//                    element = driver.findElement(By.tagName(value));
//                    break;
//                case "lt":
//                    element = driver.findElement(By.linkText(value));
//                    break;
//                case "plt":
//                    element = driver.findElement(By.partialLinkText(value));
//                    break;
//                default:
//                    throw new Exception("Invalid Locator Type Provided");
//
//            }
//            Reporter.logPassedMessage("Element ["+how+"-"+value+"] found on the webpage");
//        }catch (Exception e){
//            System.out.println("Element Not Found , Full Exception Details : " + e);
//            Reporter.logFailedMessage("Element ["+how+"-"+value+"] not found on the webpage");
//        }return element;
//    }
//
//    public static void stringToInt(String value){
//        try {
//            int in = Integer.parseInt(value);
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static String captureSnapshot() throws Exception {
//        try {
//            ThreadLocal<String> base64 = new ThreadLocal<String>();
//            System.out.println("before driver");
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            String snapshotFile = "data:image/png;base64,"
//                    + screenshot.getScreenshotAs(OutputType.BASE64);
//            System.out.println("snapshot: " + snapshotFile);
//            base64.set(snapshotFile);
//            return base64.get();
//        } catch (Exception e) {
//            ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to capture screenshot" + e.getMessage() + ":" + e.getCause() + "</b></p>");
//        }
//        return null;
//    }
//}