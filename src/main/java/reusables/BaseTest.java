package reusables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest implements ITestListener {



    public static WebDriver driver;




    public WebDriver launchBrowser(String browserType) throws Exception {
        WebDriver driver = null;
        if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", EnvironmentConstants.ChromeBinaryPath);
            driver = new ChromeDriver(); // launches chrome

//        } else if (browserType.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", EnvironmentConstants.FirefoxBinaryPath);
//            driver = new FirefoxDriver(); //launch firefox
        } else if (browserType.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", EnvironmentConstants.MsEdgeBinaryPath);
            driver = new EdgeDriver(); //launch edge
//        } else if (browserType.equalsIgnoreCase("IE")) {
//            System.setProperty("webdriver.ie.driver", EnvironmentConstants.InternetExplorerBinaryPath);
//            driver = new InternetExplorerDriver(); //launch ie
        } else {
            System.setProperty("webdriver.chrome.driver", EnvironmentConstants.ChromeBinaryPath);
            driver = new ChromeDriver(); // launches chrome
        }
        driver.manage().timeouts().pageLoadTimeout(PropertiesLoader.getLongWait(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(PropertiesLoader.getLongWait(), TimeUnit.SECONDS);
        if (PropertiesLoader.isRunMaximize()) {
            driver.manage().window().maximize();
        }

        return driver;
    }

    public void closeCurrentBrowser(WebDriver driver) {
        driver.close();//close current browser
    }

    public void closeAllBrowsers(WebDriver driver) {
        driver.quit(); //closes all browsers
    }


    @BeforeMethod
    public void invokeBrowsers() throws Exception {
        driver = launchBrowser(PropertiesLoader.getBrowserName());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(ITestResult context) throws IOException {
        Reporter.stopTest();
        driver.close();
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result) {
        Reporter.startTest(getTestMethodName(result), result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        try {
            if (PropertiesLoader.getCaptureScreenshotFor().equalsIgnoreCase("Pass"))
                Reporter.takeScreenshot();
            Reporter.logPassedMessage("Test Case Passed");
        } catch (Exception e) {

        }
    }

    public void onTestFailure(ITestResult result) {
        try {
            if (PropertiesLoader.getCaptureScreenshotFor().equalsIgnoreCase("Fail"))
                Reporter.takeScreenshot();
            Reporter.logFailedMessage("Test Case Failed");
        } catch (Exception e) {
        }
    }

    public void onTestSkipped(ITestResult result) {
        Reporter.logSkipStep("Test Skipped Due to unknown reasons");
    }

    public void onFinish(ITestContext context) {
        ExtentReporter.mainReport.flush();
    }

    public void onStart(ITestContext context) {

    }

    public void closeAllBrowser(WebDriver driver) {
        driver.quit();
    }

    @BeforeSuite
    public void beforeAnyThingElse() throws FileNotFoundException {
        PropertiesLoader.initializeConfigurations();
    }







//    @BeforeSuite(alwaysRun = true)
//    public void beforeAnythingElse() throws FileNotFoundException {
//        PropertiesLoader.initializeConfigurations();
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDownBrowser() {
//        driver.close();
//    }
//
//    public void onTestSkipped(ITestResult result) {
//        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
//    }
//
//
//    public void onFinish(ITestContext context) {
//    }
//
//
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//
//    }
//
//    public void onStart(ITestContext context) {
//
//    }
//
//    public void onTestFailure(ITestResult result) {
//        try {
//            if (PropertiesLoader.getCaptureScreenshotFor().equalsIgnoreCase("Fail"))
//                Reporter.takeScreenshot();
//        } catch (Exception e) {
//
//        }
//
//    }
//
//    public void onTestStart(ITestResult result) {
//        ExtentTestManager.startTest(getTestMethodName(result));
//        ExtentTestManager.getTest().setDescription(result.getMethod().getDescription());
//    }
//
//    public void onTestSuccess(ITestResult result) {
//        try {
//            if (PropertiesLoader.getCaptureScreenshotFor().equalsIgnoreCase("Pass"))
//                Reporter.takeScreenshot();
//        } catch (Exception e) {
//
//        }
//    }
//
//    private static String getTestMethodName(ITestResult iTestResult) {
//        return iTestResult.getMethod().getConstructorOrMethod().getName();// ValidateShoppingCart();
//    }
//
//
//    @AfterSuite(alwaysRun = true)
//    public void tearDownEverything() {
//        ExtentManager.getReporter().flush();
//    }
}