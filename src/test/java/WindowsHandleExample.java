import reusables.BasePage;
import reusables.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsHandleExample extends BaseTest {

    @Test
    public void testSwitchWindows() throws Exception {
        driver.get("https://demoqa.com/browser-windows");
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id =\"tabButton\"]"));
        newTabButton.click();
        BasePage.switchToWindow(1, driver);
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/sample"));
        driver.close();
        BasePage.switchToWindow(0,driver);


    }
}
