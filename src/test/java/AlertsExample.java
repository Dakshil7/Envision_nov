import reusables.BasePage;
import reusables.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertsExample extends BaseTest {

    @Test
    public void testSwitchWindows() throws InterruptedException {
        driver.get("https://www.booking.com/city/dk/oby.en.html?aid=309261&label=msn-nGJ0JXKnq8gvsBjR4R_mZw-80195731281374:tikwd-80195846438914:loc-32:neo:mte:lp163395:dec:qsairbnb%20rentals&utm_campaign=Denmark&utm_medium=cpc&utm_source=bing&utm_term=nGJ0JXKnq8gvsBjR4R_mZw&msclkid=bf488d6f7c1a16fd03d6ef09a4ed004e");
        BasePage.scrollDown(driver);
        Thread.sleep(5000);
        BasePage.scrollUp(driver);
        Thread.sleep(3000);
        BasePage.scrollToElement(driver,driver.findElement(By.xpath("//button[@class = 'bui-link bui-link--primary js-link']")));
        Thread.sleep(3000);
    }
}
