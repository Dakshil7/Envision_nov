package SdetVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.ca/");

        Actions act = new Actions(driver);

        //RightClick Action
        act.contextClick(driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))).perform();

        //for double click
        //act.doubleClick().perform();

        //for drag and drop
        //act.dragAndDrop(source element,target element).perform();

        //for hoverover action and then click it
        //act.moveToElement(target element).click().perform();


    }
}
