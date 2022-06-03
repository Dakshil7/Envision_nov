package com.envision.AutomationPractice.pages;

import org.openqa.selenium.WebDriver;
import reusables.BasePage;
import reusables.PropertiesLoader;

public class LoginPageWithDataProvider extends BasePage {
    WebDriver driver;
    public LoginPageWithDataProvider(WebDriver driver){
        this.driver = driver;
    }

    public LoginPageWithDataProvider launchURL() throws Exception {
        driver.get(PropertiesLoader.getProperty("URL"));
        return this;
    }

    public LoginPageWithDataProvider clickSignIn() throws Exception {
        clickOn(driver,"login.signin");
        return this;
    }

    public LoginPageWithDataProvider enterPassword(String password) throws Exception {
        typeInto(driver,"login.password",password);
        return this;
    }

    public LoginPageWithDataProvider enterEmail(String email) throws Exception {
        typeInto(driver,"login.email",email);
        return this;
    }

    public HomePage clickSubmit() throws Exception {
        clickOn(driver,"login.signinbtn");
        return new HomePage(driver);
    }
}
