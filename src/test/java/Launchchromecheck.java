import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Launchchromecheck {

    WebDriver driver;
    String path = "https://www.google.com/";

    @Test
    public void openbrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\daksh\\IdeaProjects\\QANovBatchSelenium\\src\\test\\resources\\Binaries\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path);
        driver.manage().window().maximize();
        //driver.close();
    }


}
