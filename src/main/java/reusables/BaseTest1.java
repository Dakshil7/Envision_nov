//package reusables;
//
//import com.relevantcodes.extentreports.LogStatus;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import java.io.FileNotFoundException;
//import java.sql.DriverManager;
//import java.util.concurrent.TimeUnit;
//
//public class BaseTest1 implements ITestListener {
//    public WebDriver driver;
//    public WebDriver LaunchBrowser(String BrowerType) throws Exception {
//        WebDriver driver = null;
//        if(BrowerType.equalsIgnoreCase("Chrome")){
//            System.setProperty("webdriver.chrome.driver", EnvironmentConstants.ChromeBinaryPath);
//            driver = new ChromeDriver();
//        }else if( BrowerType.equalsIgnoreCase("Edge")){
//            System.setProperty("webdriver.edge.driver", EnvironmentConstants.MsEdgeBinaryPath);
//            driver = new EdgeDriver();
//        }else{
//            throw new Exception("Unsipported browser type");
//        }
//        return driver;
//    }
//
//    public void CloseBrowse(WebDriver driver){
//        driver.close();
//    }
//
//    public void QuitBrowser(WebDriver driver){
//        driver.quit();
//    }
//
//    @BeforeMethod
//    public void invokeBrowser() throws Exception {
//        //driver = LaunchBrowser(BasePage.findPropertiesFromUATFile(driver,"Browser"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void tearDownBrowser(){
//        driver.close();
//    }
//
//    @BeforeSuite
//    public void beforeAnythingElse() throws FileNotFoundException {
//        //PropertiesLoader.initializationOfProperties();
//        PropertiesLoader.loadProperties();
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
//            //if (PropertiesLoader.getCaptureScreenshotsFor().equalsIgnoreCase("Fail"))
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
//           // if (PropertiesLoader.getCaptureScreenshotsFor().equalsIgnoreCase("Pass"))
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
//
//}
