package com.envision.GooglePages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;
import reusables.PropertiesLoader;

public class LoginPage extends BasePage {

        WebDriver driver;
        public LoginPage(WebDriver driver){
            this.driver = driver;
        }


    public LoginPage launchURL() throws Exception {
        driver.get(PropertiesLoader.getProperty("URL"));
        //Thread.sleep(3000);
        return this;
    }

    public LoginPage enterText() throws Exception {
            typeInto(driver,"login.enterText","abc");
            return this;
    }

    public HomePage clickOnSearch() throws Exception {
            clickOn(driver,"login.searchBtn");
            return new HomePage(driver);
    }
}
