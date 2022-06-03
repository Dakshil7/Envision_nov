package com.envision.AutomationPractice.pages;

import org.openqa.selenium.Alert;
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
        return this;
    }

    public LoginPage clickSignIn() throws Exception {
        clickOn(driver,"login.signin");
        return this;
    }

    public LoginPage enterPassword() throws Exception {
        typeInto(driver,"login.password",PropertiesLoader.getProperty("password"));
       //typeInto(driver,"login.password",password);
        return this;
    }

    public LoginPage enterEmail() throws Exception {
        typeInto(driver,"login.email",PropertiesLoader.getProperty("email"));
        return this;
    }

    public HomePage clickSubmit() throws Exception {
        clickOn(driver,"login.signinbtn");
        return new HomePage(driver);
    }
}
