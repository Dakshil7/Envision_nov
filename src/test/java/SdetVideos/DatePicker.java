package SdetVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Month;
import java.time.Year;
import java.util.concurrent.TimeUnit;

public class DatePicker {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.redbus.com/");
        driver.findElement(By.xpath("//*[@id=\"cookie-root\"]/div[2]/div/div/button[1]")).click();

        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

        String date = "7";
        String month = "Mar";
        String year = "2025";
        //String monthYear = driver.findElement(By.xpath("//div[@class='sc-csuQGl iFJIRj']/div[2]")).getText();
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='sc-csuQGl iFJIRj']/div[2]")).getText();
            String[] monthYearSplit = monthYear.split(" ");
            String Month = monthYearSplit[0];
            String Year = monthYearSplit[1];

            if (Month.equalsIgnoreCase(month) && Year.equalsIgnoreCase(year))
                break;
            else
                driver.findElement(By.xpath("//*[@id=\"rdc-root\"]/div/div[1]/div/div[2]/div/div/div[1]/div[3]")).click();

        }
    }
    //WebDriverManager
}
