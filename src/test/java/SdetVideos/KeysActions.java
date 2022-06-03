package SdetVideos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeysActions {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://text-compare.com/");

        WebElement input=driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
        WebElement output=driver.findElement(By.xpath("//*[@id=\"inputText2\"]"));

        input.sendKeys("ABC");
        //note: actions class works automatically where the curser is
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL);
        act.sendKeys("A");
        act.keyUp(Keys.CONTROL);
        act.perform();

    }
}
