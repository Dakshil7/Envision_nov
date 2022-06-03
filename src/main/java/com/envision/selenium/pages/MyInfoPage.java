package com.envision.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import reusables.BasePage;

public class MyInfoPage extends BasePage {
    WebDriver driver;

    MyInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkIfYouArenOnMyInfoPage(){
        boolean checkMyInfoURL = driver.getCurrentUrl().equalsIgnoreCase
                ("https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails");
        return checkMyInfoURL;
    }

    public boolean checkFirstNameDisplayed(){
        boolean nameVerification = driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).
                getAttribute("value").contains("Paul");
        return nameVerification;
    }

    public boolean checkLastNameDisplayed(){
        boolean LastNameVerification = driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).
                getAttribute("value").contains("Collings");
        return LastNameVerification;
    }

    public MyInfoPage clickWelcomeBtn() throws Exception {
        //driver.findElement(By.xpath("//a[@id='welcome']")).click();
        clickOn(driver,"myinfo.welcomebtn");
        return this;
    }

    public LoginPage clickLogOut() throws Exception {

        //driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
        clickOn(driver,"myinfo.logoutbtn");
        return new LoginPage(driver);
    }
}
