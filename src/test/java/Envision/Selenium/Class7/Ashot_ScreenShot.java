package Envision.Selenium.Class7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Ashot_ScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.findElement(By.xpath("//button[text()='OK']")).click();

        //To give unique name to screenshot image we create date formate with the seconds
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss")).toString();

        //Define the destination of file
        File destination = new File(".\\src\\test\\resources\\Screenshots" + date + ".png");

        //Taking the screenshot
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
                takeScreenshot(driver);

        //Write the image name
        ImageIO.write(screenshot.getImage(), "jpg", destination);
        driver.close();




    }
}
