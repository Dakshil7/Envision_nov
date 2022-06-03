package Envision.Selenium.Class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumClass_7 {

    //HTML TABLE
    //Get Country names which have size/length less than 5
    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\daksh\\IdeaProjects\\QANovBatchSelenium\\src\\test\\resources\\Binaries\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id ='customers']/tbody/tr"));

        for(int i=2;i<=tableElements.size();i++){
            String xPath = "//table[@id ='customers']/tbody/tr["+i+"]/td[3]";
            WebElement country = (driver.findElement(By.xpath(xPath)));
            String countryText = country.getText();
            if(countryText.length()<=5){
                System.out.println(countryText);
            }

        }
        driver.close();
    }

}
