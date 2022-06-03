package reusables;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import static reusables.BaseTest.driver;

public class BasePage {

    //static WebDriver driver;



//    public static BasePage using(WebDriver driver) {
//        BasePage.driver = driver;
//        return new BasePage();
//    }


//    //Generics in Java
//    public <T> T goTo(Class<T> clazz) throws InstantiationException, IllegalAccessException {
//        return clazz.newInstance();
//    }


    public static WebElement findElement(WebDriver driver, String elementName) throws Exception {
        PropertiesLoader.loadProperties(
                System.getProperty("user.dir") + "/src/test/resources/ObjectRepository/OR.properties");
        String elementFromOR = PropertiesLoader.getProperty(elementName);
        String how = elementFromOR.split(":")[0];
        String value = elementFromOR.split(":")[1];
        return findElementBy(driver, how, value);
    }

    public static WebElement findElementBy(WebDriver driver, String how, String value) throws Exception {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            switch (how) {
                case "id":
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                    break;
                case "name":
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                    break;
                case "class":
                    element = driver.findElement(By.className(value));
                    break;
                case "xpath":
                    element = driver.findElement(By.xpath(value));
                    break;
                case "lt":
                    element = driver.findElement(By.linkText(value));
                    break;
                case "plt":
                    element = driver.findElement(By.partialLinkText(value));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(value));
                    break;
                case "tag":
                    element = driver.findElement(By.tagName(value));
                    break;
                default:
                    throw new Exception("Invalid Locator type provided");

            }
            Reporter.logPassedMessage("Element[" + how + "-" + value + "] found on the webpage");
        } catch (Exception e) {
            System.out.println("Element not found, Full Exception details: " + e);
            Reporter.logFailedMessage("Element[" + how + "-" + value + "] not found on the webpage");
        }
        return element;
    }

    public static void clickOn(WebDriver driver, String clickOn) throws Exception {
        try {
            WebElement element = findElement(driver, clickOn);
            element.click();
            Reporter.logPassedMessage("Successfully clicked on element: " + clickOn);
        } catch (Exception e) {
            System.out.println("Unable to click on : " + clickOn);
            Reporter.logFailedMessage("Failed to click on element: " + clickOn);
        }
    }

    public static void clickOn(WebElement element) throws Exception {
        try {
            element.click();
            Reporter.logPassedMessage("Successfully clicked on element");
        } catch (Exception e) {
            System.out.println("Unable to click on : " + element.toString());
            Reporter.logFailedMessage("Successfully clicked on element: " + element.toString());
        }
    }

    public static boolean isDisplayed(WebDriver driver, String elementToCheck) throws Exception {
        try {
            WebElement element = findElement(driver, elementToCheck);
            return element.isDisplayed();

        } catch (Exception e) {
            System.out.println("Unable to verify condition \"is displayed \" for element : " + elementToCheck);
            Reporter.logFailedMessage("Element not displayed, element:  " + elementToCheck);
            return false;
        }

    }

    public static boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Unable to verify condition \"is displayed \" for element : " + element.toString());
            return false;
        }

    }


    public static void typeInto(WebDriver driver, String typeInto, String valueToType) throws Exception {
        try {
            WebElement element = findElement(driver, typeInto);
            element.clear();
            element.click();
            element.sendKeys(valueToType);
            Reporter.logPassedMessage("Entered text[" + valueToType + "] into textfield[" + typeInto + "]");

        } catch (Exception e) {
            System.out.println("Unable to type into [ " + typeInto + " ]");
            Reporter.logFailedMessage("Unable to enter text[" + valueToType + "] into textfield[" + typeInto + "]");
        }
    }


    public static void typeInto(WebElement element, String valueToType) throws Exception {
        try {
            element.clear();
            element.click();
            element.sendKeys(valueToType);
        } catch (Exception e) {
            System.out.println("Unable to type value [ " + valueToType + " ]");
        }
    }


    public static void switchToWindow(int index, WebDriver driver) throws Exception {
        try {
            Set<String> sessionIDs = driver.getWindowHandles();//Step 1 get session iDs
            ArrayList<String> windows = new ArrayList<>(sessionIDs); //step 2 convert set into arraylist
            driver.switchTo().window(windows.get(index));
            Reporter.logPassedMessage("Switched successfully to the window");
        } catch (Exception e) {
            System.out.println("Unable to switch to Window");
            Reporter.logFailedMessage("Unable to switch to Window");
            throw e;
        }

    }

    public static void switchToLastWindow(WebDriver driver) {
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(driver.getWindowHandles().size() - 1));
        } catch (Exception e) {
            System.out.println("Unable to switch to Window");
            throw e;
        }

    }

    public static void switchToOriginalWindow(WebDriver driver) {
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(0));
        } catch (Exception e) {
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }


    public static void switchToSecondLastWindow(WebDriver driver) {
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(driver.getWindowHandles().size() - 2));
        } catch (Exception e) {
            System.out.println("Unable to switch to Window");
            throw e;
        }

    }


    public static void switchToSecondWindow(WebDriver driver) {
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(1));
        } catch (
                Exception e) {
            System.out.println("Unable to switch to Window");
            throw e;
        }

    }

    public static void switchToThirdWindow(WebDriver driver) {
        try {
            driver.switchTo().window(
                    new ArrayList<String>(driver.getWindowHandles())
                            .get(2));
        } catch (Exception e) {
            System.out.println("Unable to switch to Window");
            throw e;
        }
    }

    public static void switchToAlertAndAccept(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Unable to switch to Alert");
            throw e;
        }

    }

    public static void switchToAlertAndDismiss(WebDriver driver) {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("Unable to switch to Alert and dismiss");
            throw e;
        }

    }

    public static void switchToAlertAndSendValue(WebDriver driver, String text) {
        try {
            driver.switchTo().alert().sendKeys(text);
            switchToAlertAndAccept(driver);
        } catch (Exception e) {
            System.out.println("Unable to switch to Alert and dismiss");
            throw e;
        }

    }

    public static void switchToFrame(String frame, WebDriver driver) {
        try {
            driver.switchTo().frame(frame);
        } catch (Exception e) {
            System.out.println("Unable to switch to Frame");
            throw e;
        }
    }

    public static void switchToFrame(WebElement element, WebDriver driver) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            System.out.println("Unable to switch to Frame");
            throw e;
        }
    }

    public static void switchToMainPageFromFrame(WebDriver driver) {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Unable to switch to Frame");
            throw e;
        }
    }

    public static void scrollDown(WebDriver driver) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }
    }

    public static void scrollUp(WebDriver driver) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }

    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll the page");
            throw e;
        }

    }


    public static void selectBy(WebDriver driver, WebElement element, String mode, String option) throws Exception {
        Select ddlist = new Select(element);
        try {
            if (mode.equalsIgnoreCase("Value")) {
                ddlist.selectByValue(option);

            } else if (mode.equalsIgnoreCase("Text")) {
                ddlist.selectByVisibleText(option);

            } else if (mode.equalsIgnoreCase("Index")) {
                ddlist.selectByIndex(Integer.parseInt(option));
            }
            Reporter.logPassedMessage("Value [" + option + "] selected from the list");
        } catch (Exception e) {
            Reporter.logFailedMessage("Unable to select value[" + option + "] from the dropdown list");
        }
    }

 public static String captureSnapshot() throws Exception {
        try {
//            ThreadLocal<String> base64 = new ThreadLocal<>();
//            System.out.println("before driver");
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            String snapshotFile =
//                    screenshot.getScreenshotAs(OutputType.BASE64);
//            System.out.println("snapshot: " + snapshotFile);
//            base64.set(snapshotFile);
//            return base64.get();

            ThreadLocal<String> str = new ThreadLocal<String>();
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            String screenshotString = "data:image/png;base64," + screenshot.getScreenshotAs(OutputType.BASE64);
            str.set(screenshotString);
            return str.get();
        } catch (Exception e) {
            Reporter.getTest().log(LogStatus.FAIL, "Unable to capture screenshot" + /*e.getMessage() +*/
                    ":" + e.getCause() + "</b></p>");
        }
        return null;
////    }
////     try {
////         ThreadLocal<String> str = new ThreadLocal<String>();
////         TakesScreenshot screenshot = (TakesScreenshot) driver;
////         String screenshotString = /*"data:image/png;base64," + */screenshot.getScreenshotAs(OutputType.BASE64);
////         str.set(screenshotString);
////         return str.get();
////     } catch (WebDriverException e) {
////         ExtentTestManager.getTest().log(LogStatus.FAIL, "unable to capture screenshort" + e.getCause() + "</b></p>");
////     }
////     return null;
// }

//    public static String captureScreenShotAsBase64() throws IOException {
//        try{
//         ThreadLocal<String> base64 = new ThreadLocal<>();
//            System.out.println("before driver");
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            String snapshotFile =
//                    screenshot.getScreenshotAs(OutputType.BASE64);
//            System.out.println("snapshot: " + snapshotFile);
//            base64.set(snapshotFile);
//            return base64.get();
//
//
////            ThreadLocal<String> str = new ThreadLocal<String>();
////            TakesScreenshot screenshot = (TakesScreenshot) driver;
////            String screenshotString = /*"data:image/png;base64," + */screenshot.getScreenshotAs(OutputType.BASE64);
////            str.set(screenshotString);
////            return str.get();
//        } catch (Exception e) {
//            ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to capture screenshot" + e.getMessage() +
//                    ":" + e.getCause() + "</b></p>");
//        }
//        return null;
//    }
}}



