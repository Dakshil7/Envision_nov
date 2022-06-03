package Envision.Selenium.Class7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Slider {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //We can use webdrivermanager instead of setting up path of browser drivers
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("https://jqueryui.com/slider/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));

        //remember to find width of slider
        //to do that first use .getsize() and then .getWidth()
        int width = slider.getSize().getWidth();
        System.out.println(width);

        Thread.sleep(3000);
        Actions action=new Actions(driver);


        //i forget to put .perform() method in action class
        action.dragAndDropBy(slider,width/8,0).perform();
        Thread.sleep(5000);

        driver.close();


    }

}
