package SdetVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SDET1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.1.1");
        Thread.sleep(2000);
        String att =driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/a/picture/img")).getText();
        System.out.println(att);
//        driver.get("https://www.youtube.com/watch?v=tJNpTj14-Rg&list=PLUDwpEzHYYLtEENXAFbVPrLeLNHM6OLk7&index=5");
//        Thread.sleep(2000);
//        driver.navigate().back();
    }
}
