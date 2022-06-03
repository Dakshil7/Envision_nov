package SdetVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] args) throws IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        


        driver.get("https://www.msn.com/en-ca/?ocid=wispr&pc=u477");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\daksh\\IdeaProjects\\QANovBatchSelenium\\src\\test\\resources\\Screenshots\\sdetfullSc.png");
        FileUtils.copyFile(src,dest);


        //Webelement itselft has getscreenshotAs method so whenever we need to find screen shot of particular element
        //we can use elemnt.getscreenshotAs method
//        WebElement element= driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]"));
//        File src1 = element.getScreenshotAs(OutputType.FILE);
//        File dest1 = new File("C:\\Users\\daksh\\IdeaProjects\\QANovBatchSelenium\\src\\test\\resources\\Screenshots\\sdetElement.png");
//        FileUtils.copyFile(src1,dest1);
        driver.close();
    }
}
