package LoginTest;

import reusables.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginGoogle extends BaseTest {




    @Test
    public void Test1(){
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("google"));
        System.out.println(title);
    }



}
