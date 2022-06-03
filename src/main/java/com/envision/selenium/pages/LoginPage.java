package com.envision.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import reusables.BasePage;
import reusables.PropertiesLoader;

public class LoginPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement clickOnLogin_PF;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement enterPassword_PF;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement enterUsername_PF;


    //for using page factory you have to add 1 line
    public LoginPage(WebDriver driver){
        this.driver = driver;

        //added line is written below
        PageFactory.initElements(driver,this);
    }


    public LoginPage launchURL(){
        driver.get(PropertiesLoader.getProperty("URL"));
        return this;
    }


    public LoginPage enterPassword() throws Exception {
        //driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PropertiesLoader.getProperties("password"));
        typeInto(driver,"login.password",PropertiesLoader.getProperty("password"));
        return this;
    }

    ////This mehod is Pagefactory method, it required only web element which we define at the beginning
    public LoginPage enterPassword_PF() throws Exception {
        //driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(PropertiesLoader.getProperties("password"));
        typeInto(enterPassword_PF,PropertiesLoader.getProperty("password"));
        return this;
    }

    public LoginPage enterUserName() throws Exception {
       // driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(findPropertiesFromUATFile(driver,"username"));
        typeInto(driver,"login.username",PropertiesLoader.getProperty("username"));
        return this;
    }

    //This mehod is Pagefactory method, it required only web element which we define at the beginning
    public LoginPage enterUserName_PF() throws Exception {
        // driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(findPropertiesFromUATFile(driver,"username"));
        typeInto(enterUsername_PF,PropertiesLoader.getProperty("username"));
        return this;
    }

    public HomePage clickLoginBtn() throws Exception {
        //driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        clickOn(driver,"login.loginbtn");
        return new HomePage(driver);
    }

    //This mehod is Pagefactory method, it required only web element which we define at the beginning
    public HomePage clickLoginBtn_PF() throws Exception {
        //driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        clickOn(clickOnLogin_PF);
        return new HomePage(driver);
    }

    public boolean checkIfLogOutSuccessful(){
        boolean logoutSuccessful = driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        return logoutSuccessful;
    }
}
