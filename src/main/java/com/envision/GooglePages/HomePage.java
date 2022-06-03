package com.envision.GooglePages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;
import reusables.PropertiesLoader;

public class HomePage extends BasePage {

    WebDriver driver;
    HomePage(WebDriver driver){
        this.driver=driver;
    }

    public HomePage clickOnTool() throws Exception {
        clickOn(driver,"homepage.toolBtn");
        return this;

    }

    public HomePage searchText() throws Exception {
        typeInto(driver,"homepage.searchText", PropertiesLoader.getProperty("Text1"));
        return this;
    }

}
