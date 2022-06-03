package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;

public class HomePage extends BasePage {
    WebDriver driver;
    HomePage(WebDriver driver){
        this.driver=driver;
    }

    public TshirtPage clickOnTshirts() throws Exception {
        clickOn(driver,"homepage.tshirt");
        return new TshirtPage(driver);
    }
}
